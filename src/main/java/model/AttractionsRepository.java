package model;

import domain.Attraction;
import tools.CSVReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class AttractionsRepository {
    private ArrayList<Attraction> attractionsList;

    public AttractionsRepository(String filePath) throws FileNotFoundException {
        this.attractionsList = CSVReader.readAttractionsFileToArray(filePath);
    }

    public ArrayList<Attraction> getAttractionsList() {
        return attractionsList;
    }
}
