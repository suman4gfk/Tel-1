package com.infytel.controller;

import com.infytel.dto.CustomerDTO;
import com.infytel.dto.PlanDTO;
import com.infytel.errors.ErrorMessage;
import com.infytel.exceptions.NoSuchCustomerException;
import com.infytel.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/customers")
@Validated
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    /*@CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping()
    public String homeInit(Model model) {
        return "home";
    }*/

    @GetMapping(produces = "application/json")
    public List<CustomerDTO> fetchCustomer() {
        return customerService.fetchCustomer();
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity createCustomer(@Valid @RequestBody CustomerDTO customerDTO, Errors errors) {
        String response = "";
        if (errors.hasErrors()) {
            response = errors.getAllErrors()
                    .stream()
                    .map(ObjectError::getDefaultMessage)
                    .collect(Collectors.joining(","));
            ErrorMessage errorMessage = new ErrorMessage();
            errorMessage.setErrorCode(HttpStatus.NOT_ACCEPTABLE.value());
            errorMessage.setMessage(response);
            return ResponseEntity.ok(errorMessage);
        } else {
            PlanDTO planDTO = new RestTemplate().
                    getForObject("http://localhost:8081/infytel-2/plans/"
                            + customerDTO.getCurrentPlan()
                            .getPlanId(), PlanDTO.class, PlanDTO.class);
            System.out.println("Plan Details: " + planDTO);
            customerDTO.setCurrentPlan(planDTO);
            response = customerService.CreateCustomer(customerDTO);
            return ResponseEntity.ok(response);
        }
    }

    @PutMapping(value = "/{phoneNumber}")
    public String updateCustomers(@PathVariable("phoneNumber")
                                  @Pattern(regexp = "[0-9]{10}",
                                          message = "{customer.phoneNo.invalid}") String phoneNumber,
                                  @RequestBody CustomerDTO customerDTO) throws NoSuchCustomerException {
        return customerService.updateCustomers(Long.parseLong(phoneNumber), customerDTO);
    }

    @DeleteMapping(value = "/{phoneNumber}")
    public String deleteCustomers(@PathVariable("phoneNumber")
                                  @Pattern(regexp = "[0-9]{10}",
                                          message = "{customer.phoneNo.invalid}") String phoneNumber)
            throws NoSuchCustomerException {

        return customerService.deleteCustomer(Long.parseLong(phoneNumber));
    }
    /*
    RestTemplate restTemplate = new RestTemplate();
    String url="http://localhost:8080/infytel/customers";
    List<CustomerDTO> customers = (List<CustomerDTO>) restTemplate.getForObject(url, List.class);
    ResponseEntity<String> response =   restTemplate.postForEntity(url,customerrequest,String.class );

    **/
}
