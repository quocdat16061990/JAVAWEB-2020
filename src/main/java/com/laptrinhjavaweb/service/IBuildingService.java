package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.request.AssignmentBuildingRequestDTO;
import com.laptrinhjavaweb.dto.response.StaffResponseDTO;

import java.util.List;
import java.util.Map;

public interface IBuildingService {
    Map<String, String> getDistrictCode();
    Map<String, String> getType();
    List<BuildingDTO> findAll();
    BuildingDTO save(BuildingDTO buildingDTO);
    BuildingDTO update(BuildingDTO updateBuilding);
    List<BuildingDTO> findBuildingList(BuildingDTO model);
    void delete(Long[] ids);
    BuildingDTO findBuildingID(Long id);
    List<StaffResponseDTO> loadStaff(Long id);
    BuildingDTO assignmentBuilding(AssignmentBuildingRequestDTO requestDTO);
}
