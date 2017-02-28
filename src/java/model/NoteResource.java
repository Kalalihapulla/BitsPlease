/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Izymi
 */
@Path("note")
public class NoteResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of NoteResource
     */
    public NoteResource() {
    }

    /**
     * Retrieves representation of an instance of model.NoteResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Note getText() {
        //TODO return proper representation object
        return new Note("lul", Urgency.HIGH);
    }

    /**
     * PUT method for updating or creating an instance of NoteResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.TEXT_PLAIN)
    public void putText(String content) {
    }
}
