public class ClothingItem {
    protected int itemId;
    protected String name;
    protected String size;
    protected double price;
    protected String brand;

    public ClothingItem(int itemId, String name, String size, double price, String brand) {
        this.itemId = itemId;
        this.name = name;
        this.size = size;
        this.price = price;
        this.brand = brand;
    }

    public ClothingItem() {
        this.name = "Unknown Item";
        this.price = 0.0;
        this.size = "Unknown";
        this.brand = "Unknown";
    }

    public int getItemId() { return itemId; }
    public void setItemId(int itemId) { this.itemId = itemId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getSize() { return size; }
    public void setSize(String size) { this.size = size; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public void applyDiscount(double percentage) {
        this.price = this.price * (1 - percentage / 100);
    }

    public String getCategory() {
        return "General Clothing";
    }

    public void performAction() {
        System.out.println("Processing " + name);
    }

    @Override
    public String toString() {
        return String.format("[%s] ID: %d | Name: %-10s | Price: %.2f KZT",
                getCategory(), itemId, name, price);
    }
}