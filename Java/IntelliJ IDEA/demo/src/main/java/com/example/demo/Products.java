package com.example.demo;

public class Products {
    private int id;
    private String name;
    private double amount;
    private double price;
    private String supplier;

    public Products(int id, String name, double amount, double price, String supplier) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.price = price;
        this.supplier = supplier;
    }

    public Products( String name, double amount, double price, String supplier) {

        this.name = name;
        this.amount = amount;
        this.price = price;
        this.supplier = supplier;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }
}

