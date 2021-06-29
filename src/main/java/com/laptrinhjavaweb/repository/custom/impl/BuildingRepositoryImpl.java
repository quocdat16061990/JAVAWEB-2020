package com.laptrinhjavaweb.repository.custom.impl;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.repository.custom.IBuildingRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BuildingRepositoryImpl implements IBuildingRepositoryCustom {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<BuildingEntity> findAll(BuildingDTO model) {
        String sql = "select * from building";
        Query query = entityManager.createNativeQuery(sql, BuildingEntity.class);

        return query.getResultList();
    }

    @Override
    public List<BuildingEntity> findBuildingList(BuildingDTO model) {
        String sql = buildBuildingSearch(model);
        Query query = entityManager.createNativeQuery(sql, BuildingEntity.class);

        return query.getResultList();
    }

    @Override
    @Transactional
    public BuildingDTO saveBuilding(BuildingEntity buildingEntity) {
        entityManager.persist(buildingEntity);
        return null;
    }

    private String buildBuildingSearch(BuildingDTO model) {
        StringBuilder sql = new StringBuilder("select * from building b");

        if (model.getStaffId() != -1) {
            sql.append(" left join assignmentbuilding ab on b.id = ab.buildingid where 1 = 1" +
                    " and ab.staffid = " + model.getStaffId());
        }else{
            sql.append(" where 1 = 1");
        }
        if (model.getRentAreaFrom() != null || model.getRentAreaTo() != null) {
            sql.append(buildQueryRentArea(model));
        }
        if (model.getRentCostFrom() != null || model.getRentCostTo() != null) {
            sql.append(buildQueryRentCost(model));
        }
        if (model.getBuildingTypes().length > 0) {
            sql.append(buildQueryType(model));
        }
        try {
            Field[] fields = BuildingDTO.class.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                if (!field.getName().equals("staffId") && !field.getName().equals("buildingTypes")
                        && !field.getName().startsWith("rentArea") && !field.getName().startsWith("rentCost")) {
                    if (field.get(model) == ""){
                        field.set(model, null);
                    }
                    if (field.get(model) != null) {
                        if (field.getType().getName().equals("java.lang.String")) {
                            sql.append(" and b." + field.getName().toLowerCase() + " like '%" + field.get(model) + "%'");
                        } else if (field.getType().getName().equals("java.lang.Integer")) {
                            sql.append(" and b." + field.getName().toLowerCase() + " = " + field.get(model));
                        }
                    }
                }
            }
            sql.append(" group by b.id");
            return sql.toString();
        } catch (Exception e) {
            return null;
        }
    }

    private String buildQueryRentArea(BuildingDTO model) {
        StringBuilder sql = new StringBuilder(" and exists (select * from rentarea as ra where ra.buildingid = b.id)");
        if (model.getRentCostFrom() != null) {
            sql.append(" and ra.value >= " + model.getRentCostFrom());
        }
        if (model.getRentAreaTo() != null) {
            sql.append(" and ra.value <= " + model.getRentAreaTo());
        }
        sql.append(")");

        return sql.toString();
    }

    private String buildQueryRentCost(BuildingDTO model) {
        StringBuilder sql = new StringBuilder();
        if (model.getRentCostFrom() != null) {
            sql.append(" and b.rentcost >= " + model.getRentCostFrom());
        }
        if (model.getRentAreaTo() != null) {
            sql.append(" and b.rentcost <= " + model.getRentAreaTo());
        }

        return sql.toString();
    }

    private String buildQueryType(BuildingDTO model) {
        StringBuilder sql = new StringBuilder(" and (");
        String sqlType = Arrays.stream(model.getBuildingTypes())
                .map(item -> " b.type like '%" + item + "%'")
                .collect(Collectors.joining(" OR "));
        sql.append(sqlType);
        sql.append(")");

        return sql.toString();
    }
}
