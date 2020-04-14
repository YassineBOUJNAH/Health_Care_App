package com.ensias.healthcareapp.model;

public class Patient extends User {
    private String dateNaissance;
    private String situationFamiliale;

    public Patient(String name, String adresse, String tel, String email, String dateNaissance, String situationFamiliale) {
        /*super(name, adresse, tel, email);
        this.dateNaissance = dateNaissance;
        this.situationFamiliale = situationFamiliale;*/
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getSituationFamiliale() {
        return situationFamiliale;
    }

    public void setSituationFamiliale(String situationFamiliale) {
        this.situationFamiliale = situationFamiliale;
    }
}
