package handler;

import com.google.gson.Gson;

abstract public class BaseHandler {

    public Object deserialize(String xml, Class c){
        Gson gson = new Gson();

        return gson.fromJson(xml, c);
    }

    public String serialize(Object o){

        Gson gson = new Gson();

        return gson.toJson(o);
    }

}
