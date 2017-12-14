package server.handler;

import server.SimpleQuery;
import server.protocol.SenddataRequest;
import server.protocol.SenddataResponse;

public class SenddataHandler extends BaseHandler {
   public String handle(String json){
       SenddataRequest senddataRequest = (SenddataRequest) deserialize(json, SenddataRequest.class);

       boolean success = SimpleQuery.delivery(senddataRequest.getSchoolClass(), senddataRequest.getStation(), senddataRequest.getPoints());

       SenddataResponse senddataResponse = new SenddataResponse(success);

       return serialize(senddataResponse);
   }
}
