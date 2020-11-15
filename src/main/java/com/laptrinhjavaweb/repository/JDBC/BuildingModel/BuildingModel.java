package com.laptrinhjavaweb.repository.JDBC.BuildingModel;

public class BuildingModel {
    private Long id;
    private String name;
    private String street;
    private String ward;
    private String district;
    private int numberofbasement;
    private String floorarea;
    private String rentprice;
    private String rentdescription;
    private String type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public int getNumberofbasement() {
        return numberofbasement;
    }

    public void setNumberofbasement(int numberofbasement) {
        this.numberofbasement = numberofbasement;
    }

    public String getFloorarea() {
        return floorarea;
    }

    public void setFloorarea(String floorarea) {
        this.floorarea = floorarea;
    }

    public String getRentprice() {
        return rentprice;
    }

    public void setRentprice(String rentprice) {
        this.rentprice = rentprice;
    }

    public String getRentdescription() {
        return rentdescription;
    }

    public void setRentdescription(String rentdescription) {
        this.rentdescription = rentdescription;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
