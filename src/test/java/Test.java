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
        String a = "8^3";
        String[] split = StringUtils.split(a, "^");

//    String[] result = a.split("^");
        System.out.println(split[0]);
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
        System.out.println((Math.abs(random) % 99999999) % 1);

    }

}