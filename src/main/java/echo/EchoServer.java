package echo;

import java.io.IOException;

public abstract class EchoServer {
    protected int port;

    public EchoServer(int port){
        this.port = port;
    }

    public abstract void start() throws IOException;
}
