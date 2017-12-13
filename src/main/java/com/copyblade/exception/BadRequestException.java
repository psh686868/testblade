package com.copyblade.exception;

/**
 *
 * 实现http规范，定义一些异常
 *
 */
public class BadRequestException extends BladeException {

    private static final int    STATUS = 400;
    private static final String NAME   = "Bad Request";

    public BadRequestException() {
        super(STATUS, NAME);
    }

    public BadRequestException(String message) {
        super(STATUS, NAME, message);
    }

}