package server.handler;

import server.SimpleQuery;
import server.protocol.GrouplistRequest;
import server.protocol.GrouplistResponse;
import server.protocol.SignonRequest;
import server.protocol.SignonResponse;

import java.util.ArrayList;

public class GrouplistHandler extends BaseHandler{

    public String handle(int station, String json){

        GrouplistRequest grouplistRequest = (GrouplistRequest) deserialize(json, GrouplistRequest.class);

        ArrayList<String> grouplist = SimpleQuery.grouplist(grouplistRequest.getStation());

        GrouplistResponse grouplistResponse = new GrouplistResponse(grouplist, true);

        return serialize(grouplistResponse);
    }
}
