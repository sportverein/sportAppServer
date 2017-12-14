package server.protocol;

public class SignoffResponse {
    private boolean success;

    public SignoffResponse(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }
}
