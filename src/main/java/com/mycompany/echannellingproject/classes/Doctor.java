/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.echannellingproject.classes;

/**
 *
 * @author hasit
 */
public class Doctor extends Person{
    
    private String specialized ;
    private String contacts;

    public Doctor() {
    }
    
    

    public Doctor(String specialized, String contacts) {
        this.specialized = specialized;
        this.contacts = contacts;
    }

    public Doctor(String specialized, String contacts, int person_id, String person_name, String person_phoneNumber, String person_email, String person_address) {
        super(person_id, person_name, person_phoneNumber, person_email, person_address);
        this.specialized = specialized;
        this.contacts = contacts;
    }

    public String getSpecialized() {
        return specialized;
    }

    public void setSpecialized(String specialized) {
        this.specialized = specialized;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    @Override
    public String toString() {
        return "Doctor{" + "specialized=" + specialized + ", contacts=" + contacts + '}';
    }
    
}
