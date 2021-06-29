package com.laptrinhjavaweb.api.admin;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.request.AssignmentBuildingRequestDTO;
import com.laptrinhjavaweb.dto.response.ResponseDTO;
import com.laptrinhjavaweb.service.impl.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController(value = "buildingAPIOfAdmin")
@RequestMapping("/api/building")
public class BuildingAPI {

    @Autowired
    private BuildingService buildingService;

    @GetMapping("/{id}")
    public ResponseDTO findBuildingID(@PathVariable("id") Long id ){
        ResponseDTO result = new ResponseDTO();
        result.setData(buildingService.findBuildingID(id));
        result.setMesager("Success");
        return result;
    }

    @GetMapping("/{id}/staffs")
    public ResponseDTO loadStaffWithBuildingID(@PathVariable("id") Long id) {
        ResponseDTO result = new ResponseDTO();
        result.setData(buildingService.loadStaff(id));
        result.setMesager("Success");
        return result;
    }

    @PostMapping
    public ResponseDTO creataBuilding(@RequestBody BuildingDTO newBuilding) {
        ResponseDTO result = new ResponseDTO();
        result.setData(buildingService.save(newBuilding));
        result.setMesager("Success");
        return result;
    }

    @PutMapping
    public ResponseDTO update(@RequestBody BuildingDTO updateBuilding) {
        ResponseDTO result = new ResponseDTO();
        result.setData(buildingService.update(updateBuilding));
        result.setMesager("Success");
        return result;
    }

    @PutMapping("/assignment")
    public ResponseDTO assignmentBuilding(@RequestBody AssignmentBuildingRequestDTO requestDTO){
        ResponseDTO result = new ResponseDTO();
        result.setData(buildingService.assignmentBuilding(requestDTO));
        result.setMesager("Success");
        return result;
    }

    @DeleteMapping
    public ResponseDTO deleteBuilding(@RequestBody Long[] ids) {
        ResponseDTO result = new ResponseDTO();
        buildingService.delete(ids);
        result.setMesager("Success");
        return result;
    }
}
