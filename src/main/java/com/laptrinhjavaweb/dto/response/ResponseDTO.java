package com.laptrinhjavaweb.dto.response;

public class ResponseDTO {
    private Object data;
    private String mesager;
    private String detail;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMesager() {
        return mesager;
    }

    public void setMesager(String mesager) {
        this.mesager = mesager;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
