package com.laptrinhjavaweb.repository.jdbc;

import com.laptrinhjavaweb.dto.BuildingDTO;

import java.util.List;

public interface IBuildingJDBC {
    List<BuildingDTO> search(BuildingDTO searchBuildingDTO);
    void addBuilding(BuildingDTO buildingDTO);

    List<BuildingDTO>  editBuilding(BuildingDTO buildingDTO);
}
