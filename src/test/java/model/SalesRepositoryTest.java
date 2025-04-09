package model;

import domain.Sale;
import tools.FileManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SalesRepositoryTest {

    private SalesRepository salesRepository;

    @BeforeEach
    void setUp() throws FileNotFoundException {
        salesRepository = new SalesRepository(FileManager.CESAELAND_SALES_TEST);
    }

    @Test
    void getSalesListTest() {
        ArrayList<Sale> sales = salesRepository.getSalesList();

        assertNotNull(sales);

        assertFalse(sales.isEmpty());

        assertTrue(sales.size() > 0);

        Sale firstSale = sales.get(0);
        assertNotNull(firstSale);

        assertTrue(firstSale.getAttractionId() >= 1 && firstSale.getAttractionId() <= 10,
                "Attraction ID should be between 1 and 10, found: " + firstSale.getAttractionId());


        assertTrue(firstSale.getClientType().equals("adulto") || firstSale.getClientType().equals("crianca"),
                "Customer type should be 'adulto' or 'crianca', found: " + firstSale.getClientType());

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
    }
}