/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.echannellingproject.resource;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import com.mycompany.echannellingproject.dao.PersonDao;
import com.mycompany.echannellingproject.classes.Person;
import java.util.List;

/**
 *
 * @author hasit
 */


@Path("/persons")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class PersonResource {
    
    // Get all persons
    @GET
    public List<Person> getAllPersons() {
        return PersonDao.getAllPersons();
    }

    // Get person by ID
    @GET
    @Path("/{id}")
    public Response getPersonById(@PathParam("id") int id) {
        Person person = PersonDao.getPersonById(id);
        if (person != null) {
            return Response.ok(person).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
    // Create a new person
    @POST
    public Response addPerson(Person person, @Context UriInfo uriInfo) {
        PersonDao.validatePerson(person);
        int id = PersonDao.addPerson(person);
        UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
        uriBuilder.path(Integer.toString(id));
        return Response.created(uriBuilder.build()).build();
    }
    
    

    // Update a person
    @PUT
    @Path("/{id}")
    public Response updatePerson(@PathParam("id") int id, Person updatedPerson) {
        Person existingPerson = PersonDao.getPersonById(id);
        if (existingPerson != null) {
            PersonDao.updatePerson(id, updatedPerson);
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    // Delete a person
    @DELETE
    @Path("/{id}")
    public Response deletePerson(@PathParam("id") int id) {
        Person existingPerson = PersonDao.getPersonById(id);
        if (existingPerson != null) {
            PersonDao.deletePerson(id);
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}

