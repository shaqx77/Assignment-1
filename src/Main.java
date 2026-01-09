import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<ClothingItem> inventory = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- CLOTHING STORE MANAGEMENT ---");
            System.out.println("1. Add General Clothing");
            System.out.println("2. Add Shirt");
            System.out.println("3. Add Jacket");
            System.out.println("4. View All Items (Polymorphic)");
            System.out.println("5. Perform Actions (Polymorphism Demo)");
            System.out.println("6. View Jackets Only (instanceof Demo)");
            System.out.println("0. Exit");
            System.out.print("Choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addGeneral();
                case 2 -> addShirt();
                case 3 -> addJacket();
                case 4 -> viewAll();
                case 5 -> demoPolymorphism();
                case 6 -> viewJacketsOnly();
            }
        } while (choice != 0);
    }

    private static void addGeneral() {
        System.out.print("ID: "); int id = scanner.nextInt(); scanner.nextLine();
        System.out.print("Name: "); String name = scanner.nextLine();
        System.out.print("Price: "); double price = scanner.nextDouble();
        inventory.add(new ClothingItem(id, name, "M", price, "Brand"));
    }

    private static void addShirt() {
        System.out.print("ID: "); int id = scanner.nextInt(); scanner.nextLine();
        System.out.print("Name: "); String name = scanner.nextLine();
        System.out.print("Price: "); double price = scanner.nextDouble(); scanner.nextLine();
        System.out.print("Material: "); String mat = scanner.nextLine();
        inventory.add(new Shirt(id, name, "M", price, "Brand", mat));
    }

    private static void addJacket() {
        System.out.print("ID: "); int id = scanner.nextInt(); scanner.nextLine();
        System.out.print("Name: "); String name = scanner.nextLine();
        System.out.print("Price: "); double price = scanner.nextDouble();
        System.out.print("Waterproof (true/false): "); boolean water = scanner.nextBoolean();
        inventory.add(new Jacket(id, name, "L", price, "Brand", water));
    }

    private static void viewAll() {
        for (ClothingItem item : inventory) {
            System.out.println(item);
        }
    }

    private static void demoPolymorphism() {
        for (ClothingItem item : inventory) {
            item.performAction();
        }
    }

    private static void viewJacketsOnly() {
        for (ClothingItem item : inventory) {
            if (item instanceof Jacket) {
                Jacket j = (Jacket) item;
                System.out.println(j);
                j.zipUp();
            }
        }
    }
}