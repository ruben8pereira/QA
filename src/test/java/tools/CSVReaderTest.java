package tools;

import domain.Attraction;
import domain.Cost;
import domain.Sale;
import domain.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CSVReaderTest {

    private static ArrayList<User> users;
    private static ArrayList<Sale> sales;
    private static ArrayList<Cost> costs;
    private static ArrayList<Attraction> attractions;

    @BeforeAll
    static void loadAllData() throws FileNotFoundException {
        users = CSVReader.readUserFileToArray(FileManager.CESAELAND_LOGINS_TEST);
        sales = CSVReader.readSalesFileToArray(FileManager.CESAELAND_SALES_TEST);
        costs = CSVReader.readCostsFileToArray(FileManager.CESAELAND_COSTS_TEST);
        attractions = CSVReader.readAttractionsFileToArray(FileManager.CESAELAND_ATRACTIONS_TEST);
    }

    @Test
    void readUserFileToArrayTest() {
        assertNotNull(users);
        assertFalse(users.isEmpty());
        assertEquals(6, users.size());

        User rootUser = null;
        User pimentaUser = null;

        for (User user : users) {
            if (user.getUsername().equals("root")) rootUser = user;
            if (user.getUsername().equals("pimentaMachado")) pimentaUser = user;
        }

        assertNotNull(rootUser, "User 'root' should exist");
        assertEquals("ADMIN", rootUser.getUserType());
        assertEquals("root", rootUser.getPassword());

        assertNotNull(pimentaUser, "User 'pimentaMachado' should exist");
        assertEquals("ENG", pimentaUser.getUserType());
        assertEquals("domingo", pimentaUser.getPassword());

        boolean hasAdminUser = false;
        boolean hasEngUser = false;

        for (User user : users) {
            String userType = user.getUserType();
            if (userType.equals("ADMIN")) hasAdminUser = true;
            if (userType.equals("ENG")) hasEngUser = true;
        }

        assertTrue(hasAdminUser, "Should exist at least one ADMIN user");
        assertTrue(hasEngUser, "Should exist at least one ENG user");
    }

    @Test
    void readSalesFileToArrayTest() {
        assertNotNull(sales);
        assertFalse(sales.isEmpty());
        assertTrue(sales.size() > 0);

        boolean hasJuneData = false;
        boolean hasJulyData = false;
        boolean hasAugustData = false;

        for (Sale sale : sales) {
            String date = sale.getDate();
            if (date.equals("06/2024")) hasJuneData = true;
            if (date.equals("07/2024")) hasJulyData = true;
            if (date.equals("08/2024")) hasAugustData = true;
        }

        assertTrue(hasJuneData, "June should have sales");
        assertTrue(hasJulyData, "July should have sales");
        assertTrue(hasAugustData, "August should have sales");

        boolean hasAdultSales = false;
        boolean hasChildSales = false;

        for (Sale sale : sales) {
            String clientType = sale.getClientType();
            if (clientType.equals("adulto")) hasAdultSales = true;
            if (clientType.equals("crianca")) hasChildSales = true;
        }

        assertTrue(hasAdultSales, "Should have sales for 'adultos'");
        assertTrue(hasChildSales, "Should have sales for 'crianças'");

        boolean hasAttractionId1 = false;
        boolean hasAttractionId5 = false;
        boolean hasAttractionId10 = false;

        for (Sale sale : sales) {
            int attractionId = sale.getAttractionId();
            if (attractionId == 1) hasAttractionId1 = true;
            if (attractionId == 5) hasAttractionId5 = true;
            if (attractionId == 10) hasAttractionId10 = true;
        }

        assertTrue(hasAttractionId1, "Should have sales for attraction 1");
        assertTrue(hasAttractionId5, "Should have sales for attraction 5");
        assertTrue(hasAttractionId10, "Should have sales for attraction 10");
    }

    @Test
    void readCostsFileToArrayTest() {
        assertNotNull(costs);
        assertFalse(costs.isEmpty());
        assertEquals(10, costs.size());

        Cost cost1 = null; // Montanha Russa
        Cost cost8 = null; // Escorregas da IA

        for (Cost cost : costs) {
            if (cost.getAttractionID() == 1) cost1 = cost;
            if (cost.getAttractionID() == 8) cost8 = cost;
        }

        assertNotNull(cost1, "Montanha Russa cost should exist");
        assertEquals(2.5, cost1.getManutenanceCostPerTicket(), 0.001);
        assertEquals(700, cost1.getMonthlyCost());

        assertNotNull(cost8, "Escorregas da IA should exist");
        assertEquals(0.1, cost8.getManutenanceCostPerTicket(), 0.001);
        assertEquals(50, cost8.getMonthlyCost());
    }

    @Test
    void readAttractionsFileToArrayTest() {
        assertNotNull(attractions);
        assertFalse(attractions.isEmpty());
        assertEquals(10, attractions.size());

        Attraction montanhaRussa = null;
        Attraction casaAssombrada = null;
        Attraction escorregas = null;

        for (Attraction attraction : attractions) {
            if (attraction.getId() == 1) montanhaRussa = attraction;
            if (attraction.getId() == 2) casaAssombrada = attraction;
            if (attraction.getId() == 8) escorregas = attraction;
        }

        assertNotNull(montanhaRussa, "Montanha Russa should exist");
        assertEquals("Montanha Russa da Programacao", montanhaRussa.getName());
        assertEquals(15.0, montanhaRussa.getAdultTicket(), 0.001);
        assertEquals(12.0, montanhaRussa.getChildTicket(), 0.001);
        assertEquals(180, montanhaRussa.getDurationInSeconds());

        assertNotNull(casaAssombrada, "Casa Assombrada should exist");
        assertEquals("Casa Assombrada de Projeto Final", casaAssombrada.getName());
        assertEquals(3.5, casaAssombrada.getAdultTicket(), 0.001);
        assertEquals(2.5, casaAssombrada.getChildTicket(), 0.001);
        assertEquals(240, casaAssombrada.getDurationInSeconds());

        assertNotNull(escorregas, "Escorregas da IA should exist");
        assertEquals("Escorregas da IA", escorregas.getName());
        assertEquals(2.0, escorregas.getAdultTicket(), 0.001);
        assertEquals(0.5, escorregas.getChildTicket(), 0.001);
        assertEquals(30, escorregas.getDurationInSeconds());
    }
}