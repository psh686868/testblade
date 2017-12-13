package com.copyblade.exception;

import lombok.Data;

/**
 * 异常的基类， 一些http
 */
@Data
public class BladeException extends RuntimeException {

    protected int    status;
    protected String name;

    public BladeException(int status, String name) {
        this.status = status;
        this.name = name;
    }

    public BladeException(int status, String name, String message) {
        super(message);
        this.status = status;
        this.name = name;
    }

}
