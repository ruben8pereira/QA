package Domain;

public class Sale {
    private int attractionId;
    private String date;
    private String clientType;

    public Sale(int attractionId, String date, String clientType) {
        this.attractionId = attractionId;
        this.date = date;
        this.clientType = clientType;
    }

    public int getAttractionId() {
        return attractionId;
    }

    public String getDate() {
        return date;
    }

    public String getClientType() {
        return clientType;
    }
}