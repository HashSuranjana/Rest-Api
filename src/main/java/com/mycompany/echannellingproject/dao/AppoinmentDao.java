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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hasit
 */





/**
 * Data Access Object class for managing appointments.
 */
public class AppoinmentDao {

    private static final Logger LOGGER = Logger.getLogger(AppoinmentDao.class.getName());
    private static final List<Appoinment> appointments = new ArrayList<>();

    static {
        try {
            Patient patient1 = new Patient(1978, "Karan Johar", "417806612", "karanJ@gmail.com", "No.12,main street,colombo", "Heart Patient", "Treatment-continuing");
            Patient patient2 = new Patient(1123, "Hrithik Roshan", "418769634", "hrithikro@gmail.com", "sinha pl,Koswatta,Colombo", "Stresss", "Treatment-Not-Continuing");
            Doctor doctor1 = new Doctor(1, "Dr. J.Gunasena", "123987456", "gunasenaJ@gmail.com", "No.23,jakes Street,Colombo", "phycology", "email or phone");
            Doctor doctor2 = new Doctor(2, "Dr. John Doe", "2587896314", "Doe@hotmail.com", "uban city,lebonan", "Cardiologist", "email or phone");

            // Initialize with example data
            appointments.add(new Appoinment(1556, LocalDateTime.of(2024, 3, 10, 10, 0), patient1, doctor2));
            appointments.add(new Appoinment(2001, LocalDateTime.of(2024, 5, 11, 11, 0), patient1, doctor2));
            appointments.add(new Appoinment(323, LocalDateTime.of(2024, 2, 12, 12, 0), patient2, doctor1));
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Error occurred while initializing appointments: " + ex.getMessage(), ex);
            throw new AppointmentDaoException("Error initializing appointments", ex);
        }
    }

    public List<Appoinment> getAllAppointments() {
        try {
            return appointments;
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Error occurred while retrieving all appointments: " + ex.getMessage(), ex);
            throw new AppointmentDaoException("Error retrieving all appointments", ex);
        }
    }

    public Appoinment getAppointmentById(int appointmentId) {
        try {
            for (Appoinment appointment : appointments) {
                if (appointment.getAppointment_Id() == appointmentId) {
                    return appointment;
                }
            }
            return null;
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Error occurred while retrieving appointment by ID: " + ex.getMessage(), ex);
            throw new AppointmentDaoException("Error retrieving appointment by ID", ex);
        }
    }

    public void addAppointment(Appoinment appointment) {
        try {
            appointments.add(appointment);
            LOGGER.log(Level.INFO, "New appointment added: " + appointment);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Error occurred while adding appointment: " + ex.getMessage(), ex);
            throw new AppointmentDaoException("Error adding appointment", ex);
        }
    }

    public void updateAppointment(Appoinment updatedAppointment) {
        try {
            for (int i = 0; i < appointments.size(); i++) {
                if (appointments.get(i).getAppointment_Id() == updatedAppointment.getAppointment_Id()) {
                    appointments.set(i, updatedAppointment);
                    LOGGER.log(Level.INFO, "Appointment updated: " + updatedAppointment);
                    return;
                }
            }
            LOGGER.log(Level.SEVERE, "Appointment not found with ID: " + updatedAppointment.getAppointment_Id());
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Error occurred while updating appointment: " + ex.getMessage(), ex);
            throw new AppointmentDaoException("Error updating appointment", ex);
        }
    }

    public void deleteAppointment(int appointmentId) {
        try {
            appointments.removeIf(appointment -> appointment.getAppointment_Id()== appointmentId);
            LOGGER.log(Level.INFO, "Appointment deleted with ID: " + appointmentId);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Error occurred while deleting appointment: " + ex.getMessage(), ex);
            throw new AppointmentDaoException("Error deleting appointment", ex);
        }
    }

    // Custom exception class for AppointmentDao
    public static class AppointmentDaoException extends RuntimeException {
        public AppointmentDaoException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}

