package com.xxx.util;

/**
 * 封装操作结果
 * @author miao
 * @date 2017年4月23日
 */

public class Result {
	private boolean success;
	private String reason;
	public Result(){
		super();
	}
	public Result(boolean success,String reason){
		super();
		this.success=success;
		this.reason=reason;
	}
	
	/**
	 * @return 所关联的操作是否成功
	 */
	public boolean isSuccess(){
		return success;
	}
	public void setSuccess(boolean success){
		this.success=success;
	}
	/**
	 * @return 原因说明
	 */
	public String getReason(){
		return reason;
	}
	public void setReason(String reason){
		this.reason=reason;
	}

}
