package controller;

import model.Product;
import model.PriceManager;

import java.util.Scanner;

public class MainController {

    public static void main(String[] args) {
        // Sample products
        Product p1 = new Product("Computers", 2130.0, 101);
        Product p2 = new Product("IPhones", 1500.0, 34);
        Product p3 = new Product("Headphones", 170.0, 32);
        Product p4 = new Product("Speaker", 100.0, 25);
        Product p5 = new Product("Tablets", 1170.0, 21);
        Product p6 = new Product("E-Scooter", 1400.0, 20);
        Product p7 = new Product("Chargers", 90.0, 10);
        Product p8 = new Product("Mouse", 100.0, 9);
        Product p9 = new Product("Keyboard", 130.0, 5);
        Product p10 = new Product("Printer", 500.0, 40);


        // Display the product list
        Product[] products = {p1, p2, p3,p4,p5,p6,p7,p8,p9,p10};

        // Create Scanner object for input
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Show the menu
            System.out.println("\n**** E-Retail Platform- ICT 602 ****");
            System.out.println("1. View Products");
            System.out.println("2. Adjust Prices Based on Stock");
            System.out.println("3. Apply Sale Discount");
            System.out.println("4. Exit");
            System.out.print("Enter your operation: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Display all products which are available in stock
                    System.out.println("\nProducts available now :");
                    for (Product product : products) {
                        System.out.println(product);
                    }
                    break;

                case 2:
                    //  changes prices based on stock availiblity
                    for (Product product : products) {
                        PriceManager.adjustPrice(product);
                    }
                    System.out.println("Prices are changed based on stock levels at current.");
                    break;

                case 3:
                    // Apply sale discount
                    System.out.print("Enter discount rate (%): ");
                    double discount = scanner.nextDouble();
                    for (Product product : products) {
                        PriceManager.applySale(product, discount);
                    }
                    System.out.println("Discount has been applied to all the products.");
                    break;

                case 4:
                    // Exit the app
                    System.out.println("Exiting the application. Thanks for using E-Retail Platform");
                    System.out.println("\n*******************************");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid input, please try again with correct operation.");
                    System.out.println("\n*******************************");
            }
        }
    }
}
