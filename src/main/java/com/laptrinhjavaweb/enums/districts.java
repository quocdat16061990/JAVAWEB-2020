package com.laptrinhjavaweb.enums;

public enum districts {
    QUAN_1("Quận 1"),
    QUAN_2("Quận 2"),
    QUAN_3("Quận 3");

    private String districtCode;
    districts(String districtCode){
        this.districtCode=districtCode;
    }
    public String getValueDistrictCode(){
        return this.districtCode;
    }
}
