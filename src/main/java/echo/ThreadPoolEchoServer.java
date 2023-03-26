package echo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadPoolEchoServer extends EchoServer{
    int poolSize;

    public ThreadPoolEchoServer(int port, int poolSize){
        super(port);
        this.poolSize = poolSize;
    }
    @Override
    public void start() throws IOException {
        // Create a server socket to accept client connection requests
        final ServerSocket servSock = new ServerSocket(port);

        final Logger logger = Logger.getLogger("practical");

        // Spawn a fixed number of threads to service clients
        for (int i = 0; i < poolSize; i++) {
            Thread thread = new Thread() {
                public void run() {
                    while (true) {
                        try {
                            Socket clntSock = servSock.accept(); // Wait for a connection
                            EchoProtocol.handleEchoClient(clntSock, logger); // Handle it
                        } catch (IOException ex) {
                            logger.log(Level.WARNING, "Client accept failed", ex);
                        }
                    }
                }
            };
            thread.start();
            logger.info("Created and started Thread = " + thread.getName());
        }
    }
}
