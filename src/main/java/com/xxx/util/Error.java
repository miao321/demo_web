package com.xxx.util;

/**
 * 封装异常信息
 * @author miao
 * @date 2017年4月23日
 */

public class Error {
	private String reason;
	private Throwable cause;
	
	public Error(){
		super();
	}
	public Error(String reason,Throwable cause){
		super();
		this.reason=reason;
		this.cause=cause;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Throwable getCause() {
		return cause;
	}
	public void setCause(Throwable cause) {
		this.cause = cause;
	}
	

}
