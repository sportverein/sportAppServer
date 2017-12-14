package server.handler;

import server.SimpleQuery;
import server.protocol.SignoffRequest;
import server.protocol.SignoffResponse;

public class SignoffHandler extends BaseHandler {
    public String handle(String ip, String json){

        SignoffRequest signonRequest = (SignoffRequest) deserialize(json, SignoffRequest.class);

        boolean success = SimpleQuery.signoff(ip, signonRequest.getStation());

        SignoffResponse signoffResponse = new SignoffResponse(success, "");

        return serialize(signoffResponse);
    }
}
