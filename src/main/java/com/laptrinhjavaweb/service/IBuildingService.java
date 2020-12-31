package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.BuildingDTO;

import java.util.List;
import java.util.Map;

public interface IBuildingService {
        List<BuildingDTO> findAll(BuildingDTO model);
        void save(BuildingDTO buildingDTO);
        void saveJPA(BuildingDTO buildingDTO);
        Map<String, String> getDistricts();
        void addBuildingSpringDataJPA(BuildingDTO buildingDTO);
        Map<String, String> getBuildingTypes();

        List<BuildingDTO> findBuildingJPA(BuildingDTO model);
        void saveByPersist(BuildingDTO buildingDTO);
}

