package com.pcx.wcnserver.common;

/**
 * @author admin
 * 返回的结构
 */
public class MsgEntity {
	private int code;
	private String message;
	private Object result;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "MsgEntity [code=" + code + ", message=" + message + ", result="
				+ result + "]";
	}
	
	public MsgEntity(int code, String message, Object result) {
		super();
		this.code = code;
		this.message = message;
		this.result = result;
	}
	public MsgEntity() {
		super();
	}
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
	
}
