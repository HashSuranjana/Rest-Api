/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.echannellingproject.classes;

import java.time.LocalDate;

/**
 *
 * @author hasit
 */
public class Billing {
    
    private int bill_Id;
    private double price;
    private LocalDate date;
    private boolean fees_paid;
    private Patient patient;

    public Billing() {
    }

    public Billing(int bill_Id, double price, LocalDate date, boolean fees_paid, Patient patient) {
        this.bill_Id = bill_Id;
        this.price = price;
        this.date = date;
        this.fees_paid = fees_paid;
        this.patient = patient;
    }

    public int getBill_Id() {
        return bill_Id;
    }

    public void setBill_Id(int bill_Id) {
        this.bill_Id = bill_Id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean isFees_paid() {
        return fees_paid;
    }

    public void setFees_paid(boolean fees_paid) {
        this.fees_paid = fees_paid;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public String toString() {
        return "Billing{" + "bill_Id=" + bill_Id + ", price=" + price + ", date=" + date + ", fees_paid=" + fees_paid + ", patient=" + patient + '}';
    }
    
    
    
}
