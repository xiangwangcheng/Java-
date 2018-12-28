package com.study.lockwait;

import org.apache.ibatis.annotations.Param;

/**
 * Lock Wait Time Out
 *
 * @author chengxiangwang
 * @create 2018/6/1
 */
public interface LockWaitTimeOutDao {

  void updateStatus(@Param("id") String id);
  int getStatus(@Param("id") String id);
}
