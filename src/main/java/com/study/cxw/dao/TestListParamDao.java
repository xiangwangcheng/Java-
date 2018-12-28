package com.study.cxw.dao;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * Deployment Mapper
 *
 * @author  chengxiangwang
 * @create 2017/12/6
 */
public interface TestListParamDao {

  int updateStatusUsingOptimisticLock(@Param("id") String id, @Param("status")Integer status, @Param("updatedAt")Date updatedAt, @Param("statuses") List<Integer> statuses);

  Date selectById(@Param("id") String id);
}
