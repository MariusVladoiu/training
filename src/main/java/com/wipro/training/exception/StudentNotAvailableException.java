package com.wipro.training.exception;

public class StudentNotAvailableException extends Exception {

    public StudentNotAvailableException(String id) {
        super(String.format("User wiith id [%s] does not exist", id));
    }
}
