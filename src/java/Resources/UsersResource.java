/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Resources;

import Util.HibernateStuff;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.json.*;
import model.UserAccount;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * REST Web Service
 *
 * @author Izymi
 */
@Path("/users")
public class UsersResource {

    private SessionFactory sessionFactory;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of UsersResource
     */
    public UsersResource() {
    }

    /**
     * Retrieves representation of an instance of model.UsersResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List getUsers() {

        this.sessionFactory = HibernateStuff.getInstance().getSessionFactory();
        Session session
                = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(UserAccount.class);
        criteria.setMaxResults(7);
        List users = criteria.list();
        List<UserAccount> allusers = new ArrayList();
        users.forEach((user) -> {
            UserAccount user1 = (UserAccount) user;
            allusers.add(user1);

        });
        return allusers;
    }

    @Path("/one")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public UserAccount getOneUser() {

        SessionFactory sessionFactory = HibernateStuff.getInstance().getSessionFactory();
        Session session
                = sessionFactory.openSession();

        Long id = 1L;

        UserAccount userAccount
                = (UserAccount) session.get(UserAccount.class, id);

        return userAccount;
    }

    //    @POST
    //    @Consumes(MediaType.TEXT_PLAIN)
    //    @Produces(MediaType.APPLICATION_XML)
    //    public String updateUser() {
    //
    //        //TODO return proper representation object
    //        throw new UnsupportedOperationException();
    //    }
    /**
     * PUT method for updating or creating an instance of UsersResource
     *
     * @param content representation for the resource
     */
    //    @PUT
    //    @Consumes(MediaType.APPLICATION_XML)
    //    public void putXml(String content) {
    //    }
    @Path("/createuser")
    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public String createUser(String lul) {
       
        JsonObject body = Json.createReader(new StringReader(lul)).readObject();
        

    return "";
        //return body.getString("firstName");
    }
    
}
