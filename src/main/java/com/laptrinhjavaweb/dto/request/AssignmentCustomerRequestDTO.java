package com.laptrinhjavaweb.dto.request;

public class AssignmentCustomerRequestDTO {
    private Long customerId;
    private Long[] staffs;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long[] getStaffs() {
        return staffs;
    }

    public void setStaffs(Long[] staffs) {
        this.staffs = staffs;
    }
}
