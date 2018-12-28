package jedis;

import java.util.HashSet;
import java.util.Set;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;
import redis.clients.jedis.Pipeline;

public class JedisTest {

    @Test
    public void test() {
        Jedis jedis = new Jedis("10.154.4.190", 6379);
        System.out.println(System.currentTimeMillis());
        for(int i = 0; i < 10000; i++) {
            jedis.hset("hashkey" + i, "field" + i, "value" + i);
        }
        System.out.println(System.currentTimeMillis());
    }

    @Test
    public void testPipeline() {
        Jedis jedis = new Jedis("10.154.4.190", 6379);
        System.out.println(System.currentTimeMillis());
        for(int i = 0; i < 100; i++) {
            Pipeline pipeline = jedis.pipelined();
            for(int j = i * 100; j < (i + 1) * 100; j++) {
                pipeline.hset("hashkey_pipline" + j, "field_pipline" + j, "value_pipline" + j);

            }
            pipeline.syncAndReturnAll();
        }
        System.out.println(System.currentTimeMillis());
    }

    @Test
    public void testSentinel() {
        Set<String> sentinelSet = new HashSet();
        sentinelSet.add("10.154.4.181:26379");
        sentinelSet.add("10.154.4.182:26380");
        sentinelSet.add("10.154.4.183:26381");
        Jedis resource = null;
        try {
            JedisSentinelPool sentinelPool = new JedisSentinelPool("mymaster", sentinelSet);
            resource = sentinelPool.getResource();
            resource.set("1217", "22:36");
        } catch (Exception e) {

        }finally {
            resource.close();
        }
    }

}