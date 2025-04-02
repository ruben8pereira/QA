package Controllers;

import Domain.Attraction;
import Domain.Cost;
import Domain.Sale;
import Domain.User;
import Model.AttractionsRepository;
import Model.CostsRepository;
import Model.SalesRepository;
import Model.UsersRepository;
import Tools.FileManager;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class AdminController {
    private AttractionsRepository attractionsRepository;
    private SalesRepository salesRepository;
    private CostsRepository costsRepository;
    private UsersRepository usersRepository;

    public AdminController(String attractionsFilePath, String salesFilePath, String costsFilePath, String usersFilePath) throws FileNotFoundException {
        this.attractionsRepository = new AttractionsRepository(attractionsFilePath);
        this.salesRepository = new SalesRepository(salesFilePath);
        this.costsRepository = new CostsRepository(costsFilePath);
        this.usersRepository = new UsersRepository(usersFilePath);
    }

    /**
     * Gets total number of tickets sold
     *
     * @return Total number of sales
     */
    public int getTotalSales() {
        ArrayList<Sale> sales = salesRepository.getSalesList();
        return sales.size();
    }

    /**
     * Calculates total profit from all sales
     *
     * @return Total profit
     */
    public double getTotalProfit() {
        ArrayList<Sale> sales = salesRepository.getSalesList();
        ArrayList<Attraction> attractions = attractionsRepository.getAttractionsList();
        ArrayList<Cost> costs = costsRepository.getCostsList();

        double totalRevenue = 0;
        double totalCosts = 0;

        // Calculate all months present in sales data
        ArrayList<String> months = new ArrayList<>();
        for (Sale sale : sales) {
            if (!months.contains(sale.getDate())) {
                months.add(sale.getDate());
            }
        }

        // Calculate revenue
        for (Sale sale : sales) {
            int attractionId = sale.getAttractionId();

            for (Attraction attraction : attractions) {
                if (attraction.getId() == attractionId) {
                    if (sale.getClientType().equals("adulto")) {
                        totalRevenue = totalRevenue + attraction.getAdultTicket();
                    } else if (sale.getClientType().equals("crianca")) {
                        totalRevenue = totalRevenue + attraction.getChildTicket();
                    }
                    break;
                }
            }
        }

        // Calculate costs
        // Maintenance cost per ticket
        for (Sale sale : sales) {
            int attractionId = sale.getAttractionId();

            for (Cost cost : costs) {
                if (cost.getAttractionID() == attractionId) {
                    totalCosts = totalCosts + cost.getManutenanceCostPerTicket();
                    break;
                }
            }
        }

        // Fixed monthly costs
        for (String month : months) {
            for (Cost cost : costs) {
                totalCosts = totalCosts + cost.getMonthlyCost();
            }
        }

        double profit = totalRevenue - totalCosts;
        return profit;
    }

    /**
     * Displays sales and profit by month in tabular format
     */
    public void getMonthlySalesAndProfit() {
        System.out.println("Not implemented yet");
    }

    /**
     * Gets the most popular attraction for adults
     *
     * @return String with attraction information
     */
    public String getMostPopularAdultAttraction() {
        return "Not implemented yet";
    }

    /**
     * Gets the most popular attraction for children
     *
     * @return String with attraction information
     */
    public String getMostPopularChildAttraction() {
        return "Not implemented yet";
    }

    /**
     * Gets the most popular attraction overall
     *
     * @return String with attraction information
     */
    public String getMostPopularAttraction() {
        return "Not implemented yet";
    }

    /**
     * Gets the most profitable attraction
     *
     * @return String with attraction information
     */
    public String getMostProfitableAttraction() {
        return "Not implemented yet";
    }

    /**
     * Gets the least profitable attraction
     *
     * @return String with attraction information
     */
    public String getLeastProfitableAttraction() {
        return "Not implemented yet";
    }

    /**
     * Gets the attraction with the best price/time ratio
     *
     * @return String with attraction information
     */
    public String getBestPriceTimeAttraction() {
        return "Not implemented yet";
    }

    /**
     * Adds a new login to the system
     *
     * @param userType User type (ADMIN or ENG)
     * @param username Username
     * @param password Password
     * @return the created User
     */
    public User addNewLogin(String userType, String username, String password) {
        return null;
    }
}