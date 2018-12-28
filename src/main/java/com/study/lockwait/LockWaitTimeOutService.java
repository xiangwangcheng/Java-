package com.study.lockwait;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * EmployeeService
 *
 * @author XiangwangTCheng chengxiangwang
 * @create 2017/12/6
 */
@Service
public class LockWaitTimeOutService {

  @Autowired
  private LockWaitTimeOutDao lockWaitTimeOutDao;

  @Transactional
  public void testLockWaitTimeOut() {
    lockWaitTimeOutDao.updateStatus("0049296c7fae47958804bc75911c0e24");
    forloop();
  }

  @Transactional
  public void updateAgain(String id) {
    System.out.println(System.currentTimeMillis());
    lockWaitTimeOutDao.updateStatus(id);
    System.out.println(System.currentTimeMillis());
  }

  public int getStatus(){
    return lockWaitTimeOutDao.getStatus("0049296c7fae47958804bc75911c0e24");
  }
  private void forloop() {
    while (true) {
//      System.out.println("test");
    }
  }
}
