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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hasit
 */

/**
 * Data Access Object class for managing doctors.
 */
public class DoctorDao extends PersonDao {

    private static final Logger LOGGER = Logger.getLogger(DoctorDao.class.getName());
    private static Map<Integer, Doctor> doctors = new HashMap<>();
    private static int nextId = 1;
    
    static{
        Doctor doctor1 = new Doctor(1, "Dr. J.Gunasena", "123987456", "gunasenaJ@gmail.com", "No.23,jakes Street,Colombo", "phycology", "email or phone");
        Doctor doctor2 = new Doctor(2, "Dr. John Doe", "2587896314", "Doe@hotmail.com", "uban city,lebonan", "Cardiologist", "email or phone");

        addDoctor(doctor1);
        addDoctor(doctor2);
    }

    // Create
    public static int addDoctor(Doctor doctor) {
        try {
            validateDoctor(doctor);
            doctor.setPerson_id(nextId++);
            doctors.put(doctor.getPerson_id(), doctor);
            return doctor.getPerson_id();
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Error occurred while adding doctor: " + ex.getMessage(), ex);
            throw new DoctorDaoException("Error adding doctor", ex);
        }
    }

    // Read
    public static Doctor getDoctorById(int id) {
        try {
            return doctors.get(id);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Error occurred while retrieving doctor: " + ex.getMessage(), ex);
            throw new DoctorDaoException("Error retrieving doctor", ex);
        }
    }

    public static List<Doctor> getAllDoctors() {
        try {
            return new ArrayList<>(doctors.values());
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Error occurred while retrieving all doctors: " + ex.getMessage(), ex);
            throw new DoctorDaoException("Error retrieving all doctors", ex);
        }
    }

    // Update
    public static void updateDoctor(int id, Doctor updatedDoctor) {
        try {
            if (doctors.containsKey(id)) {
                validateDoctor(updatedDoctor);
                updatedDoctor.setPerson_id(id);
                doctors.put(id, updatedDoctor);
            } else {
                throw new IllegalArgumentException("Doctor with ID " + id + " does not exist.");
            }
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Error occurred while updating doctor: " + ex.getMessage(), ex);
            throw new DoctorDaoException("Error updating doctor", ex);
        }
    }

    // Delete
    public static void deleteDoctor(int id) {
        try {
            if (doctors.containsKey(id)) {
                doctors.remove(id);
            } else {
                throw new IllegalArgumentException("Doctor with ID " + id + " does not exist.");
            }
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Error occurred while deleting doctor: " + ex.getMessage(), ex);
            throw new DoctorDaoException("Error deleting doctor", ex);
        }
    }

    // Exception Handling and Validation
    public static void validateDoctor(Doctor doctor) {
        try {
            validatePerson(doctor); // Utilize parent class method for basic validation
            // Additional validation specific to Doctor class can be added here
            if (doctor.getSpecialized() == null || doctor.getSpecialized().isEmpty()) {
                throw new IllegalArgumentException("Specialization cannot be empty.");
            }
            // Similarly, validate other fields like contacts
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Error occurred while validating doctor: " + ex.getMessage(), ex);
            throw new DoctorDaoException("Error validating doctor", ex);
        }
    }

    // Custom exception class for DoctorDao
    public static class DoctorDaoException extends RuntimeException {
        public DoctorDaoException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}


