package echo;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class ThreadPerConnectionEchoServer extends EchoServer{

    public ThreadPerConnectionEchoServer(int port) {
        super(port);
    }

    @Override
    protected Executor makeExecutor() {
        return Executors.newCachedThreadPool();
    }

    @Override
    protected Logger makeLogger() {
        return Logger.getLogger("ThreadPerConnectionEchoServer");
    }
}
