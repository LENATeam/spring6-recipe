package com.apress.spring6recipes.court.web;

import com.apress.spring6recipes.court.domain.Member;
import com.apress.spring6recipes.court.domain.Members;
import com.apress.spring6recipes.court.service.MemberService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/members")
public class RestMemberController {

	private final MemberService memberService;

	public RestMemberController(MemberService memberService) {
		this.memberService = memberService;
	}

	@GetMapping
	public Members getRestMembers() {
		var members = new Members();
		members.addMembers(memberService.findAll());
		return members;
	}

	@GetMapping("/{memberid}")
	public ResponseEntity<Member> getMember(@PathVariable("memberid") long memberID) {
		return memberService.findById(memberID)
						.map(ResponseEntity::ok)
						.orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<Member> newMember(@Valid @RequestBody Member newMember) {
		return ResponseEntity.ok(memberService.save(newMember));
	}

	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Map<String, String> handle(MethodArgumentNotValidException ex) {
		return ex.getFieldErrors().stream()
						.collect(
								Collectors.toMap(FieldError::getField,
												 FieldError::getDefaultMessage));
	}
}
