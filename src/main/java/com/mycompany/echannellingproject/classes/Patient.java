/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.echannellingproject.classes;

/**
 *
 * @author hasit
 */
public class Patient extends Person {
    
    private String medical_history;
    private String current_health;

    public Patient() {}
    
    public Patient(String medical_history, String current_health, int person_id, String person_name, String person_phoneNumber, String person_email, String person_address) {
        super(person_id, person_name, person_phoneNumber, person_email, person_address);
        this.medical_history = medical_history;
        this.current_health = current_health;
    }
    
    public String getMedical_history() {
        return medical_history;
    }

    public void setMedical_history(String medical_history) {
        this.medical_history = medical_history;
    }

    public String getCurrent_health() {
        return current_health;
    }

    public void setCurrent_health(String current_health) {
        this.current_health = current_health;
    }

    @Override
    public String toString() {
        return "Patient{" + "medical_history=" + medical_history + ", current_health=" + current_health + '}';
    }
    
     
}
