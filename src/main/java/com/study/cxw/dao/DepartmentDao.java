package com.study.cxw.dao;

import com.study.di.Department;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * Deployment Mapper
 *
 * @author  chengxiangwang
 * @create 2017/12/6
 */
public interface DepartmentDao {

  List<Department> getDepartmentsByCondition(@Param("name") String name);

  Department selectByPrimaryKey(String id);

  List<Department> getAllDepartments_NestedResultMap();

  List<Department> getAllDepartments_NestedSelect();
}
