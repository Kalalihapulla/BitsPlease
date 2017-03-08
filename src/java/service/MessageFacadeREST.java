/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Util.HibernateStuff;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import model.Message;
import model.UserAccount;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Izymi
 */
@Stateless
@Path("model.message")
public class MessageFacadeREST extends AbstractFacade<Message> {

    @PersistenceContext(unitName = "ProjectTestUDPU")
    private EntityManager em;
    private RestHelper restHelper;
    private SessionFactory sessionFactory;

    public MessageFacadeREST() {
        super(Message.class);
    }

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN})
//    public void createM(Message entity,String sender, String receiver) {
//        UserAccount user1 = restHelper.getUserByEmail(sender);
//        UserAccount user2 = restHelper.getUserByEmail(receiver);
//            this.sessionFactory = HibernateStuff.getInstance().getSessionFactory();
//        Session session
//                = sessionFactory.openSession();
//        session.beginTransaction();
//        session.saveOrUpdate(entity);
//        session.getTransaction().commit();
//        
//       
//    }

    @Override
    public void create(Message entity) {
        super.create(entity); //To change body of generated methods, choose Tools | Templates.
    }
    

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Long id, Message entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Message find(@PathParam("id") Long id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Message> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Message> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
