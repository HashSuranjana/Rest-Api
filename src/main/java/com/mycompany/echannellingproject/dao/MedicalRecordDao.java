/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.echannellingproject.dao;

import com.mycompany.echannellingproject.classes.MedicalRecord;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author hasit
 */
public class MedicalRecordDao {
    
    private static final Map<Integer, MedicalRecord> medicalRecords = new HashMap<>();
    
    
    
    
    // Create
    public static void addMedicalRecord(MedicalRecord medicalRecord) {
        validateMedicalRecord(medicalRecord);
        medicalRecords.put(medicalRecord.getPatientId(), medicalRecord);
    }
    
    // Read
    public static MedicalRecord getMedicalRecordByPatientId(int patientId) {
        return medicalRecords.get(patientId);
    }
    
    // Update
    public static void updateMedicalRecord(MedicalRecord updatedRecord) {
        if (medicalRecords.containsKey(updatedRecord.getPatientId())) {
            medicalRecords.put(updatedRecord.getPatientId(), updatedRecord);
        } else {
            throw new IllegalArgumentException("Medical record for patient with ID " + updatedRecord.getPatientId() + " does not exist.");
        }
    }
    
    // Delete
    public static void deleteMedicalRecord(int patientId) {
        if (medicalRecords.containsKey(patientId)) {
            medicalRecords.remove(patientId);
        } else {
            throw new IllegalArgumentException("Medical record for patient with ID " + patientId + " does not exist.");
        }
    }
    
    // Exception Handling and Validation
    public static void validateMedicalRecord(MedicalRecord medicalRecord) {
        // Add your validation logic here
        // For example, ensuring patientId is not negative, etc.
        if (medicalRecord.getPatientId() < 0) {
            throw new IllegalArgumentException("Patient ID cannot be negative.");
        }
    }
    
}
