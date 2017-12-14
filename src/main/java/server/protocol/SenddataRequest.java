package server.protocol;

public class SenddataRequest {
    private int station;
    private String schoolclass;
    private int points;



    public SenddataRequest(int station, String schoolclass, int points) {

        this.station = station;
        this.schoolclass = schoolclass;
        this.points = points;
    }

    public int getStation() {
        return station;
    }

    public String getSchoolclass() {
        return schoolclass;
    }

    public int getPoints() {
        return points;
    }
}
