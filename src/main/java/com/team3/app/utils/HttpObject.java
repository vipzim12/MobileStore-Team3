package com.team3.app.utils;

public class HttpObject {
	private boolean isSuccess;
	private Object result;
	
	public HttpObject(boolean isSuccess, Object result) {
		super();
		this.isSuccess = isSuccess;
		this.result = result;
	}
	
	public boolean isSuccess() {
		return isSuccess;
	}
	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
	
	
}
