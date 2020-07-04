package com.wipro.training.service;

import com.wipro.training.exception.PersonNotAvailableException;
import com.wipro.training.model.Person;

import java.text.ParseException;
import java.util.List;

public interface PersonService {
    String greet();
    Person createPerson(Person person);
    PersonDTO createPerson(PersonDTO personDto) throws ParseException;
    Person getPersonById(String id) throws PersonNotAvailableException;
    PersonDTO getPersonDtoById(String id) throws PersonNotAvailableException;
    Person updatePersonById(String id, Person person) throws PersonNotAvailableException;
    PersonDTO updatePersonById(String id, PersonDTO personDto) throws PersonNotAvailableException, ParseException;

    Person deletePersonById(String id) throws PersonNotAvailableException;

    List<PersonDTO> getPersonList();
}
