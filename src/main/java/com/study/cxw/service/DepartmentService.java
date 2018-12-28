package com.study.cxw.service;

import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.study.cxw.dao.DepartmentDao;
import com.study.di.Department;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Department Service
 *
 * @author XiangwangTCheng chengxiangwang
 * @create 2017/12/6
 */
@Service
public class DepartmentService {

  @Autowired
  private DepartmentDao departmentDao;

  public List<Department> getDepartments(String name) {
    return departmentDao.getDepartmentsByCondition(name);
  }

  public Department getDepartmentById(String id) {
    return departmentDao.selectByPrimaryKey(id);
  }

  public List<Department> getAllDepartments() {
    return departmentDao.getAllDepartments_NestedSelect();
  }

  public PageInfo<Department> getAllDepartments_NestedSelect(Integer pageSize, Integer pageNum) {
    PageInfo<Department> pageInfo = PageHelper.startPage(pageNum, pageSize)
        .doSelectPageInfo(new ISelect() {
          @Override
          public void doSelect() {
            departmentDao.getAllDepartments_NestedSelect();
          }
        });
    return pageInfo;
//    PageHelper.startPage(pageNum, pageSize);
//    List<Department> allDepartments = departmentDao.getAllDepartments();
//    PageInfo<Department> pageInfo = new PageInfo<>(allDepartments);
//    return pageInfo;
  }

  public PageInfo<Department> getAllDepartments_NestedResult(Integer pageSize, Integer pageNum) {
    PageInfo<Department> pageInfo = PageHelper.startPage(pageNum, pageSize)
        .doSelectPageInfo(new ISelect() {
          @Override
          public void doSelect() {
            departmentDao.getAllDepartments_NestedResultMap();
          }
        });
    return pageInfo;
//    PageHelper.startPage(pageNum, pageSize);
//    List<Department> allDepartments = departmentDao.getAllDepartments();
//    PageInfo<Department> pageInfo = new PageInfo<>(allDepartments);
//    return pageInfo;
  }
}
