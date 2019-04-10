import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.assertj.core.util.Lists;
import org.springframework.util.StringUtils;

public class Test {

    public static void main(String args[]) {
        System.out.println(add("123456789012345", "56789123405432"));
    }

    @org.junit.Test
    public void test() {
        String a = "/test";
        String[] split = StringUtils.split(a, "/");

//    String[] result = a.split("^");
        System.out.println(split[0]);
    }
  /*  @org.junit.Test
    public void testToJsonGson() {
        List<MqttTopicSubscription> topicSubscriptions = new ArrayList<>();
        topicSubscriptions.add(new MqttTopicSubscription("test1", MqttQoS.AT_LEAST_ONCE));
        topicSubscriptions.add(new MqttTopicSubscription("test2", MqttQoS.AT_MOST_ONCE));

        MqttSubscribePayload mqttSubscribePayload = new MqttSubscribePayload(topicSubscriptions);
        Gson gson = new Gson();
        String s = gson.toJson(mqttSubscribePayload);
        System.out.println(s);
    }

    @org.junit.Test
    public void testByteBufToJsonGson() {
        String content = new String();
        byte[] bytes = content.getBytes(Charset.forName("UTF-8"));
        ByteBuf buf = Unpooled.copiedBuffer(bytes);
        Gson gson = new Gson();
        String s = gson.toJson(buf);
        System.out.println(s);
    }

    @org.junit.Test
    public void testFromJsonGson() {
        Gson gson = new Gson();
        MqttSubscribePayload s = gson.fromJson("{\"topicSubscriptions\":[{\"topicFilter\":\"test1\",\"qualityOfService\":\"AT_LEAST_ONCE\"},{\"topicFilter\":\"test2\",\"qualityOfService\":\"AT_MOST_ONCE\"}]}",MqttSubscribePayload.class);
        System.out.println(s);
    }*/

    @org.junit.Test
    public void test1() {
        Integer a = 2;
        System.out.println(Integer.toBinaryString(a));
    }

    @org.junit.Test
    public void list2Bytes() throws IOException {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);

        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
        arrayOutputStream.write(0);
        arrayOutputStream.flush();
        System.out.println(arrayOutputStream.toByteArray().length);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
            arrayOutputStream);
        objectOutputStream.writeObject(0);
        objectOutputStream.flush();
        byte[] data = arrayOutputStream.toByteArray();
        System.out.println(data.length);
    }
    public static String add(String a, String b) {
        String ret = "";
        int a_length = a.length();
        int b_length = b.length();
        int maxLen = a_length > b_length ? a_length : b_length;
        int minLen = a_length < b_length ? a_length : b_length;
        StringBuilder s = new StringBuilder();

        for (int i = 0; i < maxLen - minLen; i++) {
            s.append(0);
        }
        if (minLen == a_length) {
            s.append(a);
            a = s.toString();
        } else {
            s.append(b);
            b = s.toString();
        }

        int temp_a, temp_b, result;
        int sc = 0;//进位
        for (int i = maxLen - 1; i >= 0; i--) {
            temp_a = Integer.valueOf(a.charAt(i));
            temp_b = Integer.valueOf(b.charAt(i));
            result = temp_a + temp_b + sc;
            sc = result / 10;
            result = result % 10;
            s.append(result);
        }
        if (sc == 1) {
            s.append(1);
        }
        ret = s.reverse().toString();

        return ret;
    }

    @org.junit.Test
    public void testBitOperation() {
        System.out.println(0x3 << 2);
    }

    @org.junit.Test
    public void testStream() {
        List<Integer> nums = Lists.newArrayList(1, 1, null, 2, 3, 4, null, 5, 6, 7, 8, 9, 10);
        System.out.println("sum is:" + nums.stream().filter(num -> num != null).
                distinct().mapToInt(num -> num * 2).
                peek(System.out::println).skip(2).limit(4).sum());

    }

    @org.junit.Test
    public void testRandom() {
        long seed = System.currentTimeMillis();
        System.out.println(seed);
        int random = new Random(seed).nextInt();
        System.out.println(random );
        System.out.println((Math.abs(random) % 99999999));
        System.out.println((Math.abs(random) % 99999999) % 1);

    }

}