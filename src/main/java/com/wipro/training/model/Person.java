package com.wipro.training.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class Person {
    @Id
    private ObjectId id;

    @NotNull(message = "First Name cannot be null")
    private String name;
    private String firstName;
    private String cnp;
    private String icSeries;
    private String icNumber;
    private Date birthDate;
    /*private int serviceSupplierId;
    private int medicalSubscriptionId;*/
    private String serviceSupplier;
    private String medicalSubscription;
    private String genderType;
    private String medicalHistory;
    /*private boolean chronicDisease;
    private boolean surgicalInterventions;
    private boolean noChronicDeseaseOrSurgicalIntervention;*/
    private String observation;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
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

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }
}
