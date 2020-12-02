package com.laptrinhjavaweb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "building")
public class BuildingEntity extends BaseEntity {

    private static final long serialVersionUID = -2853379557934065188L;

    @Column (name="name")
    private String name;

    @Column
    private String province;

    @Column
    private String street;

    @Column
    private String structure;

    @Column(name = "numberofbasement")
    private Integer numberOfBasement;

    @Column
    private Integer floorArea;

    @Column
    private String direction;

    @Column
    private String level;

    @Column
    private String feesBrokerage;

    @Column(columnDefinition = "TEXT")
    private String rentArea;

    @Column(columnDefinition = "TEXT")
    private String areaDescription;

    @Column
    private Integer costRent;

    @Column(columnDefinition = "TEXT")
    private String costDescription;

    @Column
    private String serviceCost;

    @Column
    private String carCost;

    @Column
    private String motorbikeCost;

    @Column
    private String overtimeCost;

    @Column
    private String electricityCost;

    @Column
    private String deposit;

    @Column
    private String payment;

    @Column
    private String timeContract;

    @Column
    private String timeDecorator;

    @Column
    private String managerName;

    @Column
    private String managerPhone;

    @Column
    private String commission;

    @Column(columnDefinition = "TEXT")
    private String type;

    @Column
    private String district;

    @Column(columnDefinition = "TEXT")
    private String note;

    @Column
    private String link;

    @Column
    private String location;

    @Column
    private String image;

    @Column
    private String areaFree;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
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

    public String getAreaDescription() {
        return areaDescription;
    }

    public void setAreaDescription(String areaDescription) {
        this.areaDescription = areaDescription;
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

    public String getMotorbikeCost() {
        return motorbikeCost;
    }

    public void setMotorbikeCost(String motorbikeCost) {
        this.motorbikeCost = motorbikeCost;
    }

    public String getOvertimeCost() {
        return overtimeCost;
    }

    public void setOvertimeCost(String overtimeCost) {
        this.overtimeCost = overtimeCost;
    }

    public String getElectricityCost() {
        return electricityCost;
    }

    public void setElectricityCost(String electricityCost) {
        this.electricityCost = electricityCost;
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

    public String getTimeContract() {
        return timeContract;
    }

    public void setTimeContract(String timeContract) {
        this.timeContract = timeContract;
    }

    public String getTimeDecorator() {
        return timeDecorator;
    }

    public void setTimeDecorator(String timeDecorator) {
        this.timeDecorator = timeDecorator;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getNumberOfBasement() {
        return numberOfBasement;
    }

    public void setNumberOfBasement(Integer numberOfBasement) {
        this.numberOfBasement = numberOfBasement;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
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

    public String getCommission() {
        return commission;
    }

    public void setCommission(String commission) {
        this.commission = commission;
    }

    public String getAreaFree() {
        return areaFree;
    }

    public void setAreaFree(String areaFree) {
        this.areaFree = areaFree;
    }

    public String getRentArea() {
        return rentArea;
    }

    public void setRentArea(String rentArea) {
        this.rentArea = rentArea;
    }

    public Integer getCostRent() {
        return costRent;
    }

    public void setCostRent(Integer costRent) {
        this.costRent = costRent;
    }

    public String getFeesBrokerage() {
        return feesBrokerage;
    }

    public void setFeesBrokerage(String feesBrokerage) {
        this.feesBrokerage = feesBrokerage;
    }

    public Integer getFloorArea() {
        return floorArea;
    }

    public void setFloorArea(Integer floorArea) {
        this.floorArea = floorArea;
    }
}
