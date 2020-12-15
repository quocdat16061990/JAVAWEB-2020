package com.laptrinhjavaweb.repository.custom.impl;

import com.laptrinhjavaweb.converter.BuildingConverter;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.entity.RentAreaEntity;
import com.laptrinhjavaweb.repository.custom.BuildingRespositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class BuildingRespositoryImpl implements BuildingRespositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private BuildingConverter buildingConverter;
    @Override
    public List<BuildingEntity> findAll(BuildingDTO model) {
        StringBuffer sql= new StringBuffer("select * from building");
//

        Query query=entityManager.createNativeQuery(String.valueOf(sql),BuildingEntity.class);
        return query.getResultList();
    }

    @Override
    public List<BuildingEntity> findBuildingJPA(BuildingDTO model) {

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT b.* FROM building as b");
        if (model.getStaffId() != null) {
            sql.append(" left join assignmentbuilding ab on ab.buildingid = b.id");
        }
        sql.append(" WHERE 1 = 1");
        if (model.getRentAreaFrom() != null || model.getRentAreaTo() != null) {
            if (model.getRentAreaFrom() != null && model.getRentAreaTo() != null) {
                sql.append(" AND EXISTS (SELECT * FROM rentarea AS ra WHERE ra.buildingid = b.id AND value BETWEEN " + model.getRentAreaFrom() + " AND " + model.getRentAreaTo());
            } else {
                sql.append(" AND EXISTS (SELECT * FROM rentarea AS ra WHERE ra.buildingid = b.id AND value >=  " + model.getRentAreaFrom());
            }
            sql.append(")");
        } else if (model.getRentAreaTo() != null) {
            sql.append(" AND EXISTS (SELECT * FROM rentarea AS ra WHERE ra.buildingid = b.id AND value <= " + model.getRentAreaTo() + ")");
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

        if (model.getRentCostFrom() != null && model.getRentCostTo() != null) {
            sql.append(" and b.rentcost >= " + model.getRentCostFrom() + "  and b.rentcost <= "
                    + model.getRentCostTo()) ;
        } else if (model.getRentCostFrom() != null) {
            sql.append(" and b.rentcost >= " + model.getRentCostFrom()) ;
        } else if (model.getRentCostTo() != null) {
            sql.append(" and b.rentcost <= " + model.getRentCostTo()) ;
        }

        if (model.getManagerName() != null && model.getManagerName() != "") {
            sql.append(" AND b.managername LIKE '%"+ model.getManagerName() +"%'");
        }
        if (model.getManagerPhone() != null && model.getManagerPhone() != "") {
            sql.append(" AND b.managerphone LIKE '%"+ model.getManagerPhone() +"%'");
        }
        if (model.getType() != null && model.getType().length > 0 ) {
            sql.append("and (b.type LIKE '%");
            for (int i = 0; i < model.getType().length;i++) {
                sql.append(model.getType()[i]);
                if (i != model.getType().length - 1) {
                    sql.append("%' or b.type LIKE '%");
                }
            }
            sql.append("%')");
        }
        sql.append(" GROUP BY b.id");
        sql.toString();

        Query query=entityManager.createNativeQuery(sql.toString(),BuildingEntity.class);
        return query.getResultList();

    }

    @Override
    @Transactional
    public void saveBuilding(BuildingDTO buildingDTO) {
        BuildingEntity buildingEntity = buildingConverter.convertToEntity(buildingDTO);

        entityManager.persist(buildingEntity);
        List<String> rentArea=new ArrayList(Arrays.asList(buildingDTO.getRentAreaFrom()));
        for(String i :rentArea){
            RentAreaEntity rentAreaEntity=new RentAreaEntity();
            rentAreaEntity.setBuilding(buildingEntity);
            rentAreaEntity.setValue(Integer.parseInt(i));
            entityManager.persist(rentAreaEntity);
        }

    }


}
