package com.laptrinhjavaweb.dao;

import java.util.List;

import com.laptrinhjavaweb.model.BuildingModel;

public interface IBuildingDAO {
	List<BuildingModel> findByCondition();
}
