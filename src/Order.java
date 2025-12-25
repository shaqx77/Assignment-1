public class Order {
    private int orderId;
    private String customerName;
    private double totalAmount;
    private String status;

    public Order(int orderId, String customerName, double totalAmount, String status) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalAmount = totalAmount;
        this.status = status;
    }
    public int getOrderId() { return orderId; }
    public void setOrderId(int orderId) { this.orderId = orderId; }
    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public void completeOrder() {
        this.status = "Completed";
    }
    public void cancelOrder() {
        this.status = "Cancelled";
    }
    @Override
    public String toString() {
        return String.format("Order ID: %-5d  Customer: %-15s  Total: %10.2f KZT  Status: %s",
                orderId, customerName, totalAmount, status);
    }
}