package com.zkjl.wf_clserver.core.common;

import java.io.Serializable;

public class ApiResult<T> implements Serializable{
  private static final long serialVersionUID = 8052566108151898248L;
  public static final String SUCCESS_MESSAGE_CODE = "front.common.success";
  public static final int SUCCESS = 0;
  public static final int ERROR = -1;
  public static final int LOGIN_ERROR = -3;
  public static final int SYSTEM_ERROR = -4;
  private int code = 0;
  private String message = "";
  private T data;
  
  public ApiResult(int code, String message, T data)
  {
    this.code = code;
    this.message = message;
    this.data = data;
  }
  
  public ApiResult(int code, String message)
  {
    this(code, message, null);
  }
  
  public ApiResult() {}
  
  public static <T> ApiResult<T> error(int code, String message)
  {
    return new ApiResult(code, message);
  }
  
  public static <T> ApiResult<T> error(String message)
  {
    return error(-1, message);
  }

  
  public int getCode()
  {
    return this.code;
  }
  
  public void setCode(int code)
  {
    this.code = code;
  }

  public String getMessage()
  {
    return this.message;
  }
  
  public void setMessage(String message)
  {
    this.message = message;
  }
  
  public T getData()
  {
    return (T)this.data;
  }
  
  public void setData(T data)
  {
    this.data = data;
  }
}


