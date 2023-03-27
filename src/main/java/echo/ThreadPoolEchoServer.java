package echo;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class ThreadPoolEchoServer extends EchoServer{
    int poolSize;

    public ThreadPoolEchoServer(int port, int poolSize){
        super(port);
        this.poolSize = poolSize;
    }

    @Override
    protected Executor makeExecutor() {
        return Executors.newFixedThreadPool(poolSize);
    }

    @Override
    protected Logger makeLogger() {
        return Logger.getLogger("ThreadPoolEchoServer");
    }
}
