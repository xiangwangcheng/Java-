import com.chinamobile.tuxedo.sdk.api.Message;
import com.chinamobile.tuxedo.sdk.api.PropertyKeyConst;
import com.chinamobile.tuxedo.sdk.api.SendResult;
import com.chinamobile.tuxedo.sdk.api.TuxeFactory;
import com.chinamobile.tuxedo.sdk.api.transaction.TransactionProducer;
import com.chinamobile.tuxedo.sdk.shade.client.log.ClientLogger;
import com.chinamobile.tuxedo.sdk.shade.client.producer.LocalTransactionState;
import com.chinamobile.tuxedo.sdk.shade.client.producer.TransactionListener;
import com.chinamobile.tuxedo.sdk.shade.common.message.MessageExt;
import com.chinamobile.tuxedo.sdk.shade.logging.InternalLogger;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TransactionMessageTest {
    private final static InternalLogger log = ClientLogger.getLog(); // 您需要设置自己的日志，便于排查问题

    public static void main(String[] args) throws InterruptedException {
        Properties properties = new Properties();
        // 您在 MQ 控制台创建的 Producer ID
        properties.put(PropertyKeyConst.ProducerId, "PID_gjy333");
        properties.put(PropertyKeyConst.AccessKey, "10d34146c92d4ab6af9499c123");
//        properties.put(PropertyKeyConst.AccessKey, "10d34146c92d4ab6af9499c441");
        // 鉴权用 SecretKey，在阿里云服务器管理控制台创建
        properties.put(PropertyKeyConst.SecretKey, "10d34146c92d4ab6af9499c4d24d5123");
        properties.put(PropertyKeyConst.AuthenticationRequired, "true");
//        properties.put(PropertyKeyConst.SecretKey, "10d34146c92d4ab6af9499c4d24d5541");
        // 设置 接入点
        properties.put(PropertyKeyConst.NAMESRV_ADDR,
                "10.154.0.136:9876");
        properties.put(PropertyKeyConst.SendMsgTimeoutMillis, 120000);
        TransactionProducer producer = TuxeFactory.createTransactionProducer(properties, new TransactionListener() {

            public LocalTransactionState executeLocalTransaction(
                    com.chinamobile.tuxedo.sdk.shade.common.message.Message msg, Object arg) {
                System.out.println("execute local logic");
                return LocalTransactionState.COMMIT_MESSAGE;
            }


            public LocalTransactionState checkLocalTransaction(MessageExt msg) {
                return LocalTransactionState.COMMIT_MESSAGE;
            }
        });
        // 在发送消息前，必须调用 start 方法来启动 Producer，只需调用一次即可
        producer.start();

        Message msg = new Message("topic_gjy333", "tagA", "Hello MQ transaction===".getBytes());
        try {
            SendResult sendResult = producer.send(msg, null);
            System.out.println("send transaction message succeed. msg=" + msg.toString());
        } catch (Exception e) {
            // 消息发送失败，需要进行重试处理，可重新发送这条消息或持久化这条数据进行补偿处理
            System.out.println(new Date() + " Send mq message failed. Topic is:" + msg.getTopic());
            e.printStackTrace();
        }
        // demo example 防止进程退出(实际使用不需要这样)
        TimeUnit.MILLISECONDS.sleep(Integer.MAX_VALUE);
        producer.shutdown();
    }
}
