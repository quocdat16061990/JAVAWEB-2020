package com.laptrinhjavaweb.dto;

import java.util.List;

public class BuildingDTO {

    private String name;
    private String ward;
    private String street;
    private String structure;
    private Integer numberOfBasement;
    private Integer floorArea;
    private String direction;
    private String level;
    private String rentAreaDescription;
    private String district;
    private Integer rentAreaTo;
    private Integer rentAreaFrom;
    private Integer rentCostTo;
    private Integer rentCostFrom;
    private Integer rentCost;

    public Integer getRentCost() {
        return rentCost;
    }

    public void setRentCost(Integer rentCost) {
        this.rentCost = rentCost;
    }

    private String costDescription;
    private String serviceCost;
    private String carCost;
    private String motorCost;
    private String overtimeCost;
    private String waterCost;
    private String electricBill;
    private String deposit;
    private String payment;
    private String timeRent;
    private String timeDecorator;
    private String[] type = new String[]{};
    private String managerName ;
    private String managerPhone ;
    private Integer staffId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public Integer getNumberOfBasement() {
        return numberOfBasement;
    }

    public void setNumberOfBasement(Integer numberOfBasement) {
        this.numberOfBasement = numberOfBasement;
    }

    public Integer getFloorArea() {
        return floorArea;
    }

    public void setFloorArea(Integer floorArea) {
        this.floorArea = floorArea;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getRentAreaDescription() {
        return rentAreaDescription;
    }

    public void setRentAreaDescription(String rentAreaDescription) {
        this.rentAreaDescription = rentAreaDescription;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Integer getRentAreaTo() {
        return rentAreaTo;
    }

    public void setRentAreaTo(Integer rentAreaTo) {
        this.rentAreaTo = rentAreaTo;
    }

    public Integer getRentAreaFrom() {
        return rentAreaFrom;
    }

    public void setRentAreaFrom(Integer rentAreaFrom) {
        this.rentAreaFrom = rentAreaFrom;
    }

    public Integer getRentCostTo() {
        return rentCostTo;
    }

    public void setRentCostTo(Integer rentCostTo) {
        this.rentCostTo = rentCostTo;
    }

    public Integer getRentCostFrom() {
        return rentCostFrom;
    }

    public void setRentCostFrom(Integer rentCostFrom) {
        this.rentCostFrom = rentCostFrom;
    }

    public String getCostDescription() {
        return costDescription;
    }

    public void setCostDescription(String costDescription) {
        this.costDescription = costDescription;
    }

    public String getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(String serviceCost) {
        this.serviceCost = serviceCost;
    }

    public String getCarCost() {
        return carCost;
    }

    public void setCarCost(String carCost) {
        this.carCost = carCost;
    }

    public String getMotorCost() {
        return motorCost;
    }

    public void setMotorCost(String motorCost) {
        this.motorCost = motorCost;
    }

    public String getOvertimeCost() {
        return overtimeCost;
    }

    public void setOvertimeCost(String overtimeCost) {
        this.overtimeCost = overtimeCost;
    }

    public String getWaterCost() {
        return waterCost;
    }

    public void setWaterCost(String waterCost) {
        this.waterCost = waterCost;
    }

    public String getElectricBill() {
        return electricBill;
    }

    public void setElectricBill(String electricBill) {
        this.electricBill = electricBill;
    }

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getTimeRent() {
        return timeRent;
    }

    public void setTimeRent(String timeRent) {
        this.timeRent = timeRent;
    }

    public String getTimeDecorator() {
        return timeDecorator;
    }

    public void setTimeDecorator(String timeDecorator) {
        this.timeDecorator = timeDecorator;
    }

    public String[] getType() {
        return type;
    }

    public void setType(String[] type) {
        this.type = type;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerPhone() {
        return managerPhone;
    }

    public void setManagerPhone(String managerPhone) {
        this.managerPhone = managerPhone;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }
}
