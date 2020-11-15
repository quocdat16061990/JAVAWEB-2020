package com.laptrinhjavaweb.enums;

public enum buildingTypes {
    TANG_TRET("Tầng trệt"),
    NGUYEN_CAN("Nguyên căn"),
    NOI_THAT("Nội thất");

    private  String buildingType;

    buildingTypes(String buildingTypeValue) {
        this.buildingType = buildingTypeValue;
    }

    public String getBuildingType() {
        return buildingType;
    }
}
