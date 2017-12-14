package protocol;

import java.util.ArrayList;

public class SenddataResponse {
    private boolean success;
    private ArrayList<String> schoolClasses;

    public SenddataResponse(boolean success, ArrayList<String> schoolClasses) {
        this.success = success;
        this.schoolClasses = schoolClasses;
    }
}
