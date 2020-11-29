package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.converter.BuildingConverter;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.SearchBuildingDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.repository.BuildingRepository;
import com.laptrinhjavaweb.repository.jdbc.IBuildingJDBC;
import com.laptrinhjavaweb.repository.jdbc.impl.BuildingJDBC;
import com.laptrinhjavaweb.service.IBuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.laptrinhjavaweb.enums.districts;
import com.laptrinhjavaweb.enums.buildingTypes;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BuildingService implements IBuildingService {


    private IBuildingJDBC iBuildingJDBC=new BuildingJDBC();

    @Autowired
    private BuildingRepository buildingRepository;

    @Autowired
    private BuildingConverter buildingConverter;

//    @Override
//    public List<SearchBuildingDTO> search() {
//        List<SearchBuildingDTO> result = new ArrayList<>();
//        List<BuildingEntity> entities = buildingRepository.search();
//        for (BuildingEntity item: entities){
//            BuildingDTO buildingDTO = buildingConverter.convertToDto(item);
//            result.add(SearchBuildingDTO);
//        }
//        return result;
//    }

    @Override
    @Transactional
    public void save(BuildingDTO buildingDTO) {
        BuildingEntity buildingEntity = buildingConverter.convertToEntity(buildingDTO);
        buildingRepository.save(buildingEntity);
    }

    @Override
    public Map<String, String> getDistricts() {
        Map<String,String> results =new HashMap<>();
        for(districts item : districts.values()){
            results.put(item.name(),item.getValueDistrictCode());
        }
        return results;
    }

    @Override
    public Map<String, String> getBuildingTypes() {
        Map<String, String> results = new HashMap<>();
        for (buildingTypes item : buildingTypes.values()) {
            results.put(item.name(), item.getBuildingType());
        }
        return results;
    }

    @Override
    public List<BuildingDTO> searchBuilding(SearchBuildingDTO searchBuildingDTO) {
         List<BuildingDTO> result=iBuildingJDBC.search(searchBuildingDTO);
        return result;
    }
    @Override
    public List<BuildingDTO> editBuilding(BuildingDTO buildingDTO){
        List<BuildingDTO> result=iBuildingJDBC.editBuilding(buildingDTO);
        return result;
    }

    @Override
    public List<BuildingEntity> search(SearchBuildingDTO search) {
        List<BuildingEntity> result=buildingRepository.findAll();
        return result;
    }

//    @Override
//    public List<BuildingEntity> search(SearchBuildingDTO search) {
//        List<BuildingEntity> result=buildingRepository.
//    }

    @Override
    @Transactional
    public void   addBuilding(BuildingDTO buildingDTO) {
         iBuildingJDBC.addBuilding(buildingDTO);

    }

}
