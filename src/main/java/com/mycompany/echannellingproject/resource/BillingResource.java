/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.echannellingproject.resource;

import com.mycompany.echannellingproject.dao.BillingDao;
import com.mycompany.echannellingproject.classes.Billing;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 *
 * @author hasit
 */



@Path("/billing")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BillingResource {

    private final BillingDao billingDao = new BillingDao();

    @GET
    public List<Billing> getAllAppointments() {
        return billingDao.getAllBills();
    }

    @GET
    @Path("/{id}")
    public Response getAppointmentById(@PathParam("id") int id) {
        Billing bills = billingDao.getBillById(id);
        if (bills != null) {
            return Response.ok(bills).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Bill not found").build();
        }
    }

    @POST
    public Response addBill(Billing bills) {
        billingDao.addBill(bills);
        return Response.status(Response.Status.CREATED).entity("New Bill added").build();
    }

    @PUT
    @Path("/{id}")
    public Response updateAppointment(@PathParam("id") int id, Billing updatedBill) {
        Billing existingBill = billingDao.getBillById(id);
        if (existingBill != null) {
            updatedBill.setBill_Id(id);
            billingDao.updateBill(updatedBill);
            return Response.ok().entity("Bill updated").build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Bill not found").build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteAppointment(@PathParam("id") int id) {
        billingDao.deleteBill(id);
        return Response.ok().entity("Bill deleted").build();
    }
}

