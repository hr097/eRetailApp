package model;
public class Product {
    private String productName;
    private double basePrice;
    private int stock;
    private double currentPrice;
    public Product(String productName, double basePrice, int stock) {
        this.productName = productName;
        this.basePrice = basePrice;
        this.stock = stock;
        this.currentPrice = basePrice; // Initial price is base price set
    }
    public String getName() {
        return productName;
    }
    public double getBasePrice() {
        return basePrice;
    }
    public int getStock() {
        return stock;
    }
    public double getCurrentPrice() {
        return currentPrice;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
    public void setCurrentPrice(double price) {
        this.currentPrice = price;
    }
    @Override
    public String toString() {
        return String.format("%s - Stock: %d \nBase Price: %.2f \nCurrent Price: %.2f",
                productName, stock, basePrice, currentPrice);
    }
}
