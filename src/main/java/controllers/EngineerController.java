package controllers;

import domain.Attraction;
import domain.Sale;
import model.AttractionsRepository;
import model.SalesRepository;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class EngineerController {
    private AttractionsRepository attractionsRepository;
    private SalesRepository salesRepository;

    public EngineerController(String attractionsFilePath, String salesFilePath) throws FileNotFoundException {
        this.attractionsRepository = new AttractionsRepository(attractionsFilePath);
        this.salesRepository = new SalesRepository(salesFilePath);
    }

    /**
     * Gets the top 3 attractions needing maintenance review soon
     *
     * @return ArrayList of attractions needing review, sorted by urgency
     */
    public ArrayList<Attraction> getUpcomingReviews() {
        ArrayList<Attraction> attractions = attractionsRepository.getAttractionsList();
        ArrayList<Sale> sales = salesRepository.getSalesList();

        // Count tickets sold for each attraction
        int[] ticketCounter = new int[10];

        for (Sale sale : sales) {
            int id = sale.getAttractionId();
            ticketCounter[id - 1]++;
        }

        // List of attractions with their ticket counts
        ArrayList<Attraction> sortedAttractions = new ArrayList<>(attractions);

        // Bubble sort attractions by tickets until review
        for (int i = 0; i < sortedAttractions.size() - 1; i++) {
            for (int j = 0; j < sortedAttractions.size() - i - 1; j++) {
                Attraction a1 = sortedAttractions.get(j);
                Attraction a2 = sortedAttractions.get(j + 1);

                int tickets1 = ticketCounter[a1.getId() - 1] % 50;
                int tickets2 = ticketCounter[a2.getId() - 1] % 50;

                if (tickets1 == 0) tickets1 = 0;
                else tickets1 = 50 - tickets1;

                if (tickets2 == 0) tickets2 = 0;
                else tickets2 = 50 - tickets2;

                if (tickets1 > tickets2) {
                    // Swap attractions
                    sortedAttractions.set(j, a2);
                    sortedAttractions.set(j + 1, a1);
                }
            }
        }

        // Top 3 attractions needing maintenance
        ArrayList<Attraction> result = new ArrayList<>();
        int limit = 3;
        if (sortedAttractions.size() < 3) {
            limit = sortedAttractions.size();
        }

        for (int i = 0; i < limit; i++) {
            result.add(sortedAttractions.get(i));
        }

        return result;
    }

    /**
     * Gets the number of tickets until next review for an attraction
     *
     * @param attraction The attraction to check
     * @return Number of tickets until next review
     */
    public int getTicketsUntilReview(Attraction attraction) {
        ArrayList<Sale> sales = salesRepository.getSalesList();
        int count = 0;

        for (Sale sale : sales) {
            if (sale.getAttractionId() == attraction.getId()) {
                count++;
            }
        }

        int remainingTickets = count % 50;
        if (remainingTickets == 0) {
            return 0; // Review needed now
        } else {
            return 50 - remainingTickets;
        }
    }

    /**
     * Gets the history of maintenance reviews (3 most recent reviews)
     */
    public void getReviewsHistory() {
        System.out.println("Not implemented yet");
    }
}