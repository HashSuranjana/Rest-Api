/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.echannellingproject.classes;

import java.util.List;

/**
 *
 * @author hasit
 */
public class MedicalRecord {
    
    private int patientId;
    private List<String> diagnoses;
    private List<String> treatments;
    private String moreInfo;

    public MedicalRecord() {
    }

    public MedicalRecord(int patientId, List<String> diagnoses, List<String> treatments, String moreInfo) {
        this.patientId = patientId;
        this.diagnoses = diagnoses;
        this.treatments = treatments;
        this.moreInfo = moreInfo;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public List<String> getDiagnoses() {
        return diagnoses;
    }

    public void setDiagnoses(List<String> diagnoses) {
        this.diagnoses = diagnoses;
    }

    public List<String> getTreatments() {
        return treatments;
    }

    public void setTreatments(List<String> treatments) {
        this.treatments = treatments;
    }

    public String getMoreInfo() {
        return moreInfo;
    }

    public void setMoreInfo(String moreInfo) {
        this.moreInfo = moreInfo;
    }

    @Override
    public String toString() {
        return "MedicalRecord{" + "patientId=" + patientId + ", diagnoses=" + diagnoses + ", treatments=" + treatments + ", moreInfo=" + moreInfo + '}';
    }
    
    
    
}
