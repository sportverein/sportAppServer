import handler.SignonHandler;
import protocol.Command;
import spark.Spark;

public class SportAppServer {
    public static void main(String[] args) {
        Spark.port(Properties.SERVERPORT_SPARK);
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


                    }



                    return "Hello World!";
                });
    }
}
