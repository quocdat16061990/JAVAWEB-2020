package com.laptrinhjavaweb.repository.custom.impl;

import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.repository.custom.IUserRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class UserRepositoryImpl implements IUserRepositoryCustom {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<UserEntity> loadStaffWithBuildingID(Long id) {
        String sql = "SELECT * FROM users AS u " +
                "WHERE 1 = 1 " +
                "AND u.id IN (select staffid from assignmentbuilding as ab where ab.buildingid = " + id + ")";
        Query query = entityManager.createNativeQuery(sql, UserEntity.class);
        return query.getResultList();
    }
}
