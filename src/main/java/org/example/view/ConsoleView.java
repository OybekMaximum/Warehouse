package org.example.view;

import static org.example.controller.ConsoleViewController.control;

public class ConsoleView {

    public static void main(String[] args) {
        System.out.println("Medication Warehouse (Created on May 11, 2023)");
        System.out.println("Developer: Oybek Tulaboev (treyktoriya@gmail.com)");


        System.out.println("\nAvailable commands:");
        System.out.println("1. Search products");
        System.out.println("2. List all products");
        System.out.println("3. Exit");
        control();
    }
}