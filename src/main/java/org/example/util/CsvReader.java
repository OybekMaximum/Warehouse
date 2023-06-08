package org.example.util;

import org.example.entity.Drugs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {
    public static List<Drugs> getDrugs() {
        List<Drugs> inventory = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/DrugDao.csv"))) {
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
