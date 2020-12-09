package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.BuildingDTO;

import java.util.List;
import java.util.Map;

public interface IBuildingService {
    List<BuildingDTO> findAll(BuildingDTO model);
    void save(BuildingDTO buildingDTO);

    Map<String, String> getDistricts();
    Map<String, String> getBuildingTypes();
    List<BuildingDTO> searchBuilding(BuildingDTO searchBuildingDTO);
    void addBuilding(BuildingDTO buildingDTO);
    List<BuildingDTO>  editBuilding(BuildingDTO buildingDTO);
}
