package echo;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class SingleThreadEchoServer extends EchoServer{
    public SingleThreadEchoServer(int port) {
        super(port);
    }

    @Override
    protected Executor makeExecutor() {
        return Executors.newSingleThreadExecutor();
    }

    @Override
    protected Logger makeLogger() {
        return Logger.getLogger("SingleThreadEchoServer");
    }
}
