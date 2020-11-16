package com.laptrinhjavaweb.repository.JDBC.DAO;

import com.laptrinhjavaweb.repository.JDBCModel.BuildingModel;

import java.util.List;

public interface IBuildingDAO {
    List<BuildingModel> findByCondition();
    List<BuildingModel> addBuilding();
}
