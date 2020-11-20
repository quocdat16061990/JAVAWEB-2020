package com.laptrinhjavaweb.controller.admin;


import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.dto.SearchBuildingDTO;
import com.laptrinhjavaweb.service.IUserService;
import com.laptrinhjavaweb.service.impl.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "customerControllerofAdmin")
public class CustomerController {

    @Autowired
    private BuildingService buildingService;
    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/admin/customer-list", method = RequestMethod.GET)
    public ModelAndView buildingList(@ModelAttribute("modelSearch") CustomerDTO customerDTO) {
        ModelAndView mav = new ModelAndView("admin/customer/list");
        mav.addObject("modelSearch", customerDTO);
//        mav.addObject("addCustomer"),userService.addCustomer(customerDTO);
        mav.addObject("searchCustomer", userService.searchCustomer(customerDTO));
        mav.addObject("addCustomer",userService.addCustomer(customerDTO));


        return mav;
    }
}



