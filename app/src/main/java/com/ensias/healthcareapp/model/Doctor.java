package com.ensias.healthcareapp.model;

public class Doctor extends User {
    private String specialite;

    public Doctor(String name, String adresse, String tel, String email, String specialite) {
       /* super(name, adresse, tel, email);
        this.specialite = specialite;*/
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }
}
