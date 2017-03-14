/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Resources.Validate;
import Util.HibernateStuff;
import java.util.ArrayList;
import java.util.Collections;
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
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Izymi
 * User REST
 */
@Stateless
@Path("model.useraccount")
public class UserAccountFacadeREST extends AbstractFacade<UserAccount> {

    private SessionFactory sessionFactory;
    private RestHelper restHelper;
    @PersistenceContext(unitName = "ProjectTestUDPU")
    private EntityManager em;

    public UserAccountFacadeREST() {
        super(UserAccount.class);
        this.restHelper = new RestHelper();
    }
/**
 * 
 * Consumes user xml. And creates a new account.
 * @param entity The new user.
 */
    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(UserAccount entity) {
        this.sessionFactory = HibernateStuff.getInstance().getSessionFactory();
        Session session
                = sessionFactory.openSession();
        if (this.restHelper.checkEmail(entity)) {
            session.beginTransaction();
            session.saveOrUpdate(entity);
            session.getTransaction().commit();

        }

    }
/**
 * Updates user
 * @param id User's id
 * @param entity The new user.
 */
    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Long id, UserAccount entity) {
        this.sessionFactory = HibernateStuff.getInstance().getSessionFactory();
        Session session
                = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(entity);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {

        }

    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));
    }
    /**
     * GET user
     * @param id user's id
     * @return user which is returned
     */
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML})
    public UserAccount find(@PathParam("id") Long id) {
        this.sessionFactory = HibernateStuff.getInstance().getSessionFactory();
        Session session
                = sessionFactory.openSession();

        UserAccount userAccount
                = (UserAccount) session.get(UserAccount.class, id);

        return userAccount;
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<UserAccount> findAll() {
        return this.restHelper.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<UserAccount> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }
    /**
     * User by email
     * @param email The user's email
     * @return Wanted user
     */
    @POST
    @Path("userByEmail")
    @Consumes({MediaType.TEXT_PLAIN})
    @Produces(MediaType.APPLICATION_XML)
    public UserAccount getUser(String email) {
        UserAccount ua = restHelper.getUserByEmail(email);
        List<Message> messages = ua.getMessages();
        Collections.reverse(messages);
        ua.setMessages(messages);
        return ua;

    }
    /**
     * Updates user
     * @param account User
     */
    @POST
    @Path("userByEmail")
    @Consumes(MediaType.APPLICATION_XML)
    public void userUD(UserAccount account) {
        this.sessionFactory = HibernateStuff.getInstance().getSessionFactory();
        Session session
                = sessionFactory.openSession();

        session.beginTransaction();
        session.update(account);
        session.getTransaction().commit();

    }
/*'
    Validates user and password.
    */
    @GET
    @Path("userPassCheck/{email}/{password}")
    @Produces(MediaType.TEXT_PLAIN)
    public boolean checkPassword(@PathParam("email") String email, @PathParam("password") String password) {
        Validate validate = new Validate();
        return validate.checkUser(email, password);
    }
   /**
    * Check if email is registered
    * @param email Email that is to be checked.
    * @return true or false
    */
    @POST
    @Path("signup")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.TEXT_PLAIN)
    public boolean signupCheck(String email) {
        UserAccount account = new UserAccount();
        account.setEmail(email);
        return !this.restHelper.checkEmail(account);

    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    /**
     * Return user's job
     * @param email user's email
     * @return job description
     */
    @GET
    @Path("userJob/{email}")
    @Consumes(MediaType.TEXT_PLAIN)
    public String userJob(@PathParam("email")String email) {
       return this.restHelper.getUserByEmail(email).getJobDescription();
        
    }


}
