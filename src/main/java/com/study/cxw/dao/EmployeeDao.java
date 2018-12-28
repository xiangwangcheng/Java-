package com.study.cxw.dao;

import com.study.di.Employee;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * Employee Mapper
 *
 * @author chengxiangwang
 * @create 2017/12/6
 */
public interface EmployeeDao {

  List<Employee> getEmployeeByCondition(@Param("name") String name);

  List<Employee> selectByDepartmentId(@Param("departmentId") String departmentId);

  List<Employee> selectByDepartmentIdAndName(@Param("departmentId") String departmentId,@Param("name") String name);
}
