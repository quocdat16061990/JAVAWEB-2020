package com.laptrinhjavaweb.controller.admin;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.service.IBuildingService;
import com.laptrinhjavaweb.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "buildingControllerOfAdmin")
public class BuildingController {

    @Autowired
    private IBuildingService buildingService;

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/admin/building-list", method = RequestMethod.GET)
    public ModelAndView buildingListGet(@ModelAttribute("modelSearch") BuildingDTO buildingDTO) {
        ModelAndView mav = new ModelAndView("admin/building/list");
        mav.addObject("modelSearch", buildingDTO);
        mav.addObject("buildings", buildingService.findAll());
        mav.addObject("staffmaps", userService.getStaffMaps());
        mav.addObject("districtmaps", buildingService.getDistrictCode());
        mav.addObject("typemaps", buildingService.getType());

        return mav;
    }

    @RequestMapping(value = "/admin/building-list", method = RequestMethod.POST)
    public ModelAndView buildingListPost(@ModelAttribute("modelSearch") BuildingDTO buildingDTO){
        ModelAndView mav = new ModelAndView("admin/building/list");
        mav.addObject("staffmaps", userService.getStaffMaps());
        mav.addObject("districtmaps", buildingService.getDistrictCode());
        mav.addObject("typemaps", buildingService.getType());
        mav.addObject("buildings", buildingService.findBuildingList(buildingDTO));

        return mav;
    }

    @RequestMapping(value = "/admin/building-edit", method = RequestMethod.GET)
    public ModelAndView buildingAddGet(@ModelAttribute("modelEdit") BuildingDTO buildingDTO){
        ModelAndView mav = new ModelAndView("admin/building/edit");
        mav.addObject("districtmaps", buildingService.getDistrictCode());
        mav.addObject("typemaps", buildingService.getType());

        return mav;
    }
}
