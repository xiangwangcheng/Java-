package com.study.di;

import org.springframework.stereotype.Component;

/**
 * 员工Model类
 *
 * @author XiangwangTCheng chengxiangwang
 * @create 2017/12/6
 */
@Component
public class Employee {

  private String id;
  private String name;
  private String departmentId;
  private String description;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDepartmentId() {
    return departmentId;
  }

  public void setDepartmentId(String departmentId) {
    this.departmentId = departmentId;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public String toString() {
    return "EmployeeDao{" +
        "id='" + id + '\'' +
        ", name='" + name + '\'' +
        ", departmentId='" + departmentId + '\'' +
        ", description='" + description + '\'' +
        '}';
  }

    /**
     * @author chengxiangwang
     * @create 2018/10/26
     */
    public static class TestModel {

      private int value;

      public TestModel(int value) {
        this.value = value;
      }

      public int getValue() {
        return value;
      }

      public void setValue(int value) {
        this.value = value;
      }
    }
}
