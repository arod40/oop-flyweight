package echo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SingleThreadEchoServer extends EchoServer{
    private static final int BUFSIZE = 32;   // Size of receive buffer

    public SingleThreadEchoServer(int port) {
        super(port);
    }

    @Override
    public void start () throws IOException {
        // Create a server socket to accept client connection requests
        ServerSocket servSock = new ServerSocket(port);

        Logger logger = Logger.getLogger("SingleThreadEchoServer");

        int recvMsgSize;   // Size of received message
        byte[] receiveBuf = new byte[BUFSIZE];  // Receive buffer

        while (true) { // Run forever, accepting and servicing connections
            Socket clntSock = servSock.accept();     // Get client connection

            SocketAddress clientAddress = clntSock.getRemoteSocketAddress();
            logger.log(Level.INFO, "Handling client at " + clientAddress);

            EchoProtocol.handleEchoClient(clntSock, logger); // Handle it
        }
        /* NOT REACHED */
    }
}
