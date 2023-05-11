package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

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

    public static void listProducts(List<Product> inventory) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter sort order (ID, name, category, price, or quantity): ");
        String order = scanner.nextLine().trim().toLowerCase();
        List<Product> sorted = new ArrayList<>(inventory);
        switch (order) {
            case "id":
                Collections.sort(sorted, Comparator.comparingInt(Product::getId));
                break;
            case "name":
                Collections.sort(sorted, Comparator.comparing(Product::getName));
                break;
            case "category":
                Collections.sort(sorted, Comparator.comparing(Product::getCategory));
                break;
            case "price":
                Collections.sort(sorted, Comparator.comparingDouble(Product::getPrice));
                break;
            case "quantity":
                Collections.sort(sorted, Comparator.comparingInt(Product::getQuantity));
                break;
            default:
                System.out.println("Invalid sort order.");
                return;
        }
        System.out.println("Product list:");
        for (Product product : sorted) {
            System.out.println(product);
        }
    }

    public static void searchProducts(List<Product> inventory) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter search parameter (ID, name, category, price, or quantity): ");
        String parameter = scanner.nextLine().trim().toLowerCase();
        System.out.print("Enter search value: ");
        String value = scanner.nextLine().trim().toLowerCase();
        List<Product> results = new ArrayList<>();
        for (Product product : inventory) {
            switch (parameter) {
                case "id":
                    if (product.getId() == Integer.parseInt(value)) {
                        results.add(product);
                    }
                    break;
                case "name":
                    if (product.getName().toLowerCase().contains(value)) {
                        results.add(product);
                    }
                    break;
                case "category":
                    if (product.getCategory().toLowerCase().contains(value)) {
                        results.add(product);
                    }
                    break;
                case "price":
                    if (product.getPrice() == Double.parseDouble(value)) {
                        results.add(product);
                    }
                    break;
                case "quantity":
                    if (product.getQuantity() == Integer.parseInt(value)) {
                        results.add(product);
                    }
                    break;
                default:
                    System.out.println("Invalid search parameter.");
                    return;
            }
        }
        if (results.isEmpty()) {
            System.out.println("No products found.");
            return;
        }
        System.out.println("Search results:");
        for (Product product : results) {
            System.out.println(product);
        }
    }


}
