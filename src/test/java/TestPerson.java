import com.study.cxw.builder.Person;
import org.junit.Test;

/**
 * @author chengxiangwang
 * @create 2018/10/9
 */
public class TestPerson {


  @Test
  public void testBuilder() {
    Person person = Person.newBuilder().age(2).name("test").gender("sex").build();
    System.out.println(person);
  }
}
