package com.study.di;

/**
 * 返回包装类，使用泛型
 *
 * @author chengxiangwang
 * @create 2017/12/6
 */
public class Response<T> {

  private T entity;
  private boolean status;
  private String message;

  public T getEntity() {
    return entity;
  }

  public void setEntity(T entity) {
    this.entity = entity;
  }

  public boolean isStatus() {
    return status;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Response(boolean status,T entity,String message){
    this.status = status;
    this.entity = entity;
    this.message = message;
  }
  public static <T> Response success(T entity) {
    return new Response(true, entity, null);
  }

  public static <T> Response fail(T entity, String message) {
    return new Response(false, entity, message);
  }
}
