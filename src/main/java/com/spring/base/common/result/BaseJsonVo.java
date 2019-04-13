package com.spring.base.common.result;

import java.io.Serializable;
/**
 * 控制层返回封装类
 * @author LOVE_HAIYAN_521
 *
 * @param <T>
 */
public class  BaseJsonVo<T> implements Serializable  {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int SUCCESS_CODE = 200;
    public static final String SUCCESS_MESSAGE = "操作成功";
    public static final int PARAM_CODE = 400;
    public static final String PARAM_MESSAGE = "参数错误";
    public static final int NO_LOGIN_CODE = 20112;
    public static final String NO_LOGIN_MESSAGE = "客户端未登录！";
    public static final int NO_SECURITY_CODE = 403;
    public static final String NO_SECURITY_MESSAGE = "无权限！";
    public static final int ERROR_CODE = 500;
    public static final String ERROR_MESSAGE = "服务器繁忙，请稍后重试";
    public static final int ERROR_ACCOUNT_LOGIN_CODE = 410;
    public static final String ERROR_ACCOUNT_LOGIN_MESSAGE = "账户错误！";
    public static final int ERROR_LOGIN_CODE = 106;
    public static final String ERROR_LOGIN_MESSAGE = "登录错误！";
    public static final int SING_CODE = 40001;
    public static final String SIGN_MESSAGE = "验证失败！";
    public static final int ACTIVE_END_CODE = 40002;
    public static final String ACTIVE_END_MESSAGE = "活动结束！";
    public static final int PROMOTION_END_CODE = 40003;
    public static final String PROMOTION_END_MESSAGE = "促销未开始或已结束！";
    public static final int EXCEEDED_LIMIT = 40004;
    public static final String EXCEEDED_LIMIT_MESSAGE = "超过购买次数限制！";
    public static final int NO_PASSWORD = 100101;
    public static final int CITY_CLOSE = 1000;
    public static final String CITY_CLOS_MESSAGE = "城市关闭";
    public static final int DATE_ERROR = 1001;
    public static final String DATE_ERROR_MESSAGE = "配送日期错误";
    
    private int status;
    private String message;
    private long version = 1L;
    private T value;
    private long serverTime = System.currentTimeMillis();
    private T  result;
    private Integer error_code;
    private String error_msg;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public long getVersion() {
		return version;
	}
	public void setVersion(long version) {
		this.version = version;
	}
	public T getValue() {
		return value;
	}
	public void setValue(T value) {
		this.value = value;
	}
	public long getServerTime() {
		return serverTime;
	}
	public void setServerTime(long serverTime) {
		this.serverTime = serverTime;
	}
	public T getResult() {
		return result;
	}
	public void setResult(T result) {
		this.result = result;
	}
	public Integer getError_code() {
		return error_code;
	}
	public void setError_code(Integer error_code) {
		this.error_code = error_code;
	}
	public String getError_msg() {
		return error_msg;
	}
	public void setError_msg(String error_msg) {
		this.error_msg = error_msg;
	}
    

}
