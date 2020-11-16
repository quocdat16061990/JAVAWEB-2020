package com.laptrinhjavaweb.controller.admin;

import com.laptrinhjavaweb.dto.SearchBuildingDTO;
import com.laptrinhjavaweb.repository.JDBC.DAO.IBuildingDAO;

import com.laptrinhjavaweb.service.ICustomerService;
import com.laptrinhjavaweb.service.IUserService;

import com.laptrinhjavaweb.service.IBuildingService;
import com.laptrinhjavaweb.service.impl.UserService;
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
    @Autowired
    private ICustomerService customerService;

    @RequestMapping(value = "/admin/building-list", method = RequestMethod.GET)
    public ModelAndView buildingList(@ModelAttribute("modelSearch") SearchBuildingDTO searchBuildingDTO) {
        ModelAndView mav = new ModelAndView("admin/building/list");
        mav.addObject("buildingSearch",buildingService.findByConditon());
        mav.addObject("addBuilding",buildingService.addBuilding());
        mav.addObject("modelSearch", searchBuildingDTO);
        mav.addObject("addCustomer",customerService.addCustomer());
        mav.addObject("findCustomer",customerService.findCustomer());
        return mav;
    }

    @RequestMapping(value = "/admin/building-edit", method = RequestMethod.GET)
    public ModelAndView buildingEdit() {
        ModelAndView mav = new ModelAndView("admin/building/edit");
        return mav;
    }
}
