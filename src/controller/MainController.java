package controller;

import model.Product;
import model.PriceManager;

import java.util.Scanner;

public class MainController {

    public static void main(String[] args) {
        // Sample products
        Product p1 = new Product("Laptop", 1000.0, 10);
        Product p2 = new Product("Smartphone", 500.0, 3);
        Product p3 = new Product("Headphones", 150.0, 30);

        // Display the product list
        Product[] products = {p1, p2, p3};

        // Create Scanner object for input
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Show the menu
            System.out.println("\nE-Retail Dynamic Pricing System");
            System.out.println("1. View Products");
            System.out.println("2. Adjust Prices Based on Stock");
            System.out.println("3. Apply Sale Discount");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Display all products
                    System.out.println("\nProduct List:");
                    for (Product product : products) {
                        System.out.println(product);
                    }
                    break;

                case 2:
                    // Adjust prices based on stock
                    for (Product product : products) {
                        PriceManager.adjustPrice(product);
                    }
                    System.out.println("Prices updated based on stock levels.");
                    break;

                case 3:
                    // Apply sale discount
                    System.out.print("Enter discount percentage: ");
                    double discount = scanner.nextDouble();
                    for (Product product : products) {
                        PriceManager.applySale(product, discount);
                    }
                    System.out.println("Discount applied to all products.");
                    break;

                case 4:
                    // Exit the app
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
    }
}
