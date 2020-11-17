package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.converter.BuildingConverter;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.SearchBuildingDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.repository.BuildingRepository;
import com.laptrinhjavaweb.repository.JDBC.DAO.IBuildingDAO;
import com.laptrinhjavaweb.repository.JDBC.DAO.impl.BuildingDAO;
import com.laptrinhjavaweb.service.IBuildingService;
import com.laptrinhjavaweb.repository.JDBCModel.BuildingModel;
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



    @Autowired
    private BuildingRepository buildingRepository;

    @Autowired
    private BuildingConverter buildingConverter;

    private IBuildingDAO buildingDAO;
    public BuildingService(){
        buildingDAO=new BuildingDAO();
    }
    @Override
    public List<BuildingDTO> findAll() {
        List<BuildingDTO> result = new ArrayList<>();
        List<BuildingEntity> entities = buildingRepository.findAll();
        for (BuildingEntity item: entities){
            BuildingDTO buildingDTO = buildingConverter.convertToDto(item);
            result.add(buildingDTO);
        }
        return result;
    }

    @Override
    public List<BuildingDTO> findByConditon(SearchBuildingDTO searchBuildingDTO) {
        return buildingDAO.findByCondition(searchBuildingDTO);
    }
    @Override
    public List<BuildingModel> addBuilding(){
        return buildingDAO.addBuilding();
    }
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
}
