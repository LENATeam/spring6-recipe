package com.apress.spring6recipes.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;
import java.util.Locale;

@Component
public class Cachier {
    @Autowired
    private MessageSource messageSource;

    public void checkout(ShoppingCart cart) throws IOException {
        var alert = messageSource.getMessage("alert.inventory.checkout",
                new Object[] { cart.getItems(), new Date()} , Locale.US);
        System.out.println(alert);
    }
}
