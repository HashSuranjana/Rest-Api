/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.echannellingproject.dao;

import com.mycompany.echannellingproject.classes.Prescription;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author hasit
 */
public class PrescriptionDao {
    
    private static final Map<Integer, Prescription> prescriptions = new HashMap<>();
    private static int nextId = 1;
    
    static {
        Prescription prescription1 = new Prescription(123,"Medicine A", "10mg", "Take twice daily", "5 days");
        Prescription prescription2 = new Prescription(456,"Medicine B", "5mg", "Take once daily after lunch", "2 weeks");
        Prescription prescription3 = new Prescription(789,"Medicine C", "16mg", "Take as needed", "3 days");
        
        addPrescription(prescription1);
        addPrescription(prescription2);
        addPrescription(prescription3);
    }

    // Create
    public static int addPrescription(Prescription prescription) {
        validatePrescription(prescription);
        prescription.setPres_Id(nextId++);
        prescriptions.put(prescription.getPres_Id(), prescription);
        return prescription.getPres_Id();
    }

    // Read
    public static Prescription getPrescriptionById(int id) {
        return prescriptions.get(id);
    }

    public static List<Prescription> getAllPrescriptions() {
        return new ArrayList<>(prescriptions.values());
    }

    // Update
    public static void updatePrescription(int id, Prescription updatedPrescription) {
        if (prescriptions.containsKey(id)) {
            validatePrescription(updatedPrescription);
            updatedPrescription.setPres_Id(id);
            prescriptions.put(id, updatedPrescription);
        } else {
            throw new IllegalArgumentException("Prescription with ID " + id + " does not exist.");
        }
    }

    // Delete
    public static void deletePrescription(int id) {
        if (prescriptions.containsKey(id)) {
            prescriptions.remove(id);
        } else {
            throw new IllegalArgumentException("Prescription with ID " + id + " does not exist.");
        }
    }

    // Exception Handling and Validation
    public static void validatePrescription(Prescription prescription) {
        // Add your validation logic here
        // For example, ensuring medicationName is not null or empty, dosage is not null or empty, etc.
        if (prescription.getMedication()== null || prescription.getMedication().isEmpty()) {
            throw new IllegalArgumentException("Medication name cannot be empty.");
        }
        
    }
    
}
