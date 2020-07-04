package com.wipro.training;

import com.wipro.training.configuration.IntegrationTest;
import com.wipro.training.controllers.EmployeeRESTController;
import com.wipro.training.controllers.PersonController;
import com.wipro.training.repository.PersonRepository;
import com.wipro.training.service.PersonService;
import com.wipro.training.service.impl.PersonServiceImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@Category(IntegrationTest.class)
@RunWith(SpringRunner.class)
@WebMvcTest(PersonController.class)
public class PersonControllerWebLayerIT {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private PersonServiceImpl personService;
    //private EmployeeService employeeService;

    @MockBean
    private PersonRepository repository;

    @MockBean
    BindingResult result;

    @MockBean
    Model model;

    /*@Test
    public void greetingShouldReturnMessageFromService() throws Exception {
        //MockHttpServletRequestBuilder x = get("/person/greeting");
        when(personService.greet()).thenCallRealMethod();
        this.mvc.perform(get("/person/greeting")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello World")));
    }*/

    @Test
    public void getAllEmployeesAPI() throws Exception {
        //this.mvc.perform(get("/person/list")).andDo(print()).andExpect(status().isOk())
        //        .andExpect(content().string(containsString("id")));
        when(repository.findAll()).thenCallRealMethod();
        when(personService.getPersonList()).thenCallRealMethod();
        this.mvc.perform( MockMvcRequestBuilders
                .get("/person/list")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.employees[*].employeeId").isNotEmpty());
    }

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
