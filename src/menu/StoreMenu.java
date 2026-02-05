package menu;

import model.*;
import database.ClothingDAO;
import java.util.Scanner;
import java.util.List;

public class StoreMenu implements Menu {
    private ClothingDAO dao = new ClothingDAO();
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void run() {
        while (true) {
            System.out.println("\n=== CLOTHING STORE SYSTEM ===");
            System.out.println("1. Add Shirt");
            System.out.println("2. Add Jacket");
            System.out.println("3. Show All Items");
            System.out.println("4. Update Item");
            System.out.println("5. Delete Item");
            System.out.println("6. Search by Name");
            System.out.println("7. Search by Price Range");
            System.out.println("0. Exit");
            System.out.print("Action: ");

            String choice = scanner.nextLine();
            if (choice.equals("0")) break;

            try {
                switch (choice) {
                    case "1":
                        addShirt();
                        break;
                    case "2":
                        addJacket();
                        break;
                    case "3":
                        dao.getAllItems().forEach(System.out::println);
                        break;
                    case "4":
                        updateFlow();
                        break;
                    case "5":
                        deleteFlow();
                        break;
                    case "6":
                        searchByNameFlow();
                        break;
                    case "7":
                        searchByPriceFlow();
                        break;
                    default:
                        System.out.println("Invalid choice!");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private String readString(String label) {
        System.out.print(label);
        String input = scanner.nextLine();
        if (input.matches("-?\\d+(\\.\\d+)?")) {
            throw new IllegalArgumentException(label.replace(": ", "") + " cannot be a number");
        }
        return input;
    }

    private double readDouble(String label) {
        System.out.print(label);
        try {
            return Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(label.replace(": ", "") + " must be a numeric value");
        }
    }

    private int readInt(String label) {
        System.out.print(label);
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(label.replace(": ", "") + " must be an integer number");
        }
    }

    private void addShirt() {
        String n = readString("Name: ");
        double p = readDouble("Price: ");
        String s = readString("Size: ");
        String b = readString("Brand: ");
        int st = readInt("Stock: ");
        String m = readString("Material: ");

        dao.insertItem(new Shirt(0, n, s, p, b, st, m));
        System.out.println("Shirt added!");
    }

    private void addJacket() {
        String n = readString("Name: ");
        double p = readDouble("Price: ");
        String s = readString("Size: ");
        String b = readString("Brand: ");
        int st = readInt("Stock: ");
        System.out.print("Is Waterproof (true/false): ");
        boolean w = Boolean.parseBoolean(scanner.nextLine());

        dao.insertItem(new Jacket(0, n, s, p, b, st, w));
        System.out.println("Jacket added!");
    }

    private void updateFlow() {
        int id = readInt("ID to update: ");
        ClothingItem item = dao.getItemById(id);
        if (item == null) {
            System.out.println("Item not found!");
            return;
        }

        System.out.println("Current: " + item);
        System.out.print("New Name (skip): ");
        String n = scanner.nextLine();
        if (!n.isEmpty()) {
            if (n.matches("-?\\d+(\\.\\d+)?")) throw new IllegalArgumentException("Name cannot be a number");
            item.setName(n);
        }

        System.out.print("New Price (skip): ");
        String pStr = scanner.nextLine();
        if (!pStr.isEmpty()) {
            try {
                item.setPrice(Double.parseDouble(pStr));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Price must be numeric");
            }
        }

        if (dao.updateItem(item)) System.out.println("Updated!");
    }

    private void deleteFlow() {
        int id = readInt("ID to delete: ");
        System.out.print("Confirm (y/n): ");
        if (scanner.nextLine().equalsIgnoreCase("y")) {
            if (dao.deleteItem(id)) System.out.println("Deleted.");
            else System.out.println("ID not found.");
        }
    }

    private void searchByNameFlow() {
        String name = readString("Search Name: ");
        List<ClothingItem> res = dao.searchByName(name);
        if (res.isEmpty()) System.out.println("Nothing found.");
        else res.forEach(System.out::println);
    }

    private void searchByPriceFlow() {
        double min = readDouble("Min Price: ");
        double max = readDouble("Max Price: ");
        List<ClothingItem> res = dao.searchByPriceRange(min, max);
        if (res.isEmpty()) System.out.println("No items in range.");
        else res.forEach(System.out::println);
    }
}