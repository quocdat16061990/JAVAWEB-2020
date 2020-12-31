package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.converter.BuildingConverter;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.entity.RentAreaEntity;
import com.laptrinhjavaweb.repository.BuildingRepository;
import com.laptrinhjavaweb.repository.RentAreaRespository;
import com.laptrinhjavaweb.repository.custom.BuildingRespositoryCustom;
import com.laptrinhjavaweb.repository.jdbc.IBuildingJDBC;

import com.laptrinhjavaweb.service.IBuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.laptrinhjavaweb.enums.districts;
import com.laptrinhjavaweb.enums.buildingTypes;


import java.util.*;

@Service
public class BuildingService implements IBuildingService {


//    private IBuildingJDBC iBuildingJDBC=new BuildingJDBC();

    @Autowired
    private BuildingRepository buildingRepository;

    @Autowired
    private BuildingConverter buildingConverter;

    @Autowired
    private BuildingRespositoryCustom buildingRespositoryCustom;

    @Autowired
    private RentAreaRespository rentAreaRespository;

    @Override
    public List<BuildingDTO> findAll(BuildingDTO model) {
        List<BuildingDTO> result = new ArrayList<>();

        List<BuildingEntity> entities = buildingRepository.findAll();
        for (BuildingEntity item : entities) {
//            BuildingDTO buildingDTO = buildingConverter.convertToDto(item);
            BuildingDTO buildingDTO = buildingConverter.convertToDto(item);
            result.add(buildingDTO);
        }
        return result;
    }

    @Override
    @Transactional
    public void save(BuildingDTO buildingDTO) {
        BuildingEntity buildingEntity = buildingConverter.convertToEntity(buildingDTO);
        buildingRepository.save(buildingEntity);
    }

    @Override
    @Transactional
    public void saveJPA(BuildingDTO buildingDTO) {
        BuildingEntity buildingEntity = buildingConverter.convertToEntity(buildingDTO);
        buildingRepository.save(buildingEntity);
        List<String> rentArea = new ArrayList(Arrays.asList(buildingDTO.getRentAreaFrom()));

        for (String i : rentArea) {
            RentAreaEntity rentAreaEntity = new RentAreaEntity();
            rentAreaEntity.setBuilding(buildingEntity);
            rentAreaEntity.setValue(Integer.parseInt(i));
            rentAreaRespository.save(rentAreaEntity);
        }
    }


    @Override
    public Map<String, String> getDistricts() {
        Map<String, String> results = new HashMap<>();
        for (districts item : districts.values()) {
            results.put(item.name(), item.getValueDistrictCode());
        }
        return results;
    }

    @Override
    public void addBuildingSpringDataJPA(BuildingDTO buildingDTO) {
        BuildingEntity buildingEntity=buildingConverter.convertToEntity(buildingDTO);
        buildingRepository.save(buildingEntity);
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
    public List<BuildingDTO> findBuildingJPA(BuildingDTO model) {
        List<BuildingDTO> results = new ArrayList<>();
        List<BuildingEntity> entities = buildingRespositoryCustom.findBuildingJPA(model);
        for (BuildingEntity item : entities) {
            BuildingDTO buildingDTO = buildingConverter.convertToDto(item);
            results.add(buildingDTO);
        }
        return results;
    }

    @Override
    public void saveByPersist(BuildingDTO buildingDTO) {
        buildingRespositoryCustom.saveBuilding(buildingDTO);}
    }


