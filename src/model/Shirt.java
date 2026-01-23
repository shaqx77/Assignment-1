package model;

public class Shirt extends ClothingItem implements Washable {
    private String material;

    public Shirt(int itemId, String name, String size, double price, String brand, String material) {
        super(itemId, name, size, price, brand);
        setMaterial(material);
    }

    public void setMaterial(String material) {
        if (material == null || material.trim().isEmpty()) {
            throw new IllegalArgumentException("Material required");
        }
        this.material = material;
    }

    @Override
    public void performAction() {
        System.out.println("Displaying " + material + " shirt on a hanger.");
    }

    @Override
    public String getCategory() {
        return "Shirt";
    }

    @Override
    public void wash() {
        System.out.println("Washing " + material + " shirt at 30°C.");
    }

    @Override
    public String getWashingInstructions() {
        return "Delicate wash only.";
    }
}