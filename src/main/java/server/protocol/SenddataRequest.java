package server.protocol;

public class SenddataRequest {
    private int station;
    private int points;
    private String schoolClass;

    public int getStation() {
        return station;
    }

    public int getPoints() {
        return points;
    }

    public String getSchoolClass() {
        return schoolClass;
    }

    public SenddataRequest(int station, int points, String schoolClass) {

        this.station = station;
        this.points = points;
        this.schoolClass = schoolClass;
    }
}
