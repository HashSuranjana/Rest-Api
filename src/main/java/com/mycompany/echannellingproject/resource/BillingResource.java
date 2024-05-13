/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.echannellingproject.resource;

import com.mycompany.echannellingproject.dao.BillingDao;
import com.mycompany.echannellingproject.classes.Billing;
import com.mycompany.echannellingproject.classes.Patient;

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
    
    Patient patient1 = new Patient(1978, "Karan Johar", "417806612", "karanJ@gmail.com", "No.12,main street,colombo", "Heart Patient", "Treatment-continuing");
    Patient patient2 = new Patient(1123, "Hrithik Roshan", "418769634", "hrithikro@gmail.com", "sinha pl,Koswatta,Colombo", "Back pain Patient", "Treatment-Not-Continuing");
    Patient patient3 = new Patient(2001, "Amal Perera", "413254709", "amalP12@gmail.com", "'Amal',godagama,colombo", "Heat Patient", "Treatment-continuing");

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
            return Response.status(Response.Status.NOT_FOUND).entity("Billing record could not found").build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response updateBillingRecord(@PathParam("id") int id, Billing updatedRecord) {
        updatedRecord.setBill_Id(id);
        billingDao.updateBillingRecord(updatedRecord);
        return Response.ok().entity("Bill record updated").build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteBillingRecord(@PathParam("id") int id) {
        billingDao.deleteBillingRecord(id);
        return Response.ok().entity("Bill record deleted").build();
    }

    @GET
    @Path("/data")
    public List<Billing> getExampleBillingRecords() {
        
        
        // Return three example billing records
        Billing example1 = new Billing(111, 100.0, LocalDate.of(2024, 5, 10), true,patient1);
        Billing example2 = new Billing(222, 150.0, LocalDate.of(2024, 5, 11), false,patient2);
        Billing example3 = new Billing(356, 200.0, LocalDate.of(2024, 5, 12), true,patient3);
        return List.of(example1, example2, example3);
    }
}

