package com.ibrahim;

public class Main {

    public static void main(String[] args) {
        // Testing the inheritance between base and sub classes
        Banjo banjo = new Banjo("HP",26,0.8);
        System.out.println(banjo.getClass().getSimpleName());
        System.out.println(banjo);
    }
}
