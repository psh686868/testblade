package com.copyblade.exception;

/***
 * 模板异常，这里不做提示
 *
 */
public class TemplateException extends RuntimeException {

	public TemplateException(String message, Throwable cause) {
		super(message, cause);
	}

	public TemplateException(String message) {
		super(message);
	}

	public TemplateException(Throwable cause) {
		super(cause);
	}

}
