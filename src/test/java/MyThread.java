import com.study.di.Employee;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author chengxiangwang
 * @create 2018/10/26
 */
public class MyThread extends Thread {

  private ConcurrentHashMap<String, Employee.TestModel> map;
  public MyThread(ConcurrentHashMap map) {
    super();
    this.map = map;
  }
  @Override
  public void run() {
    int n = 0;
    while (n < 100) {
      System.out.println("线程" + Thread.currentThread().getName() + ":" + map.get("test").getValue());
      Employee.TestModel test = map.get("test");
      int newValue = test.getValue() + 1;
      test.setValue(newValue);
      n++;
//      try {
//        Thread.sleep(60);
//      } catch (InterruptedException e) {
//        e.printStackTrace();
//      }
    }
    System.out.println("线程" + Thread.currentThread().getName() + "最终结果:" + map.get("test").getValue());
  }
}
