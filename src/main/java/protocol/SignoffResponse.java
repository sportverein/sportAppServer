package protocol;

public class SignoffResponse {
    private boolean success;
    private String message;

    public SignoffResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}
