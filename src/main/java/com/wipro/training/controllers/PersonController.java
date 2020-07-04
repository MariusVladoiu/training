package com.wipro.training.controllers;

import com.wipro.training.exception.PersonNotAvailableException;
import com.wipro.training.model.Person;
import com.wipro.training.service.PersonDTO;
import com.wipro.training.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping(path = "/person")
public class PersonController {

    @Autowired
    private PersonService personService;


    @CrossOrigin
    @GetMapping(path = "/{id}")
    public ResponseEntity<PersonDTO> getPersonById(@PathVariable String id) throws PersonNotAvailableException {
        PersonDTO personDto = personService.getPersonDtoById(id);
        return new ResponseEntity<>(personDto, HttpStatus.OK);
    }
/*    @GetMapping(path = "/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable String id) throws PersonNotAvailableException {
        Person person = personService.getPersonById(id);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }*/

    @CrossOrigin
    @PostMapping(path = "/create")
    public ResponseEntity<PersonDTO> createPerson(@RequestBody PersonDTO person) throws ParseException {
        PersonDTO person1 = this.personService.createPerson(person);
        return new ResponseEntity<>(person1, HttpStatus.CREATED);
    }

    /*@PostMapping(path = "/create")
    public ResponseEntity<Person> createPerson(@RequestBody Person person){
        Person person1 = this.personService.createPerson(person);
        return new ResponseEntity<>(person1, HttpStatus.CREATED);
    }*/

    @CrossOrigin
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Person> deletePersonById(@PathVariable String id) throws PersonNotAvailableException {
        Person deletedPerson = personService.deletePersonById(id);
        return new ResponseEntity<>(deletedPerson, HttpStatus.OK);
    }

    @CrossOrigin
    @PutMapping(path = "/update/{id}")
    public ResponseEntity<PersonDTO> updatePersonById(@PathVariable String id, @RequestBody PersonDTO newPersonData) throws PersonNotAvailableException, ParseException {
        PersonDTO person = personService.updatePersonById(id, newPersonData);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }
    /*@PutMapping(path = "/update/{id}")
    public ResponseEntity<Person> updatePersonById(@PathVariable String id, @RequestBody Person newPersonData) throws PersonNotAvailableException {
        Person person = personService.updatePersonById(id, newPersonData);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }*/

    @CrossOrigin
    @GetMapping(path = "/list")
    public @ResponseBody List<PersonDTO> getPersonList() throws PersonNotAvailableException {
        return personService.getPersonList();
    }


    @CrossOrigin
    @GetMapping(path = "/first_list")
    public @ResponseBody PersonDTO getFirstPersonFromListList() throws PersonNotAvailableException {
        return personService.getPersonList().get(0);
    }

    //@RequestMapping("/greeting")
    @CrossOrigin
    @GetMapping(path = "/greeting")
    public @ResponseBody String greeting() {
        return personService.greet();
    }
}
