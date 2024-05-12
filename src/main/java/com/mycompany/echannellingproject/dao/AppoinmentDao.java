/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.echannellingproject.dao;

import com.mycompany.echannellingproject.classes.Appoinment;
import com.mycompany.echannellingproject.classes.Patient;
import com.mycompany.echannellingproject.classes.Doctor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hasit
 */


public class AppoinmentDao {
    private static final List<Appoinment> appointments = new ArrayList<>();

    static {
        
        Patient patient1 = new Patient(1, "Dr. John Doe", "General Physician", "Cardiologist", "Cardiologist", "Cardiologist", "Cardiologist");
        Doctor doctor1 = new Doctor(1, "Dr. John Doe", "General Physician", "Cardiologist", "Cardiologist", "Cardiologist", "Cardiologist");
        
        // Initialize with example data
        appointments.add(new Appoinment(1, LocalDateTime.of(2024, 5, 10, 10, 0), patient1, doctor1));
        appointments.add(new Appoinment(2, LocalDateTime.of(2024, 5, 11, 11, 0), patient1, doctor1));
        appointments.add(new Appoinment(3, LocalDateTime.of(2024, 5, 12, 12, 0), patient1, doctor1));
    }

    public List<Appoinment> getAllAppointments() {
        return appointments;
    }

    public Appoinment getAppointmentById(int appointmentId) {
        for (Appoinment appointment : appointments) {
            if (appointment.getAppointment_Id()== appointmentId) {
                return appointment;
            }
        }
        return null;
    }

    public void addAppointment(Appoinment appointment) {
        appointments.add(appointment);
        System.out.println("New appointment added: " + appointment);
    }

    public void updateAppointment(Appoinment updatedAppointment) {
        for (int i = 0; i < appointments.size(); i++) {
            if (appointments.get(i).getAppointment_Id()== updatedAppointment.getAppointment_Id()) {
                appointments.set(i, updatedAppointment);
                System.out.println("Appointment updated: " + updatedAppointment);
                return;
            }
        }
        System.out.println("Appointment not found with id: " + updatedAppointment.getAppointment_Id());
    }

    public void deleteAppointment(int appointmentId) {
        appointments.removeIf(appointment -> appointment.getAppointment_Id() == appointmentId);
        System.out.println("Appointment deleted with id: " + appointmentId);
    }
}
