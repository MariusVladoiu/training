package com.wipro.training;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.wipro.training.service.PersonDTO;
import jdk.nashorn.internal.parser.JSONParser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PersonControllerAppContextTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper; // We add a helper class to parse the data

    @Test
    public void getPersonList() throws Exception {
        this.mockMvc.perform(get("/person/list")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("id")));
    }
    @Test
    public void getPersonById() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/person/{id}", "5dfa43e2191fd22c0c0badbe")
                .accept(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
    }
    @Test
    public void createPerson() throws Exception {
        String json = "{\"name\":\"Popa\",\"firstName\":\"Ion\",\"cnp\":\"1234567890123\",\"icSeries\":\"AB\",\"icNumber\":235654,\"birthDate\":\"13/12/2019\",\"serviceSupplier\":\"Regina Maria\",\"medicalSubscription\":\"Analize\",\"genderType\":\"M\",\"medicalHistory\":[\"chronicDisease\",\"surgicalInterventions\",\"noProblem\"],\"observation\":\"abcd\"}";
        JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();

        PersonDTO person = new PersonDTO(null, jsonObject.get("name").toString(),
                jsonObject.get("firstName").toString(), jsonObject.get("cnp").toString());
        this.mockMvc.perform(
                MockMvcRequestBuilders.post("/person/create")
                        .content(objectMapper.writeValueAsString(person)) // Send the proper objects
                        .contentType(MediaType.APPLICATION_JSON)            // Serialize as JSON the information
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                /*.andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())*/;
    }
}
