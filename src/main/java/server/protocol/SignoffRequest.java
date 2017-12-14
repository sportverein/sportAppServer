package server.protocol;

public class SignoffRequest {
    private int station;

    public SignoffRequest(int station) {
        this.station = station;
    }

    public int getStation() {
        return station;
    }
}
