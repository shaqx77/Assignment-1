package menu;

import model.*;
import java.util.ArrayList;
import java.util.Scanner;

public class StoreMenu implements Menu {
    private ArrayList<ClothingItem> inventory = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public StoreMenu() {
        inventory.add(new Shirt(101, "Cotton Tee", "M", 5000, "Nike", "Cotton"));
        inventory.add(new Jacket(201, "Winter Coat", "L", 25000, "NorthFace", true));
    }

    @Override
    public void displayMenu() {
        System.out.println("\n--- CLOTHING STORE MANAGEMENT ---");
        System.out.println("1. Add Shirt");
        System.out.println("2. Add Jacket");
        System.out.println("3. View All Items");
        System.out.println("4. Perform Actions");
        System.out.println("0. Exit");
        System.out.print("Choice: ");
    }

    @Override
    public void run() {
        boolean running = true;
        while (running) {
            displayMenu();
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1 -> addShirt();
                    case 2 -> addJacket();
                    case 3 -> viewItems();
                    case 4 -> demoActions();
                    case 0 -> running = false;
                    default -> System.out.println("Invalid choice!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid number.");
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private void addShirt() {
        try {
            System.out.print("ID: "); int id = Integer.parseInt(scanner.nextLine());
            System.out.print("Name: "); String name = scanner.nextLine();
            System.out.print("Price: "); double price = Double.parseDouble(scanner.nextLine());
            System.out.print("Material: "); String mat = scanner.nextLine();
            inventory.add(new Shirt(id, name, "M", price, "Brand", mat));
            System.out.println("Shirt added successfully!");
        } catch (IllegalArgumentException e) {
            System.out.println("Validation Error: " + e.getMessage());
        }
    }

    private void addJacket() {
        try {
            System.out.print("ID: "); int id = Integer.parseInt(scanner.nextLine());
            System.out.print("Name: "); String name = scanner.nextLine();
            System.out.print("Price: "); double price = Double.parseDouble(scanner.nextLine());
            System.out.print("Waterproof (true/false): "); boolean water = Boolean.parseBoolean(scanner.nextLine());
            inventory.add(new Jacket(id, name, "L", price, "Brand", water));
            System.out.println("Jacket added successfully!");
        } catch (IllegalArgumentException e) {
            System.out.println("Validation Error: " + e.getMessage());
        }
    }

    private void viewItems() {
        for (ClothingItem item : inventory) {
            System.out.println(item);
        }
    }

    private void demoActions() {
        for (ClothingItem item : inventory) {
            item.performAction();
        }
    }
}