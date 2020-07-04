package com.wipro.training.service;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.bson.types.ObjectId;

import java.util.Date;

public class PersonDTO {
    private String id;

    private String name;
    private String firstName;
    private String cnp;
    private String icSeries;
    private String icNumber;
    private String birthDate;
    /*private int serviceSupplierId;
    private int medicalSubscriptionId;*/
    private String serviceSupplier;
    private String medicalSubscription;
    private String genderType;
    private String[] medicalHistory;
    private String observation;

    public PersonDTO() { }
    public PersonDTO(JsonObject jsonObject) {
        this(null, jsonObject.get("name").toString(),
                jsonObject.get("firstName").toString(), jsonObject.get("cnp").toString());
    }

    public PersonDTO(String id, String name, String firstName, String cnp) {
        this.id = id;
        this.name = name;
        this.firstName = firstName;
        this.cnp = cnp;
    }

    public PersonDTO(String id, String name, String firstName, String cnp, String icSeries, String icNumber,
                     String birthDate, String serviceSupplier, String medicalSubscription, String genderType,
                     String[] medicalHistory, String observation) {
        this.id = id;
        this.name = name;
        this.firstName = firstName;
        this.cnp = cnp;
        this.icSeries = icSeries;
        this.icNumber = icNumber;
        this.birthDate = birthDate;
        this.serviceSupplier = serviceSupplier;
        this.medicalSubscription = medicalSubscription;
        this.genderType = genderType;
        this.medicalHistory = medicalHistory;
        this.observation = observation;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public String getIcSeries() {
        return icSeries;
    }

    public void setIcSeries(String icSeries) {
        this.icSeries = icSeries;
    }

    public String getIcNumber() {
        return icNumber;
    }

    public void setIcNumber(String icNumber) {
        this.icNumber = icNumber;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getServiceSupplier() {
        return serviceSupplier;
    }

    public void setServiceSupplier(String serviceSupplier) {
        this.serviceSupplier = serviceSupplier;
    }

    public String getMedicalSubscription() {
        return medicalSubscription;
    }

    public void setMedicalSubscription(String medicalSubscription) {
        this.medicalSubscription = medicalSubscription;
    }

    public String getGenderType() {
        return genderType;
    }

    public void setGenderType(String genderType) {
        this.genderType = genderType;
    }

    public String[] getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String[] medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }
}
