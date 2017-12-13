package com.copyblade.exception;

/**
 * 重定向异常
 */
public class ForbiddenException extends BladeException {

    private static final int STATUS = 403;
    private static final String NAME = "Forbidden";

    public ForbiddenException() {
        super(STATUS, NAME);
    }

    public ForbiddenException(String message){
        super(STATUS, NAME, message);
    }

}
