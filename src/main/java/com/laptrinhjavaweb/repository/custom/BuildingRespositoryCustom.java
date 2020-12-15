package com.laptrinhjavaweb.repository.custom;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;

import java.util.List;

public interface BuildingRespositoryCustom {
    List<BuildingEntity> findAll(BuildingDTO model);
    List<BuildingEntity> findBuildingJPA(BuildingDTO model);
    void saveBuilding(BuildingDTO buildingDTO);

}
