package com.laptrinhjavaweb.repository.JDBCModel;

public class BuildingModel {
    private Long id;
    private String name;
    private String street;
    private String ward;
    private String district;
    private int numberofbasement;
    private int floorarea;



    private int rentprice;

    private int rentdescription;
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

    public int getFloorarea() {
        return floorarea;
    }

    public void setFloorarea(int floorarea) {
        this.floorarea = floorarea;
    }

    public int getRentprice() {
        return rentprice;
    }

    public void setRentprice(int rentprice) {
        this.rentprice = rentprice;
    }

    public int getRentdescription() {
        return rentdescription;
    }

    public void setRentdescription(int rentdescription) {
        this.rentdescription = rentdescription;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
