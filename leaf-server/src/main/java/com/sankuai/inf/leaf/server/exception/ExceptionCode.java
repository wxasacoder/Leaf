package com.sankuai.inf.leaf.server.exception;

/**
 *
 * @author wuxin
 * @date 2025/09/02 10:25:48
 *
 */
public enum ExceptionCode {
    ID_GEN_ERROR("1040001","Id生产异常"),
    KEY_IS_EMPTY_ERROR("1040002","KEY为空")


    ;


    private String code;
    private String desc;


    ExceptionCode(String code,String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public String getCode() {
        return code;
    }



}
