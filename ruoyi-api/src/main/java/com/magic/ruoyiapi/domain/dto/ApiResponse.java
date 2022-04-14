package com.magic.ruoyiapi.domain.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ApiResponse implements Serializable {

	public static final int SUCCESS_CODE = 1000000;
	private int code = 1000000;
	private String msg = "成功";
	private Object data;
	public ApiResponse() {
		super();
	}

	public ApiResponse(Object data) {
		super();
		this.data = data;
	}

	public ApiResponse(ResponseCodeInterface response) {
		super();
		this.code = response.getCode();
		this.msg = response.getMsg();
	}

	public ApiResponse(int code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}
	public void setCodeAndMsg(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}
}
