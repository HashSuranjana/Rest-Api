/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.echannellingproject.dao;

import com.mycompany.echannellingproject.classes.Patient;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hasit
 */





/**
 * Data Access Object class for managing patients.
 */
public class PatientDao extends PersonDao {

    private static final Logger LOGGER = Logger.getLogger(PatientDao.class.getName());
    private static Map<Integer, Patient> patients = new HashMap<>();
    private static int nextId = 1;
    
    static {
        // Example Person objects
        Patient patient1 = new Patient(112, "Karan Johar", "417806612", "karanJ@gmail.com", "No.12,main street,colombo", "Heart Patient", "Treatment-continuing");
        Patient patient2 = new Patient(244, "Hrithik Roshan", "418769634", "hrithikro@gmail.com", "sinha pl,Koswatta,Colombo", "Back pain Patient", "Treatment-Not-Continuing");
        Patient patient3 = new Patient(334, "Amal Perera", "413254709", "amalP12@gmail.com", "'Amal',godagama,colombo", "Heat Patient", "Treatment-continuing");


        // Adding persons to the map
        addPerson(patient1);
        addPerson(patient2);
        addPerson(patient3);
    }
    
    // Create
    public static int addPatient(Patient patient) {
        try {
            validatePatient(patient);
            patient.setPerson_id(nextId++);
            patients.put(patient.getPerson_id(), patient);
            return patient.getPerson_id();
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Error occurred while adding patient: " + ex.getMessage(), ex);
            throw new PatientDaoException("Error adding patient", ex);
        }
    }

    // Read
    public static Patient getPatientById(int id) {
        try {
            return patients.get(id);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Error occurred while retrieving patient: " + ex.getMessage(), ex);
            throw new PatientDaoException("Error retrieving patient", ex);
        }
    }

    public static List<Patient> getAllPatients() {
        try {
            return new ArrayList<>(patients.values());
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Error occurred while retrieving all patients: " + ex.getMessage(), ex);
            throw new PatientDaoException("Error retrieving all patients", ex);
        }
    }

    // Update
    public static void updatePatient(int id, Patient updatedPatient) {
        try {
            if (patients.containsKey(id)) {
                validatePatient(updatedPatient);
                updatedPatient.setPerson_id(id);
                patients.put(id, updatedPatient);
            } else {
                throw new IllegalArgumentException("Patient with ID " + id + " does not exist.");
            }
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Error occurred while updating patient: " + ex.getMessage(), ex);
            throw new PatientDaoException("Error updating patient", ex);
        }
    }

    // Delete
    public static void deletePatient(int id) {
        try {
            if (patients.containsKey(id)) {
                patients.remove(id);
            } else {
                throw new IllegalArgumentException("Patient with ID " + id + " does not exist.");
            }
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Error occurred while deleting patient: " + ex.getMessage(), ex);
            throw new PatientDaoException("Error deleting patient", ex);
        }
    }

    // Exception Handling and Validation
    public static void validatePatient(Patient patient) {
        try {
            validatePerson(patient); // Utilize parent class method for basic validation
            // Additional validation specific to Patient class can be added here
            if (patient.getMedical_history() == null || patient.getMedical_history().isEmpty()) {
                throw new IllegalArgumentException("Medical history cannot be empty.");
            }
            // Similarly, validate other fields like current_health
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Error occurred while validating patient: " + ex.getMessage(), ex);
            throw new PatientDaoException("Error validating patient", ex);
        }
    }

    // Custom exception class for PatientDao
    public static class PatientDaoException extends RuntimeException {
        public PatientDaoException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}


