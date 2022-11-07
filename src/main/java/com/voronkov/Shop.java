package com.voronkov;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Shop {
    public static void main(String[] args) {
        ApplicationContext context = new  AnnotationConfigApplicationContext("com.voronkov");
        Cart cart = context.getBean(Cart.class);
        Cart cartAnother = context.getBean(Cart.class);

        cart.showCart();
        System.out.println("---");
        cartAnother.showCart();
        System.out.println("***");
        System.out.println();

        cart.edit(2);
        cart.edit(2);
        cart.edit(5);
        cart.edit(5);
        cart.edit(1);
        cart.edit(1);
        cart.edit(3);
        cart.edit(4);
        cart.edit(0);

        cartAnother.edit(3);
        cartAnother.edit(4);
        cartAnother.edit(0);


        cart.showCart();
        System.out.println("---");
        cartAnother.showCart();
        System.out.println("***");
        System.out.println();

        cart.delete(5);
        cart.delete(5);
        cart.delete(4);
        cart.delete(4);
        cart.delete(3);

        cartAnother.delete(0);

        cart.showCart();
        System.out.println("---");
        cartAnother.showCart();
        System.out.println("***");
        System.out.println();

    }
}
