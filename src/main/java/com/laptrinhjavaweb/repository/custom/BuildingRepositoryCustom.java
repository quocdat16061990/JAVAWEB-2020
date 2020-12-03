package com.laptrinhjavaweb.repository.custom;

import com.laptrinhjavaweb.dto.SearchBuildingDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;

import java.util.List;

public interface BuildingRepositoryCustom {
    List<BuildingEntity> search(SearchBuildingDTO search);;

}
