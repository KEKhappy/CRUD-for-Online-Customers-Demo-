package team.MediaSoft.CRUDForCustomersDemo.service;

import team.MediaSoft.CRUDForCustomersDemo.model.Customer;
import java.util.List;
import java.util.UUID;

public interface CustomerService {
    List<Customer> getAllCustomers();
    Customer saveCustomer(Customer customer);
    Customer updateCustomer(Customer customer);
    Customer getCustomerById(UUID id);
    void deleteCustomerById(UUID id);

}
