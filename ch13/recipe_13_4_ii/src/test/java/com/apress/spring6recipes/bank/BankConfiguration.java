package com.apress.spring6recipes.bank;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BankConfiguration {

	@Bean
	public InMemoryAccountDao accountDao() {
		return new InMemoryAccountDao();
	}

    @Bean
    public AccountService accountService(AccountDao accountDao) {
        return new SimpleAccountService(accountDao);
    }
}
