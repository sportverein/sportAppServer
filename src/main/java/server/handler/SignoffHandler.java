package server.handler;

import server.SimpleQuery;
import server.protocol.SignoffResponse;
import server.protocol.SignonRequest;

public class SignoffHandler extends BaseHandler {
    public String handle(String ip, String json){

        SignonRequest signonRequest = (SignonRequest) deserialize(json, SignonRequest.class);

        boolean success = SimpleQuery.signoff(ip, signonRequest.getStation());

        SignoffResponse signoffResponse = new SignoffResponse(success, "");

        return serialize(signoffResponse);
    }
}
