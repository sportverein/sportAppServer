package server.protocol;

public class GrouplistRequest {
    private int station;


    public GrouplistRequest(int station) {
        this.station = station;

    }

    public int getStation() {
        return station;
    }
}
