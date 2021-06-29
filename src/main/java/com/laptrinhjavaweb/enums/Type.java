package com.laptrinhjavaweb.enums;

public enum Type {
    TANG_TRET ("Tầng trệt"),
    NGUYEN_CAN ("Nguyên căn"),
    NOI_THAT ("Nội thất"),
    ;

    private final String value;

    Type(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }
}
