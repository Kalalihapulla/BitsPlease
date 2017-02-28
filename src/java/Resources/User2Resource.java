/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Resources;

import Util.HibernateStuff;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import model.UserAccount;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * REST Web Service
 *
 * @author Izymi
 */
@Path("user2")
public class User2Resource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of User2Resource
     */
    public User2Resource() {
    }

    /**
     * Retrieves representation of an instance of Resources.User2Resource
     *
     * @return an instance of java.lang.String
     */
    @GET
    
    @Produces(MediaType.APPLICATION_XML)
    public UserAccount getXml() {
         SessionFactory sessionFactory = HibernateStuff.getInstance().getSessionFactory();
        Session session
                = sessionFactory.openSession();

        Long id = 1L;

        UserAccount userAccount
                = (UserAccount) session.get(UserAccount.class, id);

        return userAccount;
        //TODO return proper representation object
        //return new UserAccount("dd", "dd");
    }

    /**
     * PUT method for updating or creating an instance of User2Resource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}
