package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Inventory {

    public static List<Product> loadInventory() {
        List<Product> inventory = new ArrayList<>();

        try (InputStream inputStream = Inventory.class.getResourceAsStream("/inventory.txt");
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                int id = Integer.parseInt(fields[0]);
                String name = fields[1];
                String category = fields[2];
                double price = Double.parseDouble(fields[3]);
                int quantity = Integer.parseInt(fields[4]);
                Product product = new Product(id, name, category, price, quantity);
                inventory.add(product);
            }
        } catch (IOException e) {
            System.err.println("Error reading inventory.txt file: " + e.getMessage());
        }

        return inventory;
    }

}
