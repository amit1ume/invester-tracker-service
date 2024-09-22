package com.recommendation.stock.common;

public enum StatusEnum {
    TARGET_HIT("TARGET_HIT"),SL_HIT("SL_HIT"),TIME_COMPLETION("TIME_COMPLETION");
    private String value;

    StatusEnum(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
