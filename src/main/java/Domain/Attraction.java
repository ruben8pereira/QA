package Domain;

public class Attraction {
    private int id;
    private String name;
    private double adultTicket;
    private double childTicket;
    private int durationInSeconds;

    public Attraction(int id, String name, double adultTicket, double childTicket, int durationInSeconds) {
        this.id = id;
        this.name = name;
        this.adultTicket = adultTicket;
        this.childTicket = childTicket;
        this.durationInSeconds = durationInSeconds;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getAdultTicket() {
        return adultTicket;
    }

    public double getChildTicket() {
        return childTicket;
    }

    public int getDurationInSeconds() {
        return durationInSeconds;
    }
}
