package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.model.BuildingModel;

public interface IBuildingService {
	List<BuildingModel> findByCondition();

	
}
