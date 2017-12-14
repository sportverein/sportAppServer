package handler;

import protocol.SignonRequest;
import protocol.SignonResponse;

public class SignonHandler extends BaseHandler {

    public String handle(String ip, String json){

        SignonRequest signonRequest = (SignonRequest)deserialize(json, SignonRequest.class);

        boolean success = SimpleQuery.signon(ip, signonRequest.getStation());
        String message = "";

        SignonResponse signonResponse = new SignonResponse(success, message);

        return serialize(signonResponse);

    }

}
