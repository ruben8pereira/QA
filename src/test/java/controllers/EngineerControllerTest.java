package controllers;

import domain.Attraction;
import model.AttractionsRepository;
import tools.FileManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class EngineerControllerTest {

    private EngineerController engineerController;

    @BeforeEach
    void setUp() throws FileNotFoundException {
        engineerController = new EngineerController(FileManager.CESAELAND_ATRACTIONS_TEST, FileManager.CESAELAND_SALES_TEST);
    }

    @Test
    void getUpcomingReviews() {
        ArrayList<Attraction> upcomingReviews = engineerController.getUpcomingReviews();

        assertNotNull(upcomingReviews);

        assertFalse(upcomingReviews.isEmpty());

        assertTrue(upcomingReviews.size() <= 3, "Should return 3 attractions, found: " + upcomingReviews.size());

        for (Attraction attraction : upcomingReviews) {
            assertTrue(attraction.getId() >= 1 && attraction.getId() <= 10, "Invalid attraction ID: " + attraction.getId());
        }
    }

    @Test
    void getTicketsUntilReview() throws FileNotFoundException {
        AttractionsRepository attractionsRepository = new AttractionsRepository(FileManager.CESAELAND_ATRACTIONS_TEST);

        ArrayList<Attraction> attractions = attractionsRepository.getAttractionsList();

        Attraction testAttraction = attractions.get(0);

        int ticketsUntilReview = engineerController.getTicketsUntilReview(testAttraction);

        assertTrue(ticketsUntilReview >= 0 && ticketsUntilReview < 50, "Tickets until review: " + ticketsUntilReview);

        for (Attraction attraction : attractions) {
            int tickets = engineerController.getTicketsUntilReview(attraction);

            assertTrue(tickets >= 0 && tickets < 50, "For attraction " + attraction.getId() + ", tickets until review: " + tickets);
        }
    }
}