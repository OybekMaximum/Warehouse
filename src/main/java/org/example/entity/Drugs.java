package org.example.entity;

public class Drugs {
    private int id;
    private String drugName;
    private String category;
    private double drugPrice;
    private int drugQuantity;

    public Drugs(int id, String drugName, String category, double drugPrice, int drugQuantity) {
        this.id = id;
        this.drugName = drugName;
        this.category = category;
        this.drugPrice = drugPrice;
        this.drugQuantity = drugQuantity;
    }

    public int getId() {
        return id;
    }

    public String getDrugName() {
        return drugName;
    }

    public String getCategory() {
        return category;
    }

    public double getDrugPrice() {
        return drugPrice;
    }

    public int getDrugQuantity() {
        return drugQuantity;
    }

    @Override
    public String toString() {
        return String.format("%-5d%-20s%-20s%8.2f%5d", id, drugName, category, drugPrice, drugQuantity);
    }
}