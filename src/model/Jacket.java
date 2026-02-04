package model;

public class Jacket extends ClothingItem {
    private boolean isWaterproof;

    public Jacket(int itemId, String name, String size, double price, String brand, int stockQuantity, boolean isWaterproof) {
        super(itemId, name, size, price, brand, stockQuantity);
        this.isWaterproof = isWaterproof;
    }

    @Override
    public void performAction() {
        System.out.println("Checking zippers on the jacket: " + getName());
    }

    @Override
    public String getCategory() { return "Jacket"; }
}