package com.infytel.repository;

import com.infytel.dto.CustomerDTO;
import com.infytel.dto.FriendsFamilyDTO;
import com.infytel.dto.PlanDTO;
import com.infytel.exceptions.NoSuchCustomerException;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepository {

    List<CustomerDTO> customers = null;

    @PostConstruct
    private void initializer() {

        customers = new ArrayList<>();
        CustomerDTO customerDTO = new CustomerDTO();
        PlanDTO planDTO = new PlanDTO(1, "Simple", 3, 5);

        customerDTO.setAddress("Chennai");
        customerDTO.setAge(18);
        customerDTO.setCurrentPlan(planDTO);
        customerDTO.setGender('m');
        customerDTO.setName("Jack");
        customerDTO.setEmail("Jack@infy.com");
        customerDTO.setPassword("ABC@123");
        customerDTO.setPhoneNo(9951212222L);

        List<FriendsFamilyDTO> friendsFamilyDTOS = new ArrayList<>();
        friendsFamilyDTOS.add(new FriendsFamilyDTO(customerDTO.getPhoneNo(), 800000145));
        friendsFamilyDTOS.add(new FriendsFamilyDTO(customerDTO.getPhoneNo(), 700000145));

        customerDTO.setFriendsFamilyDTO(friendsFamilyDTOS);
        customers.add(customerDTO);

    }

    public String CreateCustomer(CustomerDTO customerDTO) {
        customers.add(customerDTO);
        return "Customer details got added successfully";
    }

    public List<CustomerDTO> fetchCustomer() {
        return customers;
    }

    public boolean deleteCustomer(long phoneNumber) throws NoSuchCustomerException {
        boolean responseDelete = false;
        for (CustomerDTO customer : customers) {
            if (customer.getPhoneNo() == phoneNumber) {
                customers.remove(customer);
                responseDelete = true;
                break;
            }
        }
        return responseDelete;
    }

    public boolean updateCustomer(long phoneNumber, CustomerDTO customerDTO) {
        boolean responseUpdate = false;
        for (CustomerDTO customer : customers) {
            if (customer.getPhoneNo() == phoneNumber) {
                if (customerDTO.getAddress() != null) {
                    customer.setAddress(customerDTO.getAddress());
                }
                if (customerDTO.getEmail() != null) {
                    customer.setEmail(customerDTO.getEmail());
                }
                responseUpdate = true;
                break;
            }
        }
        return responseUpdate;
    }
}
