/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.echannellingproject.resource;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import com.mycompany.echannellingproject.dao.DoctorDao;
import com.mycompany.echannellingproject.classes.Doctor;
import java.util.List;

/**
 *
 * @author hasit
 */


@Path("/doctors")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DoctorResource {
    
    // Create a new doctor
    @POST
    public Response addDoctor(Doctor doctor, @Context UriInfo uriInfo) {
        int id = DoctorDao.addDoctor(doctor);
        UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
        uriBuilder.path(Integer.toString(id));
        return Response.created(uriBuilder.build()).build();
    }

    // Get all doctors
    @GET
    public List<Doctor> getAllDoctors() {
        return DoctorDao.getAllDoctors();
    }

    // Get doctor by ID
    @GET
    @Path("/{id}")
    public Response getDoctorById(@PathParam("id") int id) {
        Doctor doctor = DoctorDao.getDoctorById(id);
        if (doctor != null) {
            return Response.ok(doctor).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    // Update a doctor
    @PUT
    @Path("/{id}")
    public Response updateDoctor(@PathParam("id") int id, Doctor updatedDoctor) {
        try {
            DoctorDao.updateDoctor(id, updatedDoctor);
            return Response.noContent().build();
        } catch (IllegalArgumentException ex) {
            return Response.status(Response.Status.NOT_FOUND).entity(ex.getMessage()).build();
        }
    }

    // Delete a doctor
    @DELETE
    @Path("/{id}")
    public Response deleteDoctor(@PathParam("id") int id) {
        try {
            DoctorDao.deleteDoctor(id);
            return Response.noContent().build();
        } catch (IllegalArgumentException ex) {
            return Response.status(Response.Status.NOT_FOUND).entity(ex.getMessage()).build();
        }
    }
}

