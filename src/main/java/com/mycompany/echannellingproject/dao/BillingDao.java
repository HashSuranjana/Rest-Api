/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.echannellingproject.dao;

import com.mycompany.echannellingproject.classes.Billing;
import com.mycompany.echannellingproject.classes.Patient;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hasit
 */
public class BillingDao {
    
    private static final Logger LOGGER = Logger.getLogger(BillingDao.class.getName());
    private static final ArrayList<Billing> billingRecords = new ArrayList<>();
    
    static {
        Patient patient1 = new Patient(1978, "Karan Johar", "417806612", "karanJ@gmail.com", "No.12,main street,colombo", "Heart Patient", "Treatment-continuing");
        Patient patient2 = new Patient(1123, "Hrithik Roshan", "418769634", "hrithikro@gmail.com", "sinha pl,Koswatta,Colombo", "Back pain Patient", "Treatment-Not-Continuing");
        Patient patient3 = new Patient(2001, "Amal Perera", "413254709", "amalP12@gmail.com", "'Amal',godagama,colombo", "Heat Patient", "Treatment-continuing");

    
        Billing example1 = new Billing(111, 100.0, LocalDate.of(2024, 5, 10), true,patient1);
        Billing example2 = new Billing(222, 150.0, LocalDate.of(2024, 5, 11), false,patient2);
        Billing example3 = new Billing(356, 200.0, LocalDate.of(2024, 5, 12), true,patient3);
    
        billingRecords.add(example1);
        billingRecords.add(example2);
        billingRecords.add(example3);
    }

    // Create
    public List<Billing> getAllBills() {
        try {
            return billingRecords;
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Error occurred while retrieving all Bills: " + ex.getMessage(), ex);
            throw new BillingDaoException("Error retrieving all Bills", ex);
        }
    }

    public Billing getBillById(int bill_id) {
        try {
            for (Billing appointment : billingRecords) {
                if (appointment.getBill_Id()== bill_id) {
                    return appointment;
                }
            }
            return null;
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Error occurred while retrieving Bill by ID: " + ex.getMessage(), ex);
            throw new BillingDaoException("Error retrieving Bill by ID", ex);
        }
    }

    public void addBill(Billing bill) {
        try {
            billingRecords.add(bill);
            LOGGER.log(Level.INFO, "New Bill added: " + bill);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Error occurred while adding Bill: " + ex.getMessage(), ex);
            throw new BillingDaoException("Error adding Bill", ex);
        }
    }

    public void updateBill(Billing updatedBill) {
        try {
            for (int i = 0; i < billingRecords.size(); i++) {
                if (billingRecords.get(i).getBill_Id() == updatedBill.getBill_Id()) {
                    billingRecords.set(i, updatedBill);
                    LOGGER.log(Level.INFO, "Bill updated: " + updatedBill);
                    return;
                }
            }
            LOGGER.log(Level.SEVERE, "Bill not found with ID: " + updatedBill.getBill_Id());
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Error occurred while updating Bill: " + ex.getMessage(), ex);
            throw new BillingDaoException("Error updating Bill", ex);
        }
    }

    public void deleteBill(int billId) {
        try {
            billingRecords.removeIf(billing -> billing.getBill_Id()== billId);
            LOGGER.log(Level.INFO, "Bill deleted with ID: " + billId);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Error occurred while deleting Bill: " + ex.getMessage(), ex);
            throw new BillingDaoException("Error deleting Bill", ex);
        }
    }

    // Custom exception class for AppointmentDao
    public static class BillingDaoException extends RuntimeException {
        public BillingDaoException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    // Exception Handling and Validation
    public static void validateBillingRecord(Billing billingRecord) {
        // Add your validation logic here
        // For example, ensuring amount is not negative, date is not null, etc.
        if (billingRecord.getPrice()< 0) {
            throw new IllegalArgumentException("Amount cannot be negative.");
        }
        if (billingRecord.getDate() == null) {
            throw new IllegalArgumentException("Date cannot be null.");
        }
        
    }
    
}
