package com.copyblade.exception;

/**
 *  404 not found exception
 *  没有找到相关资源
 */
public class NotFoundException extends BladeException {

    public static final int    STATUS = 404;
    private static final String NAME   = "Not Found";

    public NotFoundException() {
        super(STATUS, NAME);
    }

    public NotFoundException(String message) {
        super(STATUS, NAME, message);
    }

}
