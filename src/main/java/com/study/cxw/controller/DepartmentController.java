package com.study.cxw.controller;

import com.study.di.Department;
import com.study.di.Response;
import com.study.cxw.service.DepartmentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 部门接口
 *
 * @author chengxiangwang
 * @create 2017/12/6
 */
@RestController
@RequestMapping("v1/")
public class DepartmentController {

  @Autowired
  private DepartmentService departmentService;

  @GetMapping("departments_nestedresult/all")
  public Response<?> getAllDepartments_NestedResult(
      @RequestParam(value = "pageSize", required = false) Integer pageSize,
      @RequestParam(value = "pageNum", required = false) Integer pageNum) {
    if (pageNum != null && pageSize != null) {
      return Response.success(departmentService.getAllDepartments_NestedResult(pageSize,pageNum));
    }
    return Response.success(departmentService.getAllDepartments());
  }

  @GetMapping("departments_nestedselect/all")
  public Response<?> getAllDepartments_NestedSelect(
      @RequestParam(value = "pageSize", required = false) Integer pageSize,
      @RequestParam(value = "pageNum", required = false) Integer pageNum) {
    if (pageNum != null && pageSize != null) {
      return Response.success(departmentService.getAllDepartments_NestedSelect(pageSize,pageNum));
    }
    return Response.success(departmentService.getAllDepartments());
  }

  @GetMapping("departments")
  public List<Department> getDepartmentByCondition(@RequestParam("name") String name) {
    return departmentService.getDepartments(name);
  }
  @GetMapping("departments/{departmentId}")
  public Department getDepartmentById(@PathVariable("departmentId") String departmentId) {
    return departmentService.getDepartmentById(departmentId);
  }
}
