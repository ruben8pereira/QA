package model;

import domain.Sale;
import tools.CSVReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class SalesRepository {
    private ArrayList<Sale> salesList = new ArrayList<Sale>();

    public SalesRepository(String filePath) throws FileNotFoundException {
        this.salesList = CSVReader.readSalesFileToArray(filePath);
    }

    public ArrayList<Sale> getSalesList() {
        return salesList;
    }
}
