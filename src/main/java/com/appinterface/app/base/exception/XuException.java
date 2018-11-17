package com.appinterface.app.base.exception;

/**
 * @ClassName: XuException 
 * @Description: 自定义异常
 * @author xuzhenyao
 * @date 2015-5-2 下午9:47:40 
 *
 */
public class XuException extends RuntimeException{
	public XuException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public XuException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public XuException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}
