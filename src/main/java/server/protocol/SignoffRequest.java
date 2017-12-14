package server.protocol;

public class SignoffRequest {
    private String station;

    public SignoffRequest(String station) {
        this.station = station;
    }

    public String getStation() {
        return station;
    }
}
