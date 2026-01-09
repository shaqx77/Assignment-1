public class Shirt extends ClothingItem {
    private String material;

    public Shirt(int itemId, String name, String size, double price, String brand, String material) {
        super(itemId, name, size, price, brand);
        this.material = material;
    }

    public String getMaterial() { return material; }

    public void iron() {
        System.out.println("Ironing the " + material + " shirt.");
    }

    @Override
    public String getCategory() {
        return "Shirt";
    }

    @Override
    public void performAction() {
        System.out.println("Displaying " + material + " shirt on a hanger.");
    }

    @Override
    public String toString() {
        return super.toString() + " | Material: " + material;
    }
}