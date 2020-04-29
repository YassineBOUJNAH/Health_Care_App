package com.ensias.healthcareapp.model;

public class Request {
    private  String id_patient;
    private String id_doctor;

    public Request(){

    }

    public String getId_patient() {
        return id_patient;
    }

    public void setId_patient(String id_patient) {
        this.id_patient = id_patient;
    }

    public String getId_doctor() {
        return id_doctor;
    }

    public void setId_doctor(String id_doctor) {
        this.id_doctor = id_doctor;
    }

    public Request(String id_patient, String id_doctor) {
        this.id_patient = id_patient;
        this.id_doctor = id_doctor;
    }
}
