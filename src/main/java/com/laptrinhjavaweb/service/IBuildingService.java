package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.repository.JDBCModel.BuildingModel;

import java.util.List;
import java.util.Map;

public interface IBuildingService {
    List<BuildingDTO> findAll();
    List<BuildingModel> findByConditon();
    List<BuildingModel> addBuilding();
    void save(BuildingDTO buildingDTO);
    Map<String, String> getDistricts();
    Map<String, String> getBuildingTypes();
}
