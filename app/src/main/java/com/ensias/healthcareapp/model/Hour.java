package com.ensias.healthcareapp.model;

public class Hour {
    private String patient;

    public Hour(String patient) {
        this.patient = patient;
    }
    public Hour(){

    }
    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }
}
