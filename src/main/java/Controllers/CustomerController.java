package Controllers;

import Domain.Attraction;
import Model.AttractionsRepository;
import Model.SalesRepository;
import Tools.FileManager;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class CustomerController {
    private AttractionsRepository attractionsRepository;
    private SalesRepository salesRepository;

    public CustomerController(String attractionsFilePath, String salesFilePath) throws FileNotFoundException {
        this.attractionsRepository = new AttractionsRepository(attractionsFilePath);
        this.salesRepository = new SalesRepository(salesFilePath);
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