package controllers;

import tools.FileManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class AdminControllerTest {

    private AdminController adminController;

    @BeforeEach
    void setUp() throws FileNotFoundException {
        adminController = new AdminController(FileManager.CESAELAND_ATRACTIONS_TEST, FileManager.CESAELAND_SALES_TEST, FileManager.CESAELAND_COSTS_TEST, FileManager.CESAELAND_LOGINS_TEST);
    }

    @Test
    void getTotalProfit() {
        double expectedProfit = adminController.getTotalProfit();

        assertNotEquals(0.0, adminController.getTotalProfit());

        assertTrue(adminController.getTotalProfit() > -100000);
        assertTrue(adminController.getTotalProfit() < 100000);
    }
}