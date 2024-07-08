package team.MediaSoft.CRUDForCustomersDemo.repository;

import org.springframework.stereotype.Repository;
import team.MediaSoft.CRUDForCustomersDemo.model.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

//In case the db is unavailable
@Repository
public class InMemoryCustomerDAO {
    //todo
    private final List<Customer> CUSTOMERS = new ArrayList<>();

    public List<Customer> getAllCustomers(){return CUSTOMERS;}

    public Customer saveCustomer(Customer customer){
        CUSTOMERS.add(customer);
        return customer;
    }

    public Customer updateCustomer(Customer customer){
        var customerIndex = IntStream.range(0, CUSTOMERS.size())
                .filter(index -> CUSTOMERS.get(index).getId().equals(customer.getId()))
                .findFirst()
                .orElse(-1);
        if (customerIndex > -1) {
            CUSTOMERS.set(customerIndex, customer);
            return customer;
        }
        return null;
    }

    public Customer getCustomerById(UUID id){
        return CUSTOMERS
                .stream()
                .filter(element -> element.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void deleteCustomerById(UUID id){
        Customer customer = getCustomerById(id);
        if (customer != null) {
            CUSTOMERS.remove(customer);
        }
    }
}
