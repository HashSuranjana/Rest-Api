/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.echannellingproject.resource;

import com.mycompany.echannellingproject.dao.AppoinmentDao;
import com.mycompany.echannellingproject.classes.Appoinment;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 *
 * @author hasit
 */



@Path("/appointments")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AppoinmentResource {

    private final AppoinmentDao appoinmentDao = new AppoinmentDao();

    @GET
    public List<Appoinment> getAllAppointments() {
        return appoinmentDao.getAllAppointments();
    }

    @GET
    @Path("/{id}")
    public Response getAppointmentById(@PathParam("id") int id) {
        Appoinment appointment = appoinmentDao.getAppointmentById(id);
        if (appointment != null) {
            return Response.ok(appointment).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Appointment not found").build();
        }
    }

    @POST
    public Response addAppointment(Appoinment appointment) {
        appoinmentDao.addAppointment(appointment);
        return Response.status(Response.Status.CREATED).entity("New appointment added").build();
    }

    @PUT
    @Path("/{id}")
    public Response updateAppointment(@PathParam("id") int id, Appoinment updatedAppointment) {
        Appoinment existingAppointment = appoinmentDao.getAppointmentById(id);
        if (existingAppointment != null) {
            updatedAppointment.setAppointment_Id(id);
            appoinmentDao.updateAppointment(updatedAppointment);
            return Response.ok().entity("Appointment updated").build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Appointment not found").build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteAppointment(@PathParam("id") int id) {
        appoinmentDao.deleteAppointment(id);
        return Response.ok().entity("Appointment deleted").build();
    }
}

