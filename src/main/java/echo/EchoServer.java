package echo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.logging.Logger;

public abstract class EchoServer {
    protected int port;

    public EchoServer(int port){
        this.port = port;
    }

    public final void start() throws IOException {
        // Create a server socket to accept client connection requests
        ServerSocket servSock = new ServerSocket(port);
        Logger logger = makeLogger();
        Executor executor = makeExecutor();

        while (true) { // Run forever, accepting and servicing connections
            Socket clntSock = servSock.accept();     // Get client connection

            logger.info("Handling client at " + clntSock.getRemoteSocketAddress());
            executor.execute(new EchoProtocol(clntSock, logger));
        }
    }

    protected abstract Executor makeExecutor();

    protected abstract Logger makeLogger();
}
