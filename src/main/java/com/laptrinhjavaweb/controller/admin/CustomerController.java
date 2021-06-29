package com.laptrinhjavaweb.controller.admin;

import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.service.ICustomerService;
import com.laptrinhjavaweb.service.ITransactionService;
import com.laptrinhjavaweb.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "customerControllerOfAdmin")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IUserService userService;

    @Autowired
    private ITransactionService transactionService;

    @RequestMapping(value = "/admin/customer-list", method = RequestMethod.GET)
    public ModelAndView customerList(@ModelAttribute("customerSearch") CustomerDTO customerDTO) {
        ModelAndView mav = new ModelAndView("admin/customer/list");
        mav.addObject("staffmaps", userService.getStaffMaps());
        mav.addObject("customerList", customerService.findAll());

        return mav;
    }

    @RequestMapping(value = "/admin/customer-list", method = RequestMethod.POST)
    public ModelAndView customerGetList(@ModelAttribute("customerSearch") CustomerDTO customerDTO) {
        ModelAndView mav = new ModelAndView("admin/customer/list");
        mav.addObject("staffmaps", userService.getStaffMaps());
        mav.addObject("customerList", customerService.findCustomers(customerDTO));

        return mav;
    }

    @RequestMapping(value = "/admin/customer-edit", method = RequestMethod.GET)
    public ModelAndView customerAddGetList(@ModelAttribute("customerEdit") CustomerDTO customerDTO) {
        ModelAndView mav = new ModelAndView("admin/customer/edit");
        mav.addObject("customerEdit", customerDTO);
        mav.addObject("transactions", transactionService.findAllByCustomerId(customerDTO.getId()));

        return mav;
    }
}
