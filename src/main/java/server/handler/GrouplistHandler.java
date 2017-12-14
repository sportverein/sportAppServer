package server.handler;

import server.SimpleQuery;
import server.protocol.GrouplistRequest;
import server.protocol.GrouplistResponse;

import java.util.ArrayList;

public class GrouplistHandler extends BaseHandler{

    public String handle(String json){

        GrouplistRequest grouplistRequest = (GrouplistRequest) deserialize(json, GrouplistRequest.class);

        ArrayList<String> grouplist = SimpleQuery.grouplist(grouplistRequest.getStation());

        int progress = SimpleQuery.progress(grouplistRequest.getStation());

        GrouplistResponse grouplistResponse = new GrouplistResponse(grouplist, progress, true);

        return serialize(grouplistResponse);
    }
}
