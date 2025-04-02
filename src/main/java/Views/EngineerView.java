package Views;

import Controllers.EngineerController;
import Domain.Attraction;
import Tools.FileManager;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EngineerView {
    private EngineerController engineerController;

    public EngineerView() throws FileNotFoundException {
        this.engineerController = new EngineerController(FileManager.CESAELAND_ATRACTIONS, FileManager.CESAELAND_SALES);
    }

    /**
     * Displays the Maintenance Engineer menu and handles user interactions.
     * Presents options for viewing upcoming maintenance reviews and maintenance history.
     */
    public void engMenu() {
        Scanner input = new Scanner(System.in);

        int option;

        do {
            System.out.println("\n=== ENGINEER MENU ===");
            System.out.println("1. View Upcoming Maintenance Reviews");
            System.out.println("2. View Maintenance Reviews History");
            System.out.println("0. Exit");

            System.out.print("Choose an option: ");

            try {
                option = input.nextInt();

                switch (option) {
                    case 1: // Implemented Method
                        ArrayList<Attraction> upcomingReviews = engineerController.getUpcomingReviews();

                        System.out.println("\n=== UPCOMING REVIEWS ===");
                        for (Attraction attraction : upcomingReviews) {
                            int ticketsUntilReview = engineerController.getTicketsUntilReview(attraction);
                            System.out.println("ID: " + attraction.getId() +
                                    " | Attraction: " + attraction.getName() +
                                    " | Tickets until review: " + ticketsUntilReview);
                        }
                        System.out.println("==============================================================");
                        break;
                    case 2:
                        System.out.println("\n=== MAINTENANCE REVIEWS HISTORY ===");
                        engineerController.getReviewsHistory();
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