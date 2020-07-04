package com.wipro.training;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wipro.training.controllers.PersonController;
import com.wipro.training.service.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(PersonController.class)
public class PersonController2Test {
    @Autowired
    private MockMvc mvc;
    @Autowired
    private ObjectMapper objectMapper; // We add a helper class to parse the data
    @MockBean
    private PersonService personService;
    //private EmployeeService employeeService;

    @MockBean
    BindingResult result;

    @MockBean
    Model model;

    @Test
    public void greetingShouldReturnMessageFromService() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/person/greeting")             // Cal the post method
                //.content(objectMapper.writeValueAsString(employee)) // Send the proper objects
                //.contentType(MediaType.APPLICATION_JSON)            // Serialize as JSON the information
                .accept(MediaType.APPLICATION_JSON)).andDo(print())
                .andExpect(status().isOk());                        // Expect a good HTTP status

        /*MockHttpServletRequestBuilder x = get("/person/greeting");
        when(personService.greet()).thenReturn("Hello Mock");
        this.mvc.perform(get("/person/greeting")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello Mock")));*/
    }

    /*@Test
    public void getAllEmployeesAPI() throws Exception {
        //this.mvc.perform(get("/person/list")).andDo(print()).andExpect(status().isOk())
        //        .andExpect(content().string(containsString("id")));

        mvc.perform( MockMvcRequestBuilders
                .get("/person/list")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.employees[*].employeeId").isNotEmpty());
    }*/

    /*@Test
    public void getEmployeeByIdAPI() throws Exception  {
        mvc.perform( MockMvcRequestBuilders
                .get("/person/{id}", "5dfa43e2191fd22c0c0badbe")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
                //.andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
    }*/
}