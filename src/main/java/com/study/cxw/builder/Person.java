package com.study.cxw.builder;

/**
 * @author chengxiangwang
 * @create 2018/10/9
 */
public class Person {

  @Override
  public String toString() {
    return "Person{" +
        "name='" + name + '\'' +
        ", age=" + age +
        ", gender='" + gender + '\'' +
        '}';
  }

  private String name;
  private int age;
  private String gender;

  private Person(Builder builder) {
    name = builder.name;
    age = builder.age;
    gender = builder.gender;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static final class Builder {

    private String name;
    private int age;
    private String gender;

    public Builder() {
    }

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public Builder age(int age) {
      this.age = age;
      return this;
    }

    public Builder gender(String gender) {
      this.gender = gender;
      return this;
    }

    public Person build() {
      return new Person(this);
    }
  }
}
