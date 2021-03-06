/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Util.HibernateStuff;
import static java.util.Collections.list;
import java.util.Iterator;
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
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;




/**Message REST
 * 
 * @author Himel
 */
@Stateless
@Path("model.message")
public class MessageFacadeREST extends AbstractFacade<Message> {

    @PersistenceContext(unitName = "ProjectTestUDPU")
    private EntityManager em;
    private final RestHelper restHelper;
    private SessionFactory sessionFactory;

    public MessageFacadeREST() {
        super(Message.class);
        this.restHelper = new RestHelper();
    }
    
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN})
    @Override
    public void create(Message message) {
        UserAccount user1 = restHelper.getUserByEmail(message.getSender());
        UserAccount user2 = restHelper.getUserByEmail(message.getReceiver());

        this.sessionFactory = HibernateStuff.getInstance().getSessionFactory();
        Session session
                = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            UserAccount userAccount1 = new UserAccount();
            UserAccount userAccount2 = new UserAccount();
            if (!user1.getEmail().equals("unknown")) {
                userAccount1
                        = (UserAccount) session.get(UserAccount.class, user1.getId());
            }
            if (!user1.getEmail().equals("unknown")) {
                userAccount2
                        = (UserAccount) session.get(UserAccount.class, user2.getId());
            }

            userAccount1.addMessage(message);
            userAccount2.addMessage(message);
            session.saveOrUpdate(message);
            if (!userAccount1.getEmail().equals("unknown")) {
                session.update(userAccount1);
            }
            if (!userAccount1.getEmail().equals("unknown")) {
                session.update(userAccount2);
            }

            tx.commit();
           
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {

        }

    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Long id, Message entity) {
        super.edit(entity);
    }
    /**
     * Removes messages
     * @param msgid Message id which is used the remove it.
     * @param email Email of the user who the message is removed from.
     *  
     */

    @DELETE
    @Path("delete/{msgid}/{email}")
    public void remove(@PathParam("msgid") Long msgid, @PathParam("email") String email) {
        this.sessionFactory = HibernateStuff.getInstance().getSessionFactory();
        Session session
                = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            UserAccount ua = this.restHelper.getUserByEmail(email);
            UserAccount update = (UserAccount) session.get(UserAccount.class, ua.getId());
            List<Message> messages = update.getMessages();
            for (Iterator<Message> iter = messages.listIterator(); iter.hasNext();) {
                Long a = iter.next().getId();
                if (a == msgid) {
                    iter.remove();
                }
            }
           

             update.setMessages(messages);
          
            session.update(update);
            tx.commit();
         
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {

        }

    }
/**
 * Returns message by id.
 * @param id Message id.
 * @return Message object.
 */
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Message find(@PathParam("id") Long id) {
        this.sessionFactory = HibernateStuff.getInstance().getSessionFactory();
        Session session
                = sessionFactory.openSession();

        Message message
                = (Message) session.get(Message.class, id);

        return message;
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
