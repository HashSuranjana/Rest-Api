/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.echannellingproject.classes;

/**
 *
 * @author hasit
 */
public class Prescription {
    private int pres_Id;
    private String medication;
    private String dose;
    private String instructions;
    private String duration;

    public Prescription() {
    }

    public Prescription(int pres_Id, String medication, String dose, String instructions, String duration) {
        this.pres_Id = pres_Id;
        this.medication = medication;
        this.dose = dose;
        this.instructions = instructions;
        this.duration = duration;
    }

    public int getPres_Id() {
        return pres_Id;
    }

    public void setPres_Id(int pres_Id) {
        this.pres_Id = pres_Id;
    }

    public String getMedication() {
        return medication;
    }

    public void setMedication(String medication) {
        this.medication = medication;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Prescription{" + "pres_Id=" + pres_Id + ", medication=" + medication + ", dose=" + dose + ", instructions=" + instructions + ", duration=" + duration + '}';
    }
    
    
}
