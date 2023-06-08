package org.example.view;


import org.example.controller.ConsoleViewController;

public class ConsoleView {

    private final ConsoleViewController control = new ConsoleViewController();

    public static void main(String[] args) {
        System.out.println("Medication Warehouse (Created on May 11, 2023)");
        System.out.println("Developer: Oybek Tulaboev (treyktoriya@gmail.com)");


        System.out.println("\nAvailable commands:");
        System.out.println("1. Search products");
        System.out.println("2. List all products");
        System.out.println("3. Exit");

        ConsoleView consoleView = new ConsoleView();
        consoleView.start();
    }

    public void start() {
        control.control();
    }

}