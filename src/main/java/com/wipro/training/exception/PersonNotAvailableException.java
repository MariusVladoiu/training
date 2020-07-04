package com.wipro.training.exception;

public class PersonNotAvailableException extends Exception {

    public PersonNotAvailableException(String id) {
        super(String.format("Person wiith id [%s] does not exist", id));
    }
}
