package com.laptrinhjavaweb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "building")
public class BuildingEntity extends BaseEntity{

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "street" )
    private String street;

    @Column(name = "ward" )
    private String ward;

    @Column(name = "district" )
    private String district;

    @Column(name = "structure" )
    private String structure;

    @Column(name = "numberofbasement" )
    private Integer numberOfBasement;

    @Column(name = "floorarea" )
    private Integer floorArea;

    @Column(name = "direction" )
    private String direction;

    @Column(name = "level" )
    private String level;

    @Column(name = "rentprice" )
    private Integer rentPrice;

    @Column(name = "rentpricedescription" )
    private String rentPriceDescription;

    @Column(name = "servicefee" )
    private String serviceFee;

    @Column(name = "carfee" )
    private String carFee;

    @Column(name = "motorbikefee" )
    private String motorbikeFee;

    @Column(name = "overtimefee" )
    private String overtimeFee;

    @Column(name = "waterfee" )
    private String waterFee;

    @Column(name = "electricityfee" )
    private String electricityFee;

    @Column(name = "deposit" )
    private String deposit;

    @Column(name = "payment" )
    private String payment;

    @Column(name = "renttime" )
    private String rentTime;

    @Column(name = "decorationtime" )
    private String decorationTime;

    @Column(name = "brokeragefee" )
    private String brokerageFee;

    @Column(name = "note" )
    private String note;

    @Column(name = "linkofbuilding" )
    private String linkOfBuilding;

    @Column(name = "map" )
    private String map;

    @Column(name = "image" )
    private String image;

    @Column(name = "managername" )
    private String managerName;

    @Column(name = "managerphone" )
    private String managerPhone;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
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

    public Integer getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(Integer rentPrice) {
        this.rentPrice = rentPrice;
    }

    public String getRentPriceDescription() {
        return rentPriceDescription;
    }

    public void setRentPriceDescription(String rentPriceDescription) {
        this.rentPriceDescription = rentPriceDescription;
    }

    public String getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(String serviceFee) {
        this.serviceFee = serviceFee;
    }

    public String getCarFee() {
        return carFee;
    }

    public void setCarFee(String carFee) {
        this.carFee = carFee;
    }

    public String getMotorbikeFee() {
        return motorbikeFee;
    }

    public void setMotorbikeFee(String motorbikeFee) {
        this.motorbikeFee = motorbikeFee;
    }

    public String getOvertimeFee() {
        return overtimeFee;
    }

    public void setOvertimeFee(String overtimeFee) {
        this.overtimeFee = overtimeFee;
    }

    public String getWaterFee() {
        return waterFee;
    }

    public void setWaterFee(String waterFee) {
        this.waterFee = waterFee;
    }

    public String getElectricityFee() {
        return electricityFee;
    }

    public void setElectricityFee(String electricityFee) {
        this.electricityFee = electricityFee;
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

    public String getRentTime() {
        return rentTime;
    }

    public void setRentTime(String rentTime) {
        this.rentTime = rentTime;
    }

    public String getDecorationTime() {
        return decorationTime;
    }

    public void setDecorationTime(String decorationTime) {
        this.decorationTime = decorationTime;
    }

    public String getBrokerageFee() {
        return brokerageFee;
    }

    public void setBrokerageFee(String brokerageFee) {
        this.brokerageFee = brokerageFee;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getLinkOfBuilding() {
        return linkOfBuilding;
    }

    public void setLinkOfBuilding(String linkOfBuilding) {
        this.linkOfBuilding = linkOfBuilding;
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

}