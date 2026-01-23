package model;

public class Jacket extends ClothingItem {
    private boolean isWaterproof;

    public Jacket(int itemId, String name, String size, double price, String brand, boolean isWaterproof) {
        super(itemId, name, size, price, brand);
        this.isWaterproof = isWaterproof;
    }

    @Override
    public void performAction() {
        System.out.println("Checking zippers on the jacket: " + name);
    }

    @Override
    public String getCategory() {
        return "Jacket";
    }
}