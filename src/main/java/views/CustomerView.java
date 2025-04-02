package views;

import controllers.CustomerController;
import domain.Attraction;
import tools.FileManager;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CustomerView {
    private CustomerController customerController;

    public CustomerView() throws FileNotFoundException {
        this.customerController = new CustomerController(FileManager.CESAELAND_ATRACTIONS, FileManager.CESAELAND_SALES);
    }

    /**
     * Displays the Customer menu and handles user interactions.
     * Presents options for viewing available attractions and favorite attractions.
     */
    public void customerMenu() {
        Scanner input = new Scanner(System.in);

        int option;

        do {
            System.out.println("\n=== CUSTOMER MENU ===");
            System.out.println("1. View Available Attractions");
            System.out.println("2. View Favorite Attractions");
            System.out.println("0. Exit");

            System.out.print("Choose an option: ");

            try {
                option = input.nextInt();

                switch (option) {
                    case 1: // Implemented Method
                        System.out.println("\n=== AVAILABLE ATTRACTIONS ===");
                        ArrayList<Attraction> attractions = customerController.getAvailableAttractions();

                        for (Attraction attraction : attractions) {
                            // Format duration as min:sec
                            int minutes = attraction.getDurationInSeconds() / 60;
                            int seconds = attraction.getDurationInSeconds() % 60;
                            String duration = minutes + ":" + seconds;

                            System.out.println("ID: " + attraction.getId() +
                                    " | Attraction: " + attraction.getName() +
                                    " | Adult Ticket: " + attraction.getAdultTicket() + " €" +
                                    " | Child Ticket: " + attraction.getChildTicket() + " €" +
                                    " | Duration: " + duration);
                        }
                        System.out.println("==========================================================");
                        break;
                    case 2:
                        System.out.println("\n=== FAVORITE ATTRACTIONS ===");
                        System.out.println("Most popular attraction for Adults: " + customerController.getMostPopularAdultAttraction());
                        System.out.println("Most popular attraction for Children: " + customerController.getMostPopularChildAttraction());
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