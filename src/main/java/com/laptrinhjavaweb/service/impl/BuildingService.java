package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.converter.BuildingConverter;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.request.AssignmentBuildingRequestDTO;
import com.laptrinhjavaweb.dto.response.StaffResponseDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.entity.RentAreaEntity;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.enums.DistrictEnum;
import com.laptrinhjavaweb.enums.Type;
import com.laptrinhjavaweb.repository.BuildingRepository;
import com.laptrinhjavaweb.repository.UserRepository;
import com.laptrinhjavaweb.service.IBuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class BuildingService implements IBuildingService {

    @Autowired
    private BuildingRepository buildingRepository;

    @Autowired
    private BuildingConverter buildingConverter;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Map<String, String> getDistrictCode() {
        Map<String, String> resutl = new LinkedHashMap<>();
        for (DistrictEnum item : DistrictEnum.values()) {
            resutl.put(item.name(), item.getValue());
        }

        return resutl;
    }

    @Override
    public Map<String, String> getType() {
        Map<String, String> resutl = new LinkedHashMap<>();
        for (Type item : Type.values()) {
            resutl.put(item.name(), item.getValue());
        }

        return resutl;
    }

    @Override
    public List<BuildingDTO> findAll() {
        try {
            List<BuildingDTO> results = new ArrayList<>();
            List<BuildingEntity> entities = buildingRepository.findAll();
            for (BuildingEntity item : entities) {
                BuildingDTO buildingDTO = buildingConverter.convertToDto(item);
                results.add(buildingDTO);
            }
            return results;
        } catch (Exception e){
            throw e;
        }

    }

    @Override
    @Transactional
    public BuildingDTO save(BuildingDTO buildingDTO) {
        try {
            BuildingEntity buildingEntity = buildingConverter.convertToEntity(buildingDTO);
            buildingEntity.setRentAreas(areaEntityList(buildingDTO));
            buildingEntity.setType(stringType(buildingDTO));
            return buildingConverter.convertToDto(buildingRepository.save(buildingEntity));
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    @Transactional
    public BuildingDTO update(BuildingDTO updateBuilding) {
        try {
            BuildingEntity entityOld = buildingRepository.getOne(updateBuilding.getId());
            BuildingEntity entityNew = buildingConverter.convertToEntity(updateBuilding);
            entityNew.setId(updateBuilding.getId());
            entityNew.setCreatedDate(entityOld.getCreatedDate());
            entityNew.setCreatedBy(entityOld.getCreatedBy());
            entityNew.setRentAreas(areaEntityList(updateBuilding));
            entityNew.setType(stringType(updateBuilding));
            buildingRepository.save(entityNew);
            return updateBuilding;
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public BuildingDTO findBuildingID(Long id) {
        BuildingEntity buildingEntity = buildingRepository.findOne(id);
        BuildingDTO buildingDTO = buildingConverter.convertToDto(buildingEntity);
        return buildingDTO;
    }

    @Override
    public List<StaffResponseDTO> loadStaff(Long id) {
        try {
            List<UserEntity> userEntities = userRepository.findAll();
            BuildingEntity buildingEntity = new BuildingEntity();
            if (buildingRepository.exists(id)) {
                buildingEntity = buildingRepository.findOne(id);
            }
            List<StaffResponseDTO> staffResponseDTOS = new ArrayList<>();
            for (UserEntity item1 : userEntities) {
                StaffResponseDTO staffResponseDTO = new StaffResponseDTO();
                staffResponseDTO.setStaffId(item1.getId());
                staffResponseDTO.setFullName(item1.getFullName());
                staffResponseDTO.setChecked("");
                for (UserEntity item2 : buildingEntity.getStaffs()) {
                    if (item1.getId() == item2.getId()) {
                        staffResponseDTO.setChecked("checked");
                    }
                }
                staffResponseDTOS.add(staffResponseDTO);
            }
            return staffResponseDTOS;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public BuildingDTO assignmentBuilding(AssignmentBuildingRequestDTO requestDTO) {
        try {
            BuildingEntity buildingEntity = buildingRepository.findOne(requestDTO.getBuildingId());
            List<UserEntity> userEntities = new ArrayList<>();
            for (Long id : requestDTO.getStaffs()) {
                UserEntity userEntity = userRepository.findOne(id);
                userEntities.add(userEntity);
            }
            buildingEntity.getStaffs().clear();
            buildingEntity.setStaffs(userEntities);
            BuildingDTO buildingDTO = buildingConverter.convertToDto(buildingRepository.save(buildingEntity));
            return buildingDTO;
        } catch (Exception e) {
            throw e;
        }

    }

    @Override
    public List<BuildingDTO> findBuildingList(BuildingDTO model) {
        List<BuildingDTO> results = new ArrayList<>();
        List<BuildingEntity> entities = buildingRepository.findBuildingList(model);
        for (BuildingEntity item : entities) {
            BuildingDTO buildingDTO = buildingConverter.convertToDto(item);
            results.add(buildingDTO);
        }
        return results;
    }

    @Override
    @Transactional
    public void delete(Long[] ids) {
        try {
            for (Long item : ids) {
                BuildingEntity buildingEntity = buildingRepository.findOne(item);
                buildingEntity.getRentAreas().removeAll(buildingEntity.getRentAreas());
                buildingRepository.delete(item);
            }
        } catch (Exception e) {
            throw e;
        }

    }

    private List<RentAreaEntity> areaEntityList(BuildingDTO buildingDTO) {
        if (!buildingDTO.getRentArea().isEmpty()) {
            List<RentAreaEntity> areaEntityList = new ArrayList<>();
            for (String item : buildingDTO.getRentArea().split(",")) {
                RentAreaEntity rentAreaEntity = new RentAreaEntity();
                rentAreaEntity.setValue(Integer.parseInt(item));
                areaEntityList.add(rentAreaEntity);
            }
            return areaEntityList;
        } else {
            return null;
        }
    }

    private String stringType(BuildingDTO buildingDTO) {
        String type = Arrays.stream(buildingDTO.getBuildingTypes()).collect(Collectors.joining(","));
        return type;
    }
}
