package com.study.cxw.service;

import com.study.cxw.dao.TestListParamDao;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * EmployeeService
 *
 * @author XiangwangTCheng chengxiangwang
 * @create 2017/12/6
 */
@Service
public class TestListParamService {

  @Autowired
  private TestListParamDao testListParamDao;

  public void testListParam() {
//    Date updatedAt = testListParamDao.selectById("0039b1b8eefe47d4ab1388eeccf41b8d");
//    int result = testListParamDao
//        .updateStatusUsingOptimisticLock("0039b1b8eefe47d4ab1388eeccf41b8d", 4, updatedAt,
//            Arrays.asList(1, 6));

    Stream<String> stream = Stream.of("base", "ball");
    stream.map(s -> s.length()).forEach(System.out::print);
  }
}
