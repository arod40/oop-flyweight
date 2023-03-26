import echo.EchoServer;
import echo.SingleThreadEchoServer;
import echo.ThreadPerConnectionEchoServer;
import echo.ThreadPoolEchoServer;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {
        if (args.length < 2) { // Test for correct # of args
            throw new IllegalArgumentException("Parameter(s): <EchoServerType> <Port> [<ThreadPoolSize>]");
        }

        String serverType = args[0];

        EchoServer server;

        if (serverType.equals("singleThread")){
            server = new SingleThreadEchoServer(Integer.parseInt(args[1]));
        }
        else if(serverType.equals("threadPerConnection")){
            server = new ThreadPerConnectionEchoServer(Integer.parseInt(args[1]));
        }
        else if(serverType.equals("threadPool")){
            if (args.length != 3)
                throw new IllegalArgumentException("If <EchoServerType> is equal to 'threadPool' must specify <ThreadPoolSize>");
            server = new ThreadPoolEchoServer(Integer.parseInt(args[1]), Integer.parseInt(args[2]));
        }
        else{
            throw new IllegalArgumentException("<EchoServerType> must be one of 'singleThread', 'threadPerConnection', 'threadPool', not '" + serverType + "'");
        }

        server.start();

    }
}
