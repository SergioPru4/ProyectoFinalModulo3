package org.example.models;

public class Product {
    private String name;
    private String price;

    public String getNameProduct() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
