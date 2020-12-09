package com.laptrinhjavaweb.repository.custom;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;

import java.util.List;

public interface BuildingRespositoryCustom {
    List<BuildingEntity> fidnAll(BuildingDTO model);

    void saveBuilding(BuildingEntity buildingEntity);
}
