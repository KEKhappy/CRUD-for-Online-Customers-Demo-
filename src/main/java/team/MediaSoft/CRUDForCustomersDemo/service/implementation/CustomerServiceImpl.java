package team.MediaSoft.CRUDForCustomersDemo.service.implementation;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import team.MediaSoft.CRUDForCustomersDemo.model.Customer;
import team.MediaSoft.CRUDForCustomersDemo.repository.CustomerRepo;
import team.MediaSoft.CRUDForCustomersDemo.service.CustomerService;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
@Primary
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepo repository;

    @Override
    public List<Customer> getAllCustomers() {return repository.findAll();}

    @Override
    public Customer saveCustomer(Customer customer) {return repository.save(customer);}
    @Override
    public Customer updateCustomer(Customer customer) {
        repository.deleteById(customer.getId());
        return repository.save(customer);}

    @Override
    public Customer getCustomerById(UUID id) {return repository.getCustomerById(id);}

    @Override
    @Transactional
    public void deleteCustomerById(UUID id) {repository.deleteCustomerById(id);}
}
