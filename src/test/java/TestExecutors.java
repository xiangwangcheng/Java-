import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.apache.rocketmq.common.ThreadFactoryImpl;
import org.junit.Test;

public class TestExecutors {
    @Test
    public void testStream() throws InterruptedException {
        ScheduledExecutorService scheduledExecutorService = Executors
                .newScheduledThreadPool(8, new ThreadFactoryImpl("Test"));

        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("Test print1.");
            }
        }, 60000, 10000, TimeUnit.MILLISECONDS);


        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("Test print2.");
            }
        }, 30000, 5000, TimeUnit.MILLISECONDS);

        Thread.sleep(60000000);
    }

}