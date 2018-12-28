package com.study.cxw.controller;

import com.study.cxw.dao.TestListParamDao;
import com.study.cxw.service.TestListParamService;
import java.util.Arrays;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * EmployeeService
 *
 * @author XiangwangTCheng chengxiangwang
 * @create 2017/12/6
 */
@RestController
@RequestMapping("v1/")
public class TestListParamController {

  @Autowired
  private TestListParamService testListParamService;
  @Autowired
  private TestListParamDao testListParamDao;

  @PutMapping("testListParam")
  public void testListParam() {
    Date updatedAt = testListParamDao.selectById("0039b1b8eefe47d4ab1388eeccf41b8d");
    testListParamService
        .testListParam();
  }
}
