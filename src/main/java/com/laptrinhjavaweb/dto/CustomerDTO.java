package com.laptrinhjavaweb.dto;

public class CustomerDTO {

    private String full_Name;
    private String phone;
    private String email;
    private Integer staffId;
    private String note;


    public String getFullName() {
        return full_Name;
    }

    public void setFullName(String fullName) {
        this.full_Name = full_Name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
