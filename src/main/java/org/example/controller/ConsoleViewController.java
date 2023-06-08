package org.example.controller;

import org.example.entity.Drugs;
import org.example.service.ListDrugsService;
import org.example.service.SearchDrugsService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.example.dao.CsvParser.loadInventory;

public class ConsoleViewController {

    private final SearchDrugsService drugsService = new SearchDrugsService();
    private final ListDrugsService listDrugsService = new ListDrugsService();

    public void control() {
        List<Drugs> drugs = loadInventory();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("\nEnter command (1-3): ");
            int command = scanner.nextInt();

            scanner.nextLine();
            switch (command) {
                case 1 -> {
                    System.out.print("Enter search parameter (ID, name, category, price, or quantity): ");
                    String parameter = scanner.nextLine().trim().toLowerCase();
                    System.out.print("Enter search value: ");
                    String value = scanner.nextLine().trim().toLowerCase();
                    List<Drugs> results = new ArrayList<>();
                    drugsService.searchDrugs(drugs, parameter, value, results);
                }
                case 2 -> {
                    System.out.print("Enter sort order (ID, name, category, price, or quantity): ");
                    String order = scanner.nextLine().trim().toLowerCase();
                    listDrugsService.listDrug(order, drugs);
                }
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