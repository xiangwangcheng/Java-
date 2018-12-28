import java.time.Year;
import java.time.YearMonth;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author chengxiangwang
 * @create 2018/8/4
 */
@SpringBootTest
public class TestNewDateClass {

  @Test
  public void testYearMonth() {
    System.out.println(YearMonth.now());
    System.out.println(Year.now().toString());
  }
}
