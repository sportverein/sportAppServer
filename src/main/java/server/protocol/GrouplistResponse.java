package server.protocol;

import java.util.ArrayList;

public class GrouplistResponse {
    private ArrayList<String> schoolclasses;
    private int progress;
    private boolean success;

    public GrouplistResponse(ArrayList<String> schoolclasses, int progress, boolean success) {
        this.schoolclasses = schoolclasses;
        this.progress = progress;
        this.success = success;
    }

    public ArrayList<String> getSchoolclasses() {
        return schoolclasses;
    }

    public int getProgress() { return progress; }

    public boolean isSuccess() {
        return success;
    }
}
