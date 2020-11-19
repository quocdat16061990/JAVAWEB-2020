package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.SearchBuildingDTO;

import java.util.List;
import java.util.Map;

public interface IBuildingService {
    List<BuildingDTO> findAll();
    void save(BuildingDTO buildingDTO);
    Map<String, String> getDistricts();
    Map<String, String> getBuildingTypes();
    List<BuildingDTO> searchBuilding(SearchBuildingDTO searchBuildingDTO);
    void addBuilding(BuildingDTO buildingDTO);
    List<BuildingDTO>  editBuilding(BuildingDTO buildingDTO);
}
