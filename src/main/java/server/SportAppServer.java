package server;

import server.handler.GrouplistHandler;
import server.handler.SignonHandler;
import server.protocol.Command;
import spark.Spark;

public class SportAppServer {
    public static void main(String[] args) {
        Spark.port(Properties.SERVERPORT_SPARK);

        Spark.staticFiles.location("/public");

        Spark.post("/sportfest/:command", (req, res) ->
                {
                    String commandString = req.params(":command");

                    Command command = Command.fromString(commandString);

                    if(command == null){
                        return "Error: command " + commandString + " not found.";
                    }

                    String json = req.body();


                    switch (command){
                        case signon:
                            SignonHandler signonHandler = new SignonHandler();
                            return signonHandler.handle(req.ip(), json);
                        case grouplist:
                            GrouplistHandler grouplistHandler = new GrouplistHandler();
                            return grouplistHandler.handle(json);

                    }



                    return "Hello World!";
                });

        Spark.get("/admin", (req, res)-> {
            return "<h1>Hier</h1>";
        });



    }
}
