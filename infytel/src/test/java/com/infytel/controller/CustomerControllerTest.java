package com.infytel.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infytel.dto.CustomerDTO;
import com.infytel.dto.FriendsFamilyDTO;
import com.infytel.dto.PlanDTO;
import com.infytel.service.CustomerService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@WebMvcTest(value = CustomerController.class)
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService customerService;

    private CustomerDTO customerDTO = null;
    private List<CustomerDTO> customers = null;

    @Before
    public void setUp() {
        customerDTO = new CustomerDTO();
        PlanDTO planDTO = new PlanDTO();
        planDTO.setPlanId(1);
        planDTO.setPlanName("Simple");
        planDTO.setLocalRate(3);
        planDTO.setNationalRate(5);
        customerDTO.setAddress("Chennai");
        customerDTO.setAge(18);
        customerDTO.setCurrentPlan(planDTO);
        customerDTO.setGender('m');
        customerDTO.setName("Jack");
        customerDTO.setEmail("Jack@infy.com");
        customerDTO.setPassword("ABC@123");
        customerDTO.setPhoneNo(9951212222l);
        List<FriendsFamilyDTO> friendAndFamily = new ArrayList<>();
        friendAndFamily.add(new FriendsFamilyDTO(customerDTO.getPhoneNo(), 800000145));
        friendAndFamily.add(new FriendsFamilyDTO(customerDTO.getPhoneNo(), 700000145));
        customerDTO.setFriendsFamilyDTO(friendAndFamily);
        customers = new ArrayList<>();
        customers.add(customerDTO);
    }

    @Test
    public void fetchCustomer() throws Exception {
        Mockito.when(customerService.fetchCustomer()).thenReturn(customers);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/customers")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();
        ObjectMapper mapper = new ObjectMapper();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        mapper.writeValue(out, customers);
        byte[] data = out.toByteArray();
        Assert.assertEquals(new String(data), response.getContentAsString());
    }

    @Test
    public void createCustomer() throws Exception {

        // setting behaviour for createCustomer of customerservice that is mocked
        Mockito.when(customerService.CreateCustomer(Mockito.any(CustomerDTO.class)))
                .thenReturn(customerDTO.getName() + "added successfully");
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        // Send Customer as request body to /customers
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/customers").accept(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsBytes(customerDTO)).contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        Assert.assertEquals("Jackadded successfully", response.getContentAsString());
        Assert.assertEquals(HttpStatus.OK.value(), response.getStatus());
    }
}