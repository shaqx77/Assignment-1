public class Main {
    public static void main(String[] args) {
        System.out.println("Clothing Store Management System");
        System.out.println();

        ClothingItem item1 = new ClothingItem(101, "Jacket", "L", 25000.0, "Zara");
        ClothingItem item2 = new ClothingItem(102, "Jeans", "M", 12000.0, "Bershka");
        ClothingItem item3 = new ClothingItem();

        Customer cust1 = new Customer(501, "Kylian Mbappe", "M", 600);
        Order ord1 = new Order(1001, "Kylian Mbappe", 25000.0, "Pending");

        System.out.println("Initial Objects");
        System.out.println(item1);
        System.out.println(item2);
        System.out.println(item3);
        System.out.println(cust1);
        System.out.println(ord1);
        System.out.println();

        System.out.println("Testing Getters");
        System.out.println("Item 1 Brand: " + item1.getBrand());
        System.out.println("Customer 1 Name: " + cust1.getName());
        System.out.println();

        System.out.println("Testing Setters");
        item3.setName("T-Shirt");
        item3.setPrice(8500.0);
        item3.setSize("One Size");
        System.out.println("Updated Item 3: " + item3);
        System.out.println();

        System.out.println("Testing Additional Methods ");
        System.out.println(item1.getName() + " is premium: " + item1.isPremium());
        System.out.println("Applying 10% discount to " + item1.getName());
        item1.applyDiscount(10);
        System.out.println("New Price: " + item1.getPrice());
        System.out.println();

        System.out.println(cust1.getName() + " is VIP: " + cust1.isVIP());
        cust1.addPoints(50);
        System.out.println("New Points: " + cust1.getPoints());
        System.out.println();

        System.out.println("Completing order " + ord1.getOrderId());
        ord1.completeOrder();
        System.out.println("Order Status: " + ord1.getStatus());


    }
}