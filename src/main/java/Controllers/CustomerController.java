package Controllers;

import Domain.Attraction;
import Model.AttractionsRepository;
import Model.SalesRepository;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class CustomerController {
    private AttractionsRepository attractionsRepository;
    private SalesRepository salesRepository;

    public CustomerController() throws FileNotFoundException {
        this.attractionsRepository = new AttractionsRepository("src/Resources/Cesaeland_atracoes.csv");
        this.salesRepository = new SalesRepository("src/Resources/Cesaeland_vendas.csv");
    }

    /**
     * Gets all available attractions
     *
     * @return List of all attractions
     */
    public ArrayList<Attraction> getAvailableAttractions() {
        return attractionsRepository.getAttractionsList();
    }

    /**
     * Gets the name of the most popular attraction for adults
     *
     * @return String with attraction name
     */
    public String getMostPopularAdultAttraction() {
        return "Not implemented yet";
    }

    /**
     * Gets the name of the most popular attraction for children
     *
     * @return String with attraction name
     */
    public String getMostPopularChildAttraction() {
        return "Not implemented yet";
    }
}