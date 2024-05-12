/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.echannellingproject.dao;

import com.mycompany.echannellingproject.classes.Billing;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author hasit
 */
public class BillingDao {
    
    private static final Map<Integer, Billing> billingRecords = new HashMap<>();
    private static int nextId = 1;

    // Create
    public static int addBillingRecord(Billing billingRecord) {
        validateBillingRecord(billingRecord);
        billingRecord.setBill_Id(nextId++);
        billingRecords.put(billingRecord.getBill_Id(), billingRecord);
        return billingRecord.getBill_Id();
    }

    // Read
    public static Billing getBillingRecordById(int id) {
        return billingRecords.get(id);
    }

    // Update
    public static void updateBillingRecord(Billing updatedRecord) {
        if (billingRecords.containsKey(updatedRecord.getBill_Id())) {
            billingRecords.put(updatedRecord.getBill_Id(), updatedRecord);
        } else {
            throw new IllegalArgumentException("Billing record with ID " + updatedRecord.getBill_Id()+ " does not exist.");
        }
    }

    // Delete
    public static void deleteBillingRecord(int id) {
        if (billingRecords.containsKey(id)) {
            billingRecords.remove(id);
        } else {
            throw new IllegalArgumentException("Billing record with ID " + id + " does not exist.");
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
        // Additional validations can be added as needed
    }
    
}
