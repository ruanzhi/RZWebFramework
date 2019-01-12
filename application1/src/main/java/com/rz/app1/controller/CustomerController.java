package com.rz.app1.controller;

import com.rz.app1.Customer;
import com.rz.app1.service.CustomerService;
import com.rz.framework.annotation.Action;
import com.rz.framework.annotation.Controller;
import com.rz.framework.annotation.Inject;
import com.rz.framework.bean.View;

import java.util.List;

/**
 * Created by as on 2018/2/4.
 */
@Controller
public class CustomerController {

    @Inject
    private CustomerService customerService;

    @Action(value = "get:/customer")
    public View index() {
        List<Customer> customerList = customerService.getCustomerList();
        return new View("customer.jsp").addModel("customerList", customerList);
    }

}
