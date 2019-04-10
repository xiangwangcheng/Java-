import com.chinamobile.tuxedo.sdk.api.Action;
import com.chinamobile.tuxedo.sdk.api.ConsumeContext;
import com.chinamobile.tuxedo.sdk.api.Consumer;
import com.chinamobile.tuxedo.sdk.api.Message;
import com.chinamobile.tuxedo.sdk.api.MessageListener;
import com.chinamobile.tuxedo.sdk.api.PropertyKeyConst;
import com.chinamobile.tuxedo.sdk.api.TuxeFactory;
import java.util.Properties;

public class TransactionMessageConsumer {
    public static void main(String[] args) throws InterruptedException {
        Properties properties = new Properties();
        // 您在控制台创建的 Consumer ID
        properties.put(PropertyKeyConst.ConsumerId, "CID_gjy333");

        properties.put(PropertyKeyConst.AccessKey, "10d34146c92d4ab6af9499c123");
        // 鉴权用 SecretKey，在阿里云服务器管理控制台创建
        properties.put(PropertyKeyConst.SecretKey, "10d34146c92d4ab6af9499c4d24d5123");
        properties.put(PropertyKeyConst.MsgTraceSwitch, true);
        properties.put(PropertyKeyConst.NAMESRV_ADDR, "10.154.0.136:9876");
        properties.put(PropertyKeyConst.AuthenticationRequired, "true");
        properties.put(PropertyKeyConst.ConsumeTimeout, 120000);
        Consumer traceConsumer = TuxeFactory.createConsumer(properties);


        traceConsumer.subscribe("topic_gjy333", "*", new MessageListener() { //订阅多个 Tag
            public Action consume(Message message, ConsumeContext context) {
                System.out.println("Receive: " + message.toString());
                return Action.CommitMessage;
            }
        });
        traceConsumer.start();
//        Thread.sleep(30000);
//        traceConsumer.shutdown();
    }
}