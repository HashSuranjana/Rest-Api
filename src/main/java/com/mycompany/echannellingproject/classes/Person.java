/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.echannellingproject.classes;

/**
 *
 * @author hasit
 */
public class Person {
    
    private int  person_id;
    private String person_name;
    private String person_phoneNumber;
    private String person_email;
    private String person_address;
    
    public Person() {
        
    }
    
    public Person(int person_id, String person_name,String person_phoneNumber,String person_email,String person_address){
        
        this.person_id = person_id ;
        this.person_name = person_name;
        this.person_phoneNumber = person_phoneNumber;
        this.person_email = person_email;
        this.person_address = person_address;
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public String getPerson_name() {
        return person_name;
    }

    public void setPerson_name(String person_name) {
        this.person_name = person_name;
    }

    public String getPerson_phoneNumber() {
        return person_phoneNumber;
    }

    public void setPerson_phoneNumber(String person_phoneNumber) {
        this.person_phoneNumber = person_phoneNumber;
    }

    public String getPerson_email() {
        return person_email;
    }

    public void setPerson_email(String person_email) {
        this.person_email = person_email;
    }

    public String getPerson_address() {
        return person_address;
    }

    public void setPerson_address(String person_address) {
        this.person_address = person_address;
    }

    @Override
    public String toString() {
        return "Person{" + "person_id=" + person_id + ", person_name=" + person_name + ", person_phoneNumber=" + person_phoneNumber + ", person_email=" + person_email + ", person_address=" + person_address + '}';
    }
    
    
    
}
