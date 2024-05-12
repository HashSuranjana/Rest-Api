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
import java.time.LocalDate;
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

    @POST
    public Response addBillingRecord(Billing billingRecord) {
        int id = billingDao.addBillingRecord(billingRecord);
        return Response.status(Response.Status.CREATED).entity("Billing record added with ID: " + id).build();
    }

    @GET
    @Path("/{id}")
    public Response getBillingRecordById(@PathParam("id") int id) {
        Billing billingRecord = billingDao.getBillingRecordById(id);
        if (billingRecord != null) {
            return Response.ok(billingRecord).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Billing record not found").build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response updateBillingRecord(@PathParam("id") int id, Billing updatedRecord) {
        updatedRecord.setBill_Id(id);
        billingDao.updateBillingRecord(updatedRecord);
        return Response.ok().entity("Billing record updated").build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteBillingRecord(@PathParam("id") int id) {
        billingDao.deleteBillingRecord(id);
        return Response.ok().entity("Billing record deleted").build();
    }

    @GET
    @Path("/examples")
    public List<Billing> getExampleBillingRecords() {
        // Return three example billing records
        Billing example1 = new Billing(1, 100.0, LocalDate.of(2024, 5, 10), true);
        Billing example2 = new Billing(2, 150.0, LocalDate.of(2024, 5, 11), false);
        Billing example3 = new Billing(3, 200.0, LocalDate.of(2024, 5, 12), true);
        return List.of(example1, example2, example3);
    }
}

