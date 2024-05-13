/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.echannellingproject.resource;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import com.mycompany.echannellingproject.dao.MedicalRecordDao;
import com.mycompany.echannellingproject.classes.MedicalRecord;

/**
 *
 * @author hasit
 */


@Path("/medical-records")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class MedicalRecordResource {

    // Create a new medical record
    @POST
    public Response addMedicalRecord(MedicalRecord medicalRecord, @Context UriInfo uriInfo) {
        try {
            MedicalRecordDao.addMedicalRecord(medicalRecord);
            return Response.status(Response.Status.CREATED).build();
        } catch (IllegalArgumentException ex) {
            return Response.status(Response.Status.BAD_REQUEST).entity(ex.getMessage()).build();
        }
    }

    // Get medical record by patient ID
    @GET
    @Path("/{patientId}")
    public Response getMedicalRecordByPatientId(@PathParam("patientId") int patientId) {
        MedicalRecord medicalRecord = MedicalRecordDao.getMedicalRecordByPatientId(patientId);
        if (medicalRecord != null) {
            return Response.ok(medicalRecord).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    // Update medical record
    @PUT
    public Response updateMedicalRecord(MedicalRecord updatedRecord) {
        try {
            MedicalRecordDao.updateMedicalRecord(updatedRecord);
            return Response.noContent().build();
        } catch (IllegalArgumentException ex) {
            return Response.status(Response.Status.NOT_FOUND).entity(ex.getMessage()).build();
        }
    }

    // Delete medical record by patient ID
    @DELETE
    @Path("/{patientId}")
    public Response deleteMedicalRecord(@PathParam("patientId") int patientId) {
        try {
            MedicalRecordDao.deleteMedicalRecord(patientId);
            return Response.noContent().build();
        } catch (IllegalArgumentException ex) {
            return Response.status(Response.Status.NOT_FOUND).entity(ex.getMessage()).build();
        }
    }
}

