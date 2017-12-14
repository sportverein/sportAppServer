package server.protocol;

/**
 * Created by Teilnehmer on 13.12.2017.
 */

public class SignonRequest {
    private int station;

    public SignonRequest(int station) {
        this.station = station;
    }

    public int getStation() {
        return station;
    }
}
