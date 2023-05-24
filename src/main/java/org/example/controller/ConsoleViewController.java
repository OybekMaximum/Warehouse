package org.example.controller;

import org.example.dao.Drugs;

import java.util.List;
import java.util.Scanner;

import static org.example.controller.ListDrugsController.listProducts;
import static org.example.service.LoadDrugDaoService.loadInventory;
import static org.example.controller.SearchDrugsController.searchProducts;

public class ConsoleViewController {

    public static void control() {
        List<Drugs> drugs = loadInventory();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("\nEnter command (1-3): ");
            int command = scanner.nextInt();
            switch (command) {
                case 1 -> searchProducts(drugs);
                case 2 -> listProducts(drugs);
                case 3 -> {
                    System.out.println("Exiting application...");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid command. Please enter a valid command (1-3).");
            }
        }
    }
}