package com.study;

import com.study.conditionalonmissingbean.ClassWIthComponent;
import com.study.conditionalonmissingbean.ClassWithOutComponent;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

/**
 * 启动类
 *
 * @author XiangwangTCheng chengxiangwang
 * @create 2017/12/6
 */
@SpringBootApplication
@MapperScan("com.study.*") //使用@MapperScan注解后，就不需要在Mybatis的Mapper Interface上加@Mapper注解了。
public class Application {

  public static void main(String[] args) throws NoSuchMethodException {
    SpringApplication.run(Application.class, args);

    Method createClassWithoutComponent = Application.class
            .getDeclaredMethod("createClassWithoutComponent", null);

    Annotation[] declaredAnnotations = createClassWithoutComponent.getDeclaredAnnotations();
    for (Annotation annotation : declaredAnnotations) {
      System.out.println(annotation.toString());

    }

    Annotation[] annotations = ClassWIthComponent.class.getAnnotations();
    for (Annotation annotation : annotations) {
      System.out.println(annotation.toString());
    }

  }


  @ConditionalOnMissingBean(ClassWithOutComponent.class)
  @Bean
  public ClassWithOutComponent createClassWithoutComponent() {
    System.out.println("new ClassWithoutComponent() will be invoked.");
    return new ClassWithOutComponent("without component");
  }
}