package sheridan.teixerya.service;



import sheridan.teixerya.model.CustomerForm;

import java.util.List;

public interface CustomerDataService {


    List<CustomerForm> getAllCustomerForms();

    CustomerForm getCustomerForm(int customer_id);


}
