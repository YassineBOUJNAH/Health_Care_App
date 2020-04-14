package com.ensias.healthcareapp.model;

import java.util.Date;

public class Fiche {
    private float poids;
    private String operation;
    private String groupeSanguin;
    private String maladie;
    private float taille;
    private Date dateCreation;

    public Fiche(float poids, String operation, String groupeSanguin, String maladie, float taille, Date dateCreation) {
        this.poids = poids;
        this.operation = operation;
        this.groupeSanguin = groupeSanguin;
        this.maladie = maladie;
        this.taille = taille;
        this.dateCreation = dateCreation;
    }

    public float getPoids() {
        return poids;
    }

    public void setPoids(float poids) {
        this.poids = poids;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getGroupeSanguin() {
        return groupeSanguin;
    }

    public void setGroupeSanguin(String groupeSanguin) {
        this.groupeSanguin = groupeSanguin;
    }

    public String getMaladie() {
        return maladie;
    }

    public void setMaladie(String maladie) {
        this.maladie = maladie;
    }

    public float getTaille() {
        return taille;
    }

    public void setTaille(float taille) {
        this.taille = taille;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }
}

