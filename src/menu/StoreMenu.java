package menu;

import model.*;
import database.ClothingDAO;
import exception.InvalidInputException;
import java.util.Scanner;

public class StoreMenu implements Menu {
    private Scanner scanner = new Scanner(System.in);
    private ClothingDAO dao = new ClothingDAO();

    @Override
    public void run() {
        while (true) {
            System.out.println("\n1. Add Shirt  \n2. Add Jacket  \n3. View All  \n4. Update  \n5. Delete  \n6. Search  \n10. Exit");
            try {
                String choice = scanner.nextLine();
                switch (choice) {
                    case "1" -> addShirt();
                    case "2" -> addJacket();
                    case "3" -> dao.getAllItems().forEach(System.out::println);
                    case "4" -> updateFlow();
                    case "5" -> deleteFlow();
                    case "6" -> searchFlow();
                    case "0" -> System.exit(0);
                    default -> System.out.println("Invalid choice!");
                }
            } catch (InvalidInputException | NumberFormatException e) {
                System.out.println("Input error: " + e.getMessage());
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
        System.out.print("ID to update: ");
        int id = Integer.parseInt(scanner.nextLine());
        ClothingItem item = dao.getItemById(id);
        if (item == null) {
            System.out.println("Not found!");
            return;
        }

        System.out.println("Current: " + item);
        System.out.print("New Name [Enter to skip]: ");
        String n = scanner.nextLine();
        if (!n.isEmpty()) item.setName(n);

        System.out.print("New Price [Enter to skip]: ");
        String pStr = scanner.nextLine();
        if (!pStr.isEmpty()) item.setPrice(Double.parseDouble(pStr));

        dao.updateItem(item);
        System.out.println("Updated!");
    }

    private void deleteFlow() {
        System.out.print("ID to delete: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Are you sure? (y/n): ");
        if (scanner.nextLine().equalsIgnoreCase("y")) {
            dao.deleteItem(id);
            System.out.println("Deleted.");
        }
    }

    private void searchFlow() {
        System.out.print("Enter name: ");
        dao.searchByName(scanner.nextLine()).forEach(System.out::println);
    }
}