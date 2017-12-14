package server.protocol;


import java.util.ArrayList;

public class UpdateResponse {
    private ArrayList<String> schoolclasses;

    public UpdateResponse(ArrayList<String> schoolclasses) {
        this.schoolclasses = schoolclasses;
    }
}
