package com.copyblade.exception;

/**
 * 500 internal error exception
 * 系统内部错误
 *
 */
public class InternalErrorException extends BladeException {

    public static final int STATUS = 500;
    private static final String NAME = "Internal Error";

    public InternalErrorException() {
        super(STATUS, NAME);
    }

    public InternalErrorException(String message) {
        super(STATUS, NAME, message);
    }

}
