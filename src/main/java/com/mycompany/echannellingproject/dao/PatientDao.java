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

/**
 *
 * @author hasit
 */


public class PatientDao extends PersonDao {

    private static Map<Integer, Patient> patients = new HashMap<>();
    private static int nextId = 1;
    
    // Static block for adding example Patient objects
    static {
        Patient patient1 = new Patient(1,"Heart Disease", "Stable", "John Doe", "1234567890", "john@example.com", "123 Street, City");
        Patient patient2 = new Patient(2,"Asthma", "Improving", "Alice Smith", "9876543210", "alice@example.com", "456 Avenue, Town");
        Patient patient3 = new Patient(3,"Diabetes", "Critical", "Bob Johnson", "5678901234", "bob@example.com", "789 Road, Village");
        
        addPatient(patient1);
        addPatient(patient2);
        addPatient(patient3);
    }


    // Create
    public static int addPatient(Patient patient) {
        validatePatient(patient);
        patient.setPerson_id(nextId++);
        patients.put(patient.getPerson_id(), patient);
        return patient.getPerson_id();
    }

    // Read
    public static Patient getPatientById(int id) {
        return patients.get(id);
    }

    public static List<Patient> getAllPatients() {
        return new ArrayList<>(patients.values());
    }

    // Update
    public static void updatePatient(int id, Patient updatedPatient) {
        if (patients.containsKey(id)) {
            validatePatient(updatedPatient);
            updatedPatient.setPerson_id(id);
            patients.put(id, updatedPatient);
        } else {
            throw new IllegalArgumentException("Patient with ID " + id + " does not exist.");
        }
    }

    // Delete
    public static void deletePatient(int id) {
        if (patients.containsKey(id)) {
            patients.remove(id);
        } else {
            throw new IllegalArgumentException("Patient with ID " + id + " does not exist.");
        }
    }

    // Exception Handling and Validation
    public static void validatePatient(Patient patient) {
        validatePerson(patient); // Utilize parent class method for basic validation
        // Additional validation specific to Patient class can be added here
        if (patient.getMedical_history() == null || patient.getMedical_history().isEmpty()) {
            throw new IllegalArgumentException("Medical history cannot be empty.");
        }
        // Similarly, validate other fields like current_health
    }
}

