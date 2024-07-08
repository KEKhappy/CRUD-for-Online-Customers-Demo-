package team.MediaSoft.CRUDForCustomersDemo.service.implementation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import team.MediaSoft.CRUDForCustomersDemo.model.Customer;
import team.MediaSoft.CRUDForCustomersDemo.repository.CustomerRepo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest{
    @Mock
    private CustomerRepo repo;
    @InjectMocks
    private CustomerServiceImpl serviceImpl;

    @Test
    public void shouldUpdateCustomerByID(){ // Unit-test for business logic
        List<Customer> list = getSomeCustomers();
        Mockito.when(repo.getCustomerById(list.get(0).getId())).thenReturn(list.get(0));
        Mockito.when(repo.getCustomerById(list.get(1).getId())).thenReturn(list.get(1));


        Customer res = serviceImpl.getCustomerById(list.get(0).getId());
        Assertions.assertNotNull(res);
        Assertions.assertEquals(Customer.class, res.getClass());
        Assertions.assertEquals(list.get(0).getId(),res.getId());

    }
    private List<Customer> getSomeCustomers(){
        List<Customer> res = new ArrayList<>(2);
        Customer c1 = new Customer();
        Customer c2 = new Customer();
        res.add(c1);res.add(c2);
        c1.setId(UUID.randomUUID()); c2.setId(UUID.randomUUID());
        c1.setUsername("sdwqq"); c1.setUsername("sd2q");
        c1.setEmail("12344@mail.ru"); c2.setEmail("31sdaewq@yandex.ru");
        c1.setBalance(BigDecimal.TEN); c2.setBalance(BigDecimal.TEN);
        return res;
    }

}
