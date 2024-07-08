package team.MediaSoft.CRUDForCustomersDemo.service.implementation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import team.MediaSoft.CRUDForCustomersDemo.model.Customer;
import team.MediaSoft.CRUDForCustomersDemo.repository.InMemoryCustomerDAO;
import team.MediaSoft.CRUDForCustomersDemo.service.CustomerService;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class InMemoryCustomerServiceImpl implements CustomerService {
    //todo
    private final InMemoryCustomerDAO repository;

    @Override
    public List<Customer> getAllCustomers() {
        return repository.getAllCustomers();
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return repository.saveCustomer(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return repository.updateCustomer(customer);
    }

    @Override
    public Customer getCustomerById(UUID id) {return repository.getCustomerById(id);}

    @Override
    public void deleteCustomerById(UUID id) {repository.deleteCustomerById(id);}
}
