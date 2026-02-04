package model;

public class Shirt extends ClothingItem implements Washable {
    private String material;

    public Shirt(int itemId, String name, String size, double price, String brand, int stockQuantity, String material) {
        super(itemId, name, size, price, brand, stockQuantity);
        this.material = material;
    }

    @Override
    public void performAction() {
        System.out.println("Displaying " + material + " shirt: " + getName());
    }

    @Override
    public String getCategory() { return "Shirt"; }

    @Override
    public void wash() { System.out.println("Washing " + material + " shirt."); }

    @Override
    public String getWashingInstructions() { return "Wash at 30°C."; }
}