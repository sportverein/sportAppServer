package handler;

import protocol.SignoffResponse;
import protocol.SignonRequest;
import protocol.SignonResponse;

public class SingoffHandler extends BaseHandler {
   public String handle(String ip, String json, ){

       SignonRequest signonRequest = (SignonRequest) deserialize(json, SignonRequest.class);

       boolean success = SimpleQuery.sigoff(ip, signonRequest.getStation());
       String message = "";

       SignoffResponse signoffResponse = new SignoffResponse(success, message);
   }
}
