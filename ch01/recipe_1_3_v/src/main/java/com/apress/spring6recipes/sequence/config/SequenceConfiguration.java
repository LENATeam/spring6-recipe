package com.apress.spring6recipes.sequence.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.apress.spring6recipes.sequence.Sequence;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan("com.apress.spring6recipes.sequence")
public class SequenceConfiguration {

	@Bean
	public Sequence sequence() {
		var sequence = new Sequence();
		sequence.setInitial(100000);
		sequence.setSuffix("A");
		return sequence;
	}

}
