import com.study.di.Employee;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by xuzimian on 17-3-1.
 */
public class TestConcurrentHashMap {



  public static void main(String[] args) throws InterruptedException {
    testFunc();
  }
  public static void testFunc() throws InterruptedException {
    final ConcurrentHashMap<String, Employee.TestModel> map = new ConcurrentHashMap();
    map.put("test", new Employee.TestModel(1));

    for(int i =0; i < 1000; i++) {
      new MyThread(map).start();
    }
//    thread1.start();
//    thread2.start();
    Thread.sleep(10000);
    System.out.println("最终结果：" + map.get("test").getValue());
  }
}