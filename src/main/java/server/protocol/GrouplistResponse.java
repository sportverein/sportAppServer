package server.protocol;

import java.util.ArrayList;

public class GrouplistResponse {
    private ArrayList<String> schoolclasses;
    private boolean success;

    public GrouplistResponse(ArrayList<String> schoolclasses, boolean success) {
        this.schoolclasses = schoolclasses;
        this.success = success;
    }

    public ArrayList<String> getSchoolclasses() {
        return schoolclasses;
    }

    public boolean isSuccess() {
        return success;
    }
}
