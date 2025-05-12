package model;

public class PriceManager {

    // Methods to update product price based on stock level
    public static void adjustPrice(Product product) {
        int stock = product.getStock();

        if (stock < 5) {
            // Increase price if stock is very low
            double newPrice = product.getBasePrice() * 1.2;
            product.setCurrentPrice(newPrice);
        } else if (stock >= 10 && stock <= 20) {
            // Keep base price if stock is moderate
            product.setCurrentPrice(product.getBasePrice());
        } else {
            // Decrease price if stock is high
            double newPrice = product.getBasePrice() * 0.8;
            product.setCurrentPrice(newPrice);
        }
    }

    // Method to simulate a discount sale
    public static void applySale(Product product, double discountPercentage) {
        double salePrice = product.getBasePrice() * (1 - discountPercentage / 100);
        product.setCurrentPrice(salePrice);
    }
}
