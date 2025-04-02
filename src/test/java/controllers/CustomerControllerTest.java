package controllers;

import domain.Attraction;
import tools.FileManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CustomerControllerTest {

    private CustomerController customerController;

    @BeforeEach
    void setUp() throws FileNotFoundException {
        customerController = new CustomerController(FileManager.CESAELAND_ATRACTIONS_TEST, FileManager.CESAELAND_SALES_TEST);
    }

    @Test
    void getAvailableAttractionsTest() {
        ArrayList<Attraction> attractions = customerController.getAvailableAttractions();

        assertNotNull(attractions);

        assertFalse(attractions.isEmpty());

        assertEquals(10, attractions.size());

        Attraction montanhaRussa = null;
        for (Attraction attraction : attractions) {
            if (attraction.getId() == 1) {
                montanhaRussa = attraction;
                break;
            }
        }

        assertNotNull(montanhaRussa, "Montanha Russa attraction should exist");

        assertEquals("Montanha Russa da Programacao", montanhaRussa.getName());
        assertEquals(15.0, montanhaRussa.getAdultTicket());
        assertEquals(12.0, montanhaRussa.getChildTicket());
        assertEquals(180, montanhaRussa.getDurationInSeconds());
    }
}