package com.laptrinhjavaweb.repository.JDBC.DAO;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.SearchBuildingDTO;
import com.laptrinhjavaweb.repository.JDBCModel.BuildingModel;

import java.util.List;

public interface IBuildingDAO {
    List<BuildingDTO> findByCondition(SearchBuildingDTO searchBuildingDTO);
    List<BuildingModel> addBuilding();
}
