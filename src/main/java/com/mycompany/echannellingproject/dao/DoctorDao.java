/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.echannellingproject.dao;

import com.mycompany.echannellingproject.classes.Doctor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author hasit
 */


public class DoctorDao extends PersonDao {

    private static Map<Integer, Doctor> doctors = new HashMap<>();
    private static int nextId = 1;

    // Create
    public static int addDoctor(Doctor doctor) {
        validateDoctor(doctor);
        doctor.setPerson_id(nextId++);
        doctors.put(doctor.getPerson_id(), doctor);
        return doctor.getPerson_id();
    }

    // Read
    public static Doctor getDoctorById(int id) {
        return doctors.get(id);
    }

    public static List<Doctor> getAllDoctors() {
        return new ArrayList<>(doctors.values());
    }

    // Update
    public static void updateDoctor(int id, Doctor updatedDoctor) {
        if (doctors.containsKey(id)) {
            validateDoctor(updatedDoctor);
            updatedDoctor.setPerson_id(id);
            doctors.put(id, updatedDoctor);
        } else {
            throw new IllegalArgumentException("Doctor with ID " + id + " does not exist.");
        }
    }

    // Delete
    public static void deleteDoctor(int id) {
        if (doctors.containsKey(id)) {
            doctors.remove(id);
        } else {
            throw new IllegalArgumentException("Doctor with ID " + id + " does not exist.");
        }
    }

    // Exception Handling and Validation
    public static void validateDoctor(Doctor doctor) {
        validatePerson(doctor); // Utilize parent class method for basic validation
        // Additional validation specific to Doctor class can be added here
        if (doctor.getSpecialized() == null || doctor.getSpecialized().isEmpty()) {
            throw new IllegalArgumentException("Specialization cannot be empty.");
        }
        // Similarly, validate other fields like contacts
    }
}

