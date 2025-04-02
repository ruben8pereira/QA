package Views;

import Controllers.AdminController;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AdminView {
    private AdminController adminController;

    public AdminView() throws FileNotFoundException {
        this.adminController = new AdminController();
    }

    /**
     * Displays the Administrator menu and handles user interactions.
     * Presents options for viewing various park statistics including sales, profits, popular attractions, and managing user access.
     */
    public void adminMenu() {
        Scanner input = new Scanner(System.in);

        int option;

        do {
            System.out.println("\n=== ADMIN MENU ===");
            System.out.println("1. View Total Sales");
            System.out.println("2. View Total Profit");
            System.out.println("3. View Monthly Sales and Profit");
            System.out.println("4. View Most Popular Attraction for Adults");
            System.out.println("5. View Most Popular Attraction for Children");
            System.out.println("6. View Most Popular Attraction Overall");
            System.out.println("7. View Most Profitable Attraction");
            System.out.println("8. View Least Profitable Attraction");
            System.out.println("9. View Best Price/Time Attraction");
            System.out.println("10. Add New Login");
            System.out.println("0. Exit");

            System.out.print("Choose an option: ");

            try {
                option = input.nextInt();

                switch (option) {
                    case 1:
                        System.out.println("\n=== TOTAL SALES ===");
                        int totalSales = adminController.getTotalSales();
                        System.out.println("Total tickets sold: " + totalSales);
                        break;
                    case 2: // Implemented Method
                        System.out.println("\n=== TOTAL PROFIT ===");
                        System.out.println("Total profit: " + adminController.getTotalProfit() + " €");
                        break;
                    case 3:
                        System.out.println("\n=== MONTHLY SALES AND PROFIT ===");
                        adminController.getMonthlySalesAndProfit();
                        break;
                    case 4:
                        System.out.println("\n=== MOST POPULAR ADULT ATTRACTION ===");
                        System.out.println(adminController.getMostPopularAdultAttraction());
                        break;
                    case 5:
                        System.out.println("\n=== MOST POPULAR CHILD ATTRACTION ===");
                        System.out.println(adminController.getMostPopularChildAttraction());
                        break;
                    case 6:
                        System.out.println("\n=== MOST POPULAR ATTRACTION OVERALL ===");
                        System.out.println(adminController.getMostPopularAttraction());
                        break;
                    case 7:
                        System.out.println("\n=== MOST PROFITABLE ATTRACTION ===");
                        System.out.println(adminController.getMostProfitableAttraction());
                        break;
                    case 8:
                        System.out.println("\n=== LEAST PROFITABLE ATTRACTION ===");
                        System.out.println(adminController.getLeastProfitableAttraction());
                        break;
                    case 9:
                        System.out.println("\n=== BEST PRICE/TIME ATTRACTION ===");
                        System.out.println(adminController.getBestPriceTimeAttraction());
                        break;
                    case 10:
                        System.out.println("\n=== ADD NEW LOGIN ===");
                        System.out.println("Not implemented yet");
                        break;
                    case 0:
                        System.out.println("Returning to main menu...");
                        break;
                    default:
                        System.out.println("Invalid Option!");
                }
            } catch (InputMismatchException e) {
                System.out.print("Invalid Input! Try Again!\n");
                input.next();
                option = -1;
            }
        } while (option != 0);
    }
}