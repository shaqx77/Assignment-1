package model;

public abstract class ClothingItem {
    protected int itemId;
    protected String name;
    protected String size;
    protected double price;
    protected String brand;

    public ClothingItem(int itemId, String name, String size, double price, String brand) {
        setItemId(itemId);
        setName(name);
        setSize(size);
        setPrice(price);
        setBrand(brand);
    }

    public abstract void performAction();
    public abstract String getCategory();

    public int getItemId() { return itemId; }
    public void setItemId(int itemId) {
        if (itemId <= 0) throw new IllegalArgumentException("ID must be positive");
        this.itemId = itemId;
    }

    public String getName() { return name; }
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) throw new IllegalArgumentException("Name cannot be empty");
        this.name = name;
    }

    public String getSize() { return size; }
    public void setSize(String size) {
        if (size == null || size.trim().isEmpty()) throw new IllegalArgumentException("Size cannot be empty");
        this.size = size;
    }

    public double getPrice() { return price; }
    public void setPrice(double price) {
        if (price < 0) throw new IllegalArgumentException("Price cannot be negative");
        this.price = price;
    }

    public String getBrand() { return brand; }
    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return String.format("[%s] ID: %d | Name: %-10s | Price: %.2f KZT",
                getCategory(), itemId, name, price);
    }
}