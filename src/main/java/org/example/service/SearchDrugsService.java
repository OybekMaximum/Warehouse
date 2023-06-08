package org.example.service;

import org.example.entity.Drugs;

import java.util.List;

public class SearchDrugsService {

    public void searchDrugs(List<Drugs> inventory, String parameter, String value, List<Drugs> results) {
        for (Drugs drugs : inventory) {
            switch (parameter) {
                case "id" -> {
                    if (drugs.getId() == Integer.parseInt(value)) {
                        results.add(drugs);
                    }
                }
                case "name" -> {
                    if (drugs.getDrugName().toLowerCase().contains(value)) {
                        results.add(drugs);
                    }
                }
                case "category" -> {
                    if (drugs.getCategory().toLowerCase().contains(value)) {
                        results.add(drugs);
                    }
                }
                case "price" -> {
                    if (drugs.getDrugPrice() == Double.parseDouble(value)) {
                        results.add(drugs);
                    }
                }
                case "quantity" -> {
                    if (drugs.getDrugQuantity() == Integer.parseInt(value)) {
                        results.add(drugs);
                    }
                }
                default -> {
                    System.out.println("Invalid search parameter.");
                    return;
                }
            }
        }
        if (results.isEmpty()) {
            System.out.println("No products found.");
            return;
        }
        System.out.println("Search results:");
        for (Drugs drugs : results) {
            System.out.println(drugs);
        }
    }
}