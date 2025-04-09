package model;

import domain.Cost;
import tools.FileManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CostsRepositoryTest {

    private CostsRepository costsRepository;

    @BeforeEach
    void setUp() throws FileNotFoundException {
        costsRepository = new CostsRepository(FileManager.CESAELAND_COSTS_TEST);
    }

    @Test
    void getCostsListTest() {
        ArrayList<Cost> costs = costsRepository.getCostsList();

        assertNotNull(costs);

        assertFalse(costs.isEmpty());

        assertEquals(10, costs.size());

        Cost montanhaRussaCost = null;
        for (Cost cost : costs) {
            if (cost.getAttractionID() == 1) {
                montanhaRussaCost = cost;
                break;
            }
        }

        assertNotNull(montanhaRussaCost, "Montanha Russa cost should exist");
        assertEquals(2.5, montanhaRussaCost.getManutenanceCostPerTicket());
        assertEquals(700, montanhaRussaCost.getMonthlyCost());

        Cost escorregasCost = null;
        for (Cost cost : costs) {
            if (cost.getAttractionID() == 8) {
                escorregasCost = cost;
                break;
            }
        }

        assertNotNull(escorregasCost, "Escorregas da IA cost should exist");
        assertEquals(0.1, escorregasCost.getManutenanceCostPerTicket());
        assertEquals(50, escorregasCost.getMonthlyCost());
    }
}