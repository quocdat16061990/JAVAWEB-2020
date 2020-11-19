package com.laptrinhjavaweb.repository.jdbc;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.SearchBuildingDTO;

import java.util.List;

public interface IBuildingJDBC {
    List<BuildingDTO> search(SearchBuildingDTO searchBuildingDTO);
    void addBuilding(BuildingDTO buildingDTO);

    List<BuildingDTO>  editBuilding(BuildingDTO buildingDTO);
}
