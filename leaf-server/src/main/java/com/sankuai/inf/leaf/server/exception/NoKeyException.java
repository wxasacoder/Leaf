package com.sankuai.inf.leaf.server.exception;

public class NoKeyException extends RuntimeException {


    private String errorCode;


    public NoKeyException(String errorCode) {
        super("key not fund in leaf, please init first");
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }


}
