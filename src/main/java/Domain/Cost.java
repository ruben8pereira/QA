package Domain;

public class Cost {
    private int attractionID;
    private double manutenanceCostPerTicket;
    private int monthlyCost;

    public Cost(int attractionID, double manutenanceCostPerTicket, int monthlyCost) {
        this.attractionID = attractionID;
        this.manutenanceCostPerTicket = manutenanceCostPerTicket;
        this.monthlyCost = monthlyCost;
    }

    public int getAttractionID() {
        return attractionID;
    }

    public double getManutenanceCostPerTicket() {
        return manutenanceCostPerTicket;
    }

    public int getMonthlyCost() {
        return monthlyCost;
    }
}
