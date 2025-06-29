package com.apress.spring6recipes.bank.web;

import com.apress.spring6recipes.bank.AccountService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class DepositControllerTests {

	private static final String TEST_ACCOUNT_NO = "1234";

	private static final double TEST_AMOUNT = 50;

	@Mock
	private AccountService accountService;

	@InjectMocks
	private DepositController depositController;

	// @Test
	// void deposit() {
	// 	// Setup
	// 	Mockito.when(accountService.getBalance(TEST_ACCOUNT_NO)).thenReturn(150.0);
	// 	ModelMap model = new ModelMap();

	// 	// Execute
	// 	String viewName = depositController.deposit(TEST_ACCOUNT_NO, TEST_AMOUNT, model);

	// 	assertEquals("success", viewName);
	// 	assertEquals(TEST_ACCOUNT_NO, model.get("accountNo"));
	// 	assertEquals(150.0, model.get("balance"));
	// }

	@Test
	void testDeposit() {

		// Setup
		Mockito.when(accountService.getBalance(TEST_ACCOUNT_NO)).thenReturn(150.0);
		Model model = new ExtendedModelMap();

		String viewName = depositController.deposit(TEST_ACCOUNT_NO, TEST_AMOUNT, model);


		assertEquals(viewName, "success");
		assertEquals(model.asMap().get("accountNo"), TEST_ACCOUNT_NO);
		assertEquals(model.asMap().get("balance"), 150.0);
	}

}
