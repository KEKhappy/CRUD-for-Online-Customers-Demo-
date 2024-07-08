package team.MediaSoft.CRUDForCustomersDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import team.MediaSoft.CRUDForCustomersDemo.model.Customer;
import java.util.UUID;

public interface CustomerRepo extends JpaRepository<Customer, UUID> {
    Customer getCustomerById(UUID id);
    void deleteCustomerById(UUID id);
}
