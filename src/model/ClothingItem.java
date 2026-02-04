package model;

import exception.InvalidInputException;

public abstract class ClothingItem {
    private int itemId;
    private String name;
    private String size;
    private double price;
    private String brand;
    private int stockQuantity;

    public ClothingItem(int itemId, String name, String size, double price, String brand, int stockQuantity) {
        this.itemId = itemId;
        this.name = name;
        this.size = size;
        setPrice(price);
        this.brand = brand;
        setStockQuantity(stockQuantity);
    }

    public int getItemId() { return itemId; }
    public String getName() { return name; }
    public String getSize() { return size; }
    public double getPrice() { return price; }
    public String getBrand() { return brand; }
    public int getStockQuantity() { return stockQuantity; }

    public void setName(String name) { this.name = name; }

    public void setPrice(double price) {
        if (price < 0) throw new InvalidInputException("Price cannot be negative!");
        this.price = price;
    }

    public void setStockQuantity(int stockQuantity) {
        if (stockQuantity < 0) throw new InvalidInputException("Stock cannot be negative!");
        this.stockQuantity = stockQuantity;
    }

    public abstract String getCategory();
    public abstract void performAction();

    @Override
    public String toString() {
        return String.format("ID: %d | [%s] %-15s | %-10s | Price: %.2f | Stock: %d",
                itemId, getCategory(), name, brand, price, stockQuantity);
    }
}