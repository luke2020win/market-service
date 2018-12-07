package com.joiest.market.common.enumclass;

/**
 * 编码格式的枚举类
 * @author admin 
 */
public enum TranscodingEnum {

    UTF_8("UTF-8"),
    GBK("GBK");

    private final String code;

    TranscodingEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
