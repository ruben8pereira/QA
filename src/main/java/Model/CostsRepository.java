package Model;

import Domain.Cost;
import Domain.User;
import Tools.CSVReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class CostsRepository {
    private ArrayList<Cost> costsList;

    public CostsRepository(String filePath) throws FileNotFoundException {
        this.costsList = CSVReader.readCostsFileToArray(filePath);
    }

    public ArrayList<Cost> getCostsList() {
        return costsList;
    }
}
