/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.echannellingproject.resource;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import com.mycompany.echannellingproject.dao.PrescriptionDao;
import com.mycompany.echannellingproject.classes.Prescription;
import java.util.List;

/**
 *
 * @author hasit
 */


@Path("/prescriptions")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PrescriptionResource {
    
    // Create a new prescription
    @POST
    public Response addPrescription(Prescription prescription, @Context UriInfo uriInfo) {
        int id = PrescriptionDao.addPrescription(prescription);
        UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
        uriBuilder.path(Integer.toString(id));
        return Response.created(uriBuilder.build()).build();
    }

    // Get all prescriptions
    @GET
    public List<Prescription> getAllPrescriptions() {
        return PrescriptionDao.getAllPrescriptions();
    }

    // Get prescription by ID
    @GET
    @Path("/{id}")
    public Response getPrescriptionById(@PathParam("id") int id) {
        Prescription prescription = PrescriptionDao.getPrescriptionById(id);
        if (prescription != null) {
            return Response.ok(prescription).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    // Update a prescription
    @PUT
    @Path("/{id}")
    public Response updatePrescription(@PathParam("id") int id, Prescription updatedPrescription) {
        try {
            PrescriptionDao.updatePrescription(id, updatedPrescription);
            return Response.noContent().build();
        } catch (IllegalArgumentException ex) {
            return Response.status(Response.Status.NOT_FOUND).entity(ex.getMessage()).build();
        }
    }

    // Delete a prescription
    @DELETE
    @Path("/{id}")
    public Response deletePrescription(@PathParam("id") int id) {
        try {
            PrescriptionDao.deletePrescription(id);
            return Response.noContent().build();
        } catch (IllegalArgumentException ex) {
            return Response.status(Response.Status.NOT_FOUND).entity(ex.getMessage()).build();
        }
    }
}

