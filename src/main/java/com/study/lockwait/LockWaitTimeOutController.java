package com.study.lockwait;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
public class LockWaitTimeOutController {

  @Autowired
  private LockWaitTimeOutService lockWaitTimeOutService;

  @PostMapping("lockwaittimeout")
  public void testLockWaitTimeOut() {
    lockWaitTimeOutService.testLockWaitTimeOut();
  }

  @PostMapping("updateagain/{id}")
  public void updateAgain(@PathVariable String id) {
    lockWaitTimeOutService.updateAgain(id);
  }

  @GetMapping("getstatus")
  public int getStatus() {
     return lockWaitTimeOutService.getStatus();
  }
}
