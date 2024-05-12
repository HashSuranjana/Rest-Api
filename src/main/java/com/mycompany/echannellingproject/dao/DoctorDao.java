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
    
    static {
    
        Doctor doctor1 = new Doctor(12,"Dr. John Doe","1234567890","john@example.com","123 Street, London","Cardiologist","12344"  );
        Doctor doctor2 = new Doctor(13,"Dr. Alberto","13456782901","Alberto@example.com","134 Street, NewYork","Nuerologist","76543"  );
        Doctor doctor3 = new Doctor(14,"Dr. Tom Jackson","2345678901","TomJac@example.com","256 Street, Crossby","Phycologist","90890"  );

        addDoctor(doctor1);
        addDoctor(doctor2);
        addDoctor(doctor3);
    
    }
        
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

