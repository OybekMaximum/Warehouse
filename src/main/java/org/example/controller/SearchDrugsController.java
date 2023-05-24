package org.example.controller;

import org.example.dao.Drugs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.example.service.SearchDrugsService.searchDrugs;
import static org.example.view.SearchDrugsView.askSearchParameter;
import static org.example.view.SearchDrugsView.askSearchValue;

public class SearchDrugsController {
    public static void searchProducts(List<Drugs> inventory) {
        Scanner scanner = new Scanner(System.in);
        askSearchParameter();
        String parameter = scanner.nextLine().trim().toLowerCase();
        askSearchValue();
        String value = scanner.nextLine().trim().toLowerCase();
        List<Drugs> results = new ArrayList<>();
        searchDrugs(inventory, parameter, value, results);
    }

}