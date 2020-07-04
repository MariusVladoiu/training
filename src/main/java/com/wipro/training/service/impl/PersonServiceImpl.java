package com.wipro.training.service.impl;

import com.wipro.training.exception.PersonNotAvailableException;
import com.wipro.training.model.Person;
import com.wipro.training.repository.PersonRepository;
import com.wipro.training.service.PersonDTO;
import com.wipro.training.service.PersonService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonRepository repository;

    @Override
    public String greet() {
        return "Hello World";
    }

    @Override
    public Person createPerson(Person person) {
        return repository.save(person);
    }

    @Override
    public PersonDTO createPerson(PersonDTO personDto) throws ParseException {
        Person person = convertToPerson(personDto);
        return convertToPersonDTO(repository.save(person));
    }


    @Override
    public Person getPersonById(String id) throws PersonNotAvailableException {
        Optional<Person> personOptional = repository.findById(new ObjectId(id));
        if(!personOptional.isPresent()){
            throw new PersonNotAvailableException(id);
        }

        return personOptional.get();
    }

    @Override
    public PersonDTO getPersonDtoById(String id) throws PersonNotAvailableException {
        Optional<Person> personOptional = repository.findById(new ObjectId(id));
        if(!personOptional.isPresent()){
            throw new PersonNotAvailableException(id);
        }

        return convertToPersonDTO( personOptional.get() );
    }

    @Override
    public Person updatePersonById(String id, Person person) throws PersonNotAvailableException {
        Optional<Person> personOptional = repository.findById(new ObjectId(id));
        if(personOptional.isPresent()){
            Person availableStudent = personOptional.get();
            updatePersonData(person, availableStudent);
            return repository.save(availableStudent);
        } else {
            throw new PersonNotAvailableException(id);
        }
    }

    @Override
    public PersonDTO updatePersonById(String id, PersonDTO personDto) throws PersonNotAvailableException, ParseException {
        Person person = convertToPerson(personDto);
        Optional<Person> personOptional = repository.findById(new ObjectId(id));
        if(personOptional.isPresent()){
            Person availableStudent = personOptional.get();
            updatePersonData(person, availableStudent);
            Person retPerson = repository.save(availableStudent);
            return convertToPersonDTO(retPerson);
        } else {
            throw new PersonNotAvailableException(id);
        }
    }
    private void updatePersonData(Person newPersonData, Person availablePerson) {
        availablePerson.setName(newPersonData.getName());
        availablePerson.setFirstName(newPersonData.getFirstName());
        availablePerson.setCnp(newPersonData.getCnp());
        availablePerson.setIcSeries(newPersonData.getIcSeries());
        availablePerson.setIcNumber(newPersonData.getIcNumber());
        availablePerson.setBirthDate(newPersonData.getBirthDate());
        availablePerson.setServiceSupplier(newPersonData.getServiceSupplier());
        availablePerson.setMedicalSubscription(newPersonData.getMedicalSubscription());
        availablePerson.setGenderType(newPersonData.getGenderType());
        availablePerson.setMedicalHistory(newPersonData.getMedicalHistory());
        availablePerson.setObservation(newPersonData.getObservation());
    }

    @Override
    public Person deletePersonById(String id) throws PersonNotAvailableException {
        Optional<Person> personToDelete = repository.findById(new ObjectId(id));

        if(personToDelete.isPresent()){
            Person person = personToDelete.get();
            repository.deleteById(new ObjectId(id));
            return person;
        } else {
            throw new PersonNotAvailableException(id);
        }
    }

    @Override
    public List<PersonDTO> getPersonList() {
        List<Person> personLst = repository.findAll();

        List<PersonDTO> ret = personLst.stream().map(p -> {
            PersonDTO r = convertToPersonDTO(p); return r;
        }).collect(Collectors.toList());

        return ret;
    }

    private Person convertToPerson(PersonDTO personDto) throws ParseException {
        Person person = new Person();
        person.setName(personDto.getName());
        person.setFirstName(personDto.getFirstName());
        person.setCnp(personDto.getCnp());
        person.setIcSeries(personDto.getIcSeries());
        person.setIcNumber(personDto.getIcNumber());
        person.setBirthDate(personDto.getBirthDate()==null ? null : new SimpleDateFormat("yyyy-MM-dd").parse(personDto.getBirthDate()));
        person.setServiceSupplier(personDto.getServiceSupplier());
        person.setMedicalSubscription(personDto.getMedicalSubscription());
        person.setGenderType(personDto.getGenderType());
        person.setMedicalHistory(personDto.getMedicalHistory()==null ? null : String.join(",", personDto.getMedicalHistory()));
        person.setObservation(personDto.getObservation());
        return person;
    }

    private PersonDTO convertToPersonDTO(Person person) {
        PersonDTO personDto = new PersonDTO();
        personDto.setId(person.getId().toString());
        personDto.setName(person.getName());
        personDto.setFirstName(person.getFirstName());
        personDto.setCnp(person.getCnp());
        personDto.setIcSeries(person.getIcSeries());
        personDto.setIcNumber(person.getIcNumber());
        personDto.setBirthDate(person.getBirthDate()==null ? null : new SimpleDateFormat("yyyy-MM-dd").format(person.getBirthDate()));
        personDto.setServiceSupplier(person.getServiceSupplier());
        personDto.setMedicalSubscription(person.getMedicalSubscription());
        personDto.setGenderType(person.getGenderType());
        personDto.setMedicalHistory(person.getMedicalHistory()==null || person.getMedicalHistory().isEmpty() ?
                new String[]{} : person.getMedicalHistory().split(","));
        personDto.setObservation(person.getObservation());
        return personDto;
    }


}
