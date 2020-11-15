package com.laptrinhjavaweb.repository.JDBC.DAO;

import com.laptrinhjavaweb.repository.JDBC.BuildingModel.BuildingModel;

import java.util.List;

public interface IBuildingDAO {
    List<BuildingModel> findByCondition();
}
