public class Customer {
    private int customerId;
    private String name;
    private String preferredSize;
    private int points;

    public Customer(int customerId, String name, String preferredSize, int points) {
        this.customerId = customerId;
        this.name = name;
        this.preferredSize = preferredSize;
        this.points = points;
    }

    public Customer() {
        this.name = "New Customer";
    }

    public int getCustomerId() { return customerId; }
    public void setCustomerId(int customerId) { this.customerId = customerId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getPreferredSize() { return preferredSize; }
    public void setPreferredSize(String preferredSize) { this.preferredSize = preferredSize; }
    public int getPoints() { return points; }
    public void setPoints(int points) { this.points = points; }

    public void addPoints(int amount) {
        this.points += amount;
    }
    public boolean isVIP() {
        return this.points > 500;
    }
    @Override
    public String toString() {
        return String.format("Customer ID: %-5d  Name: %-15s  Pref. Size: %-3s  Points: %d (VIP: %b)",
                customerId, name, preferredSize, points, isVIP());
    }
}