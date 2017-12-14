package server.handler;

import server.SimpleQuery;
import server.protocol.SignoffResponse;
import server.protocol.SignonRequest;

public class SingoffHandler extends BaseHandler {
   public String handle(String ip, String json){

       SignonRequest signonRequest = (SignonRequest) deserialize(json, SignonRequest.class);

       //boolean success = SimpleQuery.sigoff(ip, signonRequest.getStation());
       String message = "";

       //SignoffResponse signoffResponse = new SignoffResponse(success, message);

   return "";}
}
