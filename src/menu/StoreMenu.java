package menu;

import model.*;
import database.ClothingDAO;
import exception.InvalidInputException;
import java.util.Scanner;
import java.util.List;

public class StoreMenu implements Menu {
    private Scanner scanner = new Scanner(System.in);
    private ClothingDAO dao = new ClothingDAO();

    @Override
    public void run() {
        while (true) {
            System.out.println("\n--- CLOTHING STORE MENU ---");
            System.out.println("1. Add Shirt");
            System.out.println("2. Add Jacket");
            System.out.println("3. View All Items");
            System.out.println("4. Update Item");
            System.out.println("5. Delete Item");
            System.out.println("6. Search by Name");
            System.out.println("7. Search by Price Range");
            System.out.println("0. Exit");

            try {
                String choice = scanner.nextLine();
                switch (choice) {
                    case "1" -> addShirt();
                    case "2" -> addJacket();
                    case "3" -> dao.getAllItems().forEach(System.out::println);
                    case "4" -> updateFlow();
                    case "5" -> deleteFlow();
                    case "6" -> searchByNameFlow();
                    case "7" -> searchByPriceFlow();
                    case "0" -> System.exit(0);
                    default -> System.out.println("Invalid choice!");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private void addShirt() {
        System.out.print("Name: "); String n = scanner.nextLine();
        System.out.print("Price: "); double p = Double.parseDouble(scanner.nextLine());
        System.out.print("Size: "); String s = scanner.nextLine();
        System.out.print("Brand: "); String b = scanner.nextLine();
        System.out.print("Stock: "); int st = Integer.parseInt(scanner.nextLine());
        System.out.print("Material: "); String m = scanner.nextLine();

        dao.insertItem(new Shirt(0, n, s, p, b, st, m));
        System.out.println("Shirt added!");
    }

    private void addJacket() {
        System.out.print("Name: "); String n = scanner.nextLine();
        System.out.print("Price: "); double p = Double.parseDouble(scanner.nextLine());
        System.out.print("Size: "); String s = scanner.nextLine();
        System.out.print("Brand: "); String b = scanner.nextLine();
        System.out.print("Stock: "); int st = Integer.parseInt(scanner.nextLine());
        System.out.print("Is Waterproof (true/false): "); boolean w = Boolean.parseBoolean(scanner.nextLine());

        dao.insertItem(new Jacket(0, n, s, p, b, st, w));
        System.out.println("Jacket added!");
    }

    private void updateFlow() {
        System.out.print("Enter ID to update: ");
        int id = Integer.parseInt(scanner.nextLine());
        ClothingItem item = dao.getItemById(id);

        if (item == null) {
            System.out.println("Item not found!");
            return;
        }

        System.out.println("Current: " + item);
        System.out.print("New Name (Enter to skip): ");
        String n = scanner.nextLine();
        if (!n.isEmpty()) item.setName(n);

        System.out.print("New Price (Enter to skip): ");
        String pStr = scanner.nextLine();
        if (!pStr.isEmpty()) item.setPrice(Double.parseDouble(pStr));

        dao.updateItem(item);
        System.out.println("Updated successfully!");
    }

    private void deleteFlow() {
        System.out.print("Enter ID to delete: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Are you sure? (y/n): ");
        if (scanner.nextLine().equalsIgnoreCase("y")) {
            if (dao.deleteItem(id)) {
                System.out.println("Deleted.");
            } else {
                System.out.println("ID not found.");
            }
        }
    }

    private void searchByNameFlow() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        List<ClothingItem> results = dao.searchByName(name);
        if (results.isEmpty()) {
            System.out.println("Nothing found.");
        } else {
            results.forEach(System.out::println);
        }
    }

    private void searchByPriceFlow() {
        try {
            System.out.print("Min price: ");
            double min = Double.parseDouble(scanner.nextLine());
            System.out.print("Max price: ");
            double max = Double.parseDouble(scanner.nextLine());

            List<ClothingItem> results = dao.searchByPriceRange(min, max);
            if (results.isEmpty()) {
                System.out.println("No items in this range.");
            } else {
                results.forEach(System.out::println);
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter valid numbers!");
        }
    }
}