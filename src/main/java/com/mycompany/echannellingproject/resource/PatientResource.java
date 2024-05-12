/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.echannellingproject.resource;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import com.mycompany.echannellingproject.dao.PatientDao;
import com.mycompany.echannellingproject.classes.Patient;
import java.util.List;

/**
 *
 * @author hasit
 */


@Path("/patients")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class PatientResource {
    
    // Create a new patient
    @POST
    public Response addPatient(Patient patient, @Context UriInfo uriInfo) {
        int id = PatientDao.addPatient(patient);
        UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
        uriBuilder.path(Integer.toString(id));
        return Response.created(uriBuilder.build()).build();
    }

    // Get all patients
    @GET
    public List<Patient> getAllPatients() {
        return PatientDao.getAllPatients();
    }

    // Get patient by ID
    @GET
    @Path("/{id}")
    public Response getPatientById(@PathParam("id") int id) {
        Patient patient = PatientDao.getPatientById(id);
        if (patient != null) {
            return Response.ok(patient).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    // Update a patient
    @PUT
    @Path("/{id}")
    public Response updatePatient(@PathParam("id") int id, Patient updatedPatient) {
        try {
            PatientDao.updatePatient(id, updatedPatient);
            return Response.noContent().build();
        } catch (IllegalArgumentException ex) {
            return Response.status(Response.Status.NOT_FOUND).entity(ex.getMessage()).build();
        }
    }

    // Delete a patient
    @DELETE
    @Path("/{id}")
    public Response deletePatient(@PathParam("id") int id) {
        try {
            PatientDao.deletePatient(id);
            return Response.noContent().build();
        } catch (IllegalArgumentException ex) {
            return Response.status(Response.Status.NOT_FOUND).entity(ex.getMessage()).build();
        }
    }
}

