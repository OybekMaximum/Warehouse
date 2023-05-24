package org.example.controller;

import org.example.dao.Drugs;

import java.util.List;
import java.util.Scanner;

import static org.example.service.ListDrugsService.listDrug;
import static org.example.view.ListDrugsView.printView;

public class ListDrugsController {

    public static void listProducts(List<Drugs> inventory) {
        Scanner scanner = new Scanner(System.in);
        printView();
        String order = scanner.nextLine().trim().toLowerCase();
        listDrug(order, inventory);
    }
}