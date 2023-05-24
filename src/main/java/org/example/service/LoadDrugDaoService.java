package org.example.service;

import org.example.dao.Drugs;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LoadDrugDaoService {

    public static List<Drugs> loadInventory() {
        List<Drugs> inventory = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/java/org/example/dao/DrugDao.csv"))) {
            String line = reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                int id = Integer.parseInt(fields[0]);
                String name = fields[1];
                String category = fields[2];
                double price = Double.parseDouble(fields[3]);
                int quantity = Integer.parseInt(fields[4]);
                Drugs drugs = new Drugs(id, name, category, price, quantity);
                inventory.add(drugs);
            }
        } catch (IOException e) {
            System.err.println("Error reading DrugDao.csv file: " + e.getMessage());
        }

        return inventory;
    }

}