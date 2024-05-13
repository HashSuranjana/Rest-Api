/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.echannellingproject.classes;

import java.time.LocalDateTime;

/**
 *
 * @author hasit
 */
public class Appoinment {
    
    private int appointment_Id;
    private LocalDateTime date_Time;
    private Patient patient;
    private Doctor doctor;

    public Appoinment() {
    }

    public Appoinment(int appointment_Id, LocalDateTime date_Time, Patient patient, Doctor doctor) {
        this.appointment_Id = appointment_Id;
        this.date_Time = date_Time;
        this.patient = patient;
        this.doctor = doctor;
    }

    public int getAppointment_Id() {
        return appointment_Id;
    }

    public void setAppointment_Id(int appointment_Id) {
        this.appointment_Id = appointment_Id;
    }

    public LocalDateTime getDate_Time() {
        return date_Time;
    }

    public void setDate_Time(LocalDateTime date_Time) {
        this.date_Time = date_Time;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    @Override
    public String toString() {
        return "Appoinment{" + "appointment_Id=" + appointment_Id + ", date_Time=" + date_Time.getYear() + ", patient=" + patient + ", doctor=" + doctor + '}';
    }
    
    
    
}
