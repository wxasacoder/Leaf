package com.sankuai.inf.leaf.server.exception;

public class LeafServerException extends RuntimeException {

    private String errorCode;

    public LeafServerException(String code, String message) {
        super(message);
        this.errorCode = code;
    }


    public String getErrorCode() {
        return errorCode;
    }
}
