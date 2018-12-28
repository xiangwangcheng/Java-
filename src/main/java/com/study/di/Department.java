package com.study.di;

import java.util.List;
import org.springframework.stereotype.Component;

/**
 * 部门Model类
 *
 * @author XiangwangTCheng chengxiangwang
 * @create 2017/12/6
 */
@Component
public class Department {
  private String id;
  private String name;
  private String description;
  private List<Employee> employeeList;
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

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public List<Employee> getEmployeeList() {
    return employeeList;
  }

  public void setEmployeeList(List<Employee> employeeList) {
    this.employeeList = employeeList;
  }

  @Override
  public String toString() {
    return "DepartmentDao{" +
        "id='" + id + '\'' +
        ", name='" + name + '\'' +
        ", description='" + description + '\'' +
        '}';
  }
}
