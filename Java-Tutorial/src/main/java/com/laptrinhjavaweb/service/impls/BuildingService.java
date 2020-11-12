package com.laptrinhjavaweb.service.impls;

import java.util.List;

import javax.inject.Inject;

import com.laptrinhjavaweb.dao.IBuildingDAO;
import com.laptrinhjavaweb.dao.impl.BuildingDao;
import com.laptrinhjavaweb.model.BuildingModel;
import com.laptrinhjavaweb.service.IBuildingService;

public class BuildingService implements IBuildingService {

	
	@Inject
	private IBuildingDAO buildingDao;
	@Override
	public List<BuildingModel> findByCondition(){
		return buildingDao.findByCondition();
	}
}
