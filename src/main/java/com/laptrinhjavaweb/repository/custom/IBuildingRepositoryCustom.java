package com.laptrinhjavaweb.repository.custom;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;

import java.util.List;

public interface IBuildingRepositoryCustom {
    List<BuildingEntity> findAll(BuildingDTO model);
    List<BuildingEntity> findBuildingList(BuildingDTO model);
    BuildingDTO saveBuilding(BuildingEntity buildingEntity);
}
