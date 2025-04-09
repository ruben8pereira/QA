package model;

import domain.Attraction;
import tools.FileManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AttractionsRepositoryTest {

    private AttractionsRepository attractionsRepository;

    @BeforeEach
    void setUp() throws FileNotFoundException {
        attractionsRepository = new AttractionsRepository(FileManager.CESAELAND_ATRACTIONS_TEST);
    }

    @Test
    void getAttractionsListTest() {
        ArrayList<Attraction> attractions = attractionsRepository.getAttractionsList();

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