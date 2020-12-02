package com.laptrinhjavaweb.repository.custom.impl;

import com.laptrinhjavaweb.dto.SearchBuildingDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.repository.custom.BuildingRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class BuildingRepositoryImpl implements BuildingRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<BuildingEntity> search(SearchBuildingDTO search) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT b.* FROM building as b");
        if (search.getStaffId() != null) {
            sql.append(" left join assignmentbuilding ab on ab.buildingid = b.id");
        }
        sql.append(" WHERE 1 = 1");
        if (search.getAreaRentFrom() != null || search.getAreaRentTo() != null) {
            if (search.getAreaRentFrom() != null && search.getAreaRentTo() != null) {
                sql.append(" AND EXISTS (SELECT * FROM rentarea AS ra WHERE ra.buildingid = b.id AND value BETWEEN " + search.getAreaRentFrom() + " AND " + search.getAreaRentTo());
            } else {
                sql.append(" AND EXISTS (SELECT * FROM rentarea AS ra WHERE ra.buildingid = b.id AND value >=  " + search.getAreaRentFrom());
            }
            sql.append(")");
        } else if (search.getAreaRentTo() != null) {
            sql.append(" AND EXISTS (SELECT * FROM rentarea AS ra WHERE ra.buildingid = b.id AND value <= " + search.getAreaRentTo() + ")");
        }
        if (search.getName() != null && search.getName() != "") {
            sql.append(" AND b.name LIKE '%"+ search.getName() +"%'");
        }
        if (search.getFloorArea() != null) {
            sql.append(" AND b.floorarea = " + search.getFloorArea());
        }
        if (search.getDistrict() != null && search.getDistrict() != "") {
            sql.append(" AND b.district LIKE '%" + search.getDistrict() +"%'");
        }
        if (search.getWard() != null && search.getWard() != "") {
            sql.append(" AND b.ward LIKE '%"+ search.getWard() +"%'");
        }
        if (search.getStreet() != null && search.getStreet() != "") {
            sql.append(" AND b.street LIKE '%"+ search.getStreet() +"%'");
        }
        if (search.getNumberOfBasement() != null) {
            sql.append(" AND b.numberofbasement = " + search.getNumberOfBasement());
        }
        if (search.getDirection() != null && search.getDirection() != "") {
            sql.append(" AND b.direction LIKE '%" + search.getDirection() + "%'");
        }
        if (search.getLevel() != null && search.getLevel() != "") {
            sql.append(" AND b.level LIKE '% " + search.getLevel()+ "%'");
        }
        if (search.getCostRentFrom() != null || search.getCostRentTo() != null) {
            if (search.getCostRentFrom() != null) {
                sql.append(" AND b.rentprice >= " + search.getCostRentFrom());
            }
            if (search.getCostRentTo() != null){
                sql.append(" AND b.rentprice <= " + search.getCostRentTo() +"");
            }
        }
        if (search.getManagerName() != null && search.getManagerName() != "") {
            sql.append(" AND b.managername LIKE '%"+ search.getManagerName() +"%'");
        }
        if (search.getManagerPhone() != null && search.getManagerPhone() != "") {
            sql.append(" AND b.managerphone LIKE '%"+ search.getManagerPhone() +"%'");
        }
        if (search.getBuildingTypes() != null && search.getBuildingTypes().length > 0 ) {
            sql.append("and (b.types LIKE '%");
            for (int i = 0; i < search.getBuildingTypes().length;i++) {
                sql.append(search.getBuildingTypes()[i]);
                if (i != search.getBuildingTypes().length - 1) {
                    sql.append("%' or b.types LIKE '%");
                }
            }
            sql.append("%')");
        }
        sql.append(" GROUP BY b.id");
        sql.toString();

        Query query=entityManager.createNativeQuery(sql.toString(),BuildingEntity.class);
        return query.getResultList();
    }
}
