package com.laptrinhjavaweb.repository.custom.impl;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.repository.custom.BuildingRespositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class BuildingRespositoryImpl implements BuildingRespositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<BuildingEntity> fidnAll(BuildingDTO model) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT b.* FROM building as b");
        if (model.getStaffId() != null) {
            sql.append(" left join assignmentbuilding ab on ab.buildingid = b.id");
        }
        sql.append(" WHERE 1 = 1");
        if (model.getAreaRentFrom() != null || model.getAreaRentTo() != null) {
            if (model.getAreaRentFrom() != null && model.getAreaRentTo() != null) {
                sql.append(" AND EXISTS (SELECT * FROM rentarea AS ra WHERE ra.buildingid = b.id AND value BETWEEN " + model.getAreaRentFrom() + " AND " + model.getAreaRentTo());
            } else {
                sql.append(" AND EXISTS (SELECT * FROM rentarea AS ra WHERE ra.buildingid = b.id AND value >=  " + model.getAreaRentFrom());
            }
            sql.append(")");
        } else if (model.getAreaRentTo() != null) {
            sql.append(" AND EXISTS (SELECT * FROM rentarea AS ra WHERE ra.buildingid = b.id AND value <= " + model.getAreaRentTo() + ")");
        }
        if (model.getName() != null && model.getName() != "") {
            sql.append(" AND b.name LIKE '%"+ model.getName() +"%'");
        }
        if (model.getFloorArea() != null) {
            sql.append(" AND b.floorarea = " + model.getFloorArea());
        }
        if (model.getDistrict() != null && model.getDistrict() != "") {
            sql.append(" AND b.district LIKE '%" + model.getDistrict() +"%'");
        }
        if (model.getWard() != null && model.getWard() != "") {
            sql.append(" AND b.ward LIKE '%"+ model.getWard() +"%'");
        }
        if (model.getStreet() != null && model.getStreet() != "") {
            sql.append(" AND b.street LIKE '%"+ model.getStreet() +"%'");
        }
        if (model.getNumberOfBasement() != null) {
            sql.append(" AND b.numberofbasement = " + model.getNumberOfBasement());
        }
        if (model.getDirection() != null && model.getDirection() != "") {
            sql.append(" AND b.direction LIKE '%" + model.getDirection() + "%'");
        }
        if (model.getLevel() != null && model.getLevel() != "") {
            sql.append(" AND b.level LIKE '% " + model.getLevel()+ "%'");
        }
        if (model.getCostRentFrom() != null || model.getCostRentTo() != null) {
            if (model.getCostRentFrom() != null) {
                sql.append(" AND b.rentprice >= " + model.getCostRentFrom());
            }
            if (model.getCostRentTo() != null){
                sql.append(" AND b.rentprice <= " + model.getCostRentTo() +"");
            }
        }
        if (model.getManagerName() != null && model.getManagerName() != "") {
            sql.append(" AND b.managername LIKE '%"+ model.getManagerName() +"%'");
        }
        if (model.getManagerPhone() != null && model.getManagerPhone() != "") {
            sql.append(" AND b.managerphone LIKE '%"+ model.getManagerPhone() +"%'");
        }
        if (model.getBuildingTypes() != null && model.getBuildingTypes().length > 0 ) {
            sql.append("and (b.types LIKE '%");
            for (int i = 0; i < model.getBuildingTypes().length;i++) {
                sql.append(model.getBuildingTypes()[i]);
                if (i != model.getBuildingTypes().length - 1) {
                    sql.append("%' or b.types LIKE '%");
                }
            }
            sql.append("%')");
        }
        sql.append(" GROUP BY b.id");
        sql.toString();
        String sql1="select * from building";
        Query query=entityManager.createNativeQuery(sql1,BuildingEntity.class);
        return query.getResultList();
    }

    @Override

    public void saveBuilding(BuildingEntity buildingEntity) {
        entityManager.persist(buildingEntity);
    }
}
