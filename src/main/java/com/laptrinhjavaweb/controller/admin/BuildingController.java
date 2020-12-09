package com.laptrinhjavaweb.controller.admin;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.service.IUserService;
import com.laptrinhjavaweb.service.impl.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "buildingControllerOfAdmin")
public class BuildingController {

    @Autowired
    private BuildingService buildingService;
    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/admin/building-list", method = RequestMethod.GET)
    public ModelAndView buildingList(@ModelAttribute("modelSearch") BuildingDTO buildingDTO) {
        ModelAndView mav = new ModelAndView("admin/building/list");
        mav.addObject("modelSearch", buildingDTO);

       mav.addObject("districts",buildingService.getDistricts());
//       mav.addObject("buildingSearch",buildingService.searchBuilding(searchBuildingDTO));
       mav.addObject("buildingTypes",buildingService.getBuildingTypes());
        mav.addObject("buildingSearch",buildingService.searchBuilding(buildingDTO));



        return mav;
    }

    @RequestMapping(value = "/admin/building-edit", method = RequestMethod.GET)
    public ModelAndView buildingEdit(@ModelAttribute("addBuilding")BuildingDTO buildingDTO) {
        ModelAndView mav = new ModelAndView("admin/building/edit");

        mav.addObject("district",buildingService.getDistricts());
        mav.addObject("buildingTypes",buildingService.getBuildingTypes());

        return mav;
    }
    @RequestMapping(value = "/admin/building-update", method = RequestMethod.GET)
    public ModelAndView buildingUpdate(@ModelAttribute("updateBuilding")BuildingDTO buildingDTO) {
        ModelAndView mav = new ModelAndView("admin/building/update");
        mav.addObject("updateBuilding",buildingDTO);
        mav.addObject("district",buildingService.getDistricts());
        mav.addObject("buildingTypes",buildingService.getBuildingTypes());
        mav.addObject("editBuilding",buildingService.editBuilding(buildingDTO));
        return mav;
    }
}
