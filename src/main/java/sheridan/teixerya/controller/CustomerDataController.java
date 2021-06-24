package sheridan.teixerya.controller;


import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import sheridan.teixerya.model.CustomerForm;
import sheridan.teixerya.service.CustomerDataService;


import java.util.List;


@Controller
public class CustomerDataController {

    private final Logger logger = LoggerFactory.getLogger(CustomerDataController.class);



    private final CustomerDataService customerDataService;

    public CustomerDataController(CustomerDataService customerDataService){
        this.customerDataService = customerDataService;
    }

    @GetMapping(value={"/", "/CustomerList"})
    public ModelAndView customerList() {
        logger.trace("customerList() is called");
        List<CustomerForm> list = customerDataService.getAllCustomerForms();
        return new ModelAndView("CustomerList",
                "customers", list);
    }


    @GetMapping("CustomerDetails/{customer_id}")
    public String customerDetails(@PathVariable String customer_id, Model model){
        logger.trace("customerDetails() is called");
        try {
            CustomerForm form = customerDataService.getCustomerForm(Integer.parseInt(customer_id));
            if (form != null) {
                model.addAttribute("customer", form);
                return "CustomerDetails"; // show the customer data in the form to edit
            } else {
                logger.trace("no data for this id=" + customer_id);
                return "DataNotFound";
            }
        } catch (NumberFormatException e) {
            logger.trace("the id is missing or not an integer");
            return "DataNotFound";
        }
    }


}


