/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Util.HibernateStuff;
import java.util.ArrayList;
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
import model.UserAccount;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Izymi
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

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Long id, UserAccount entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));
    }

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

    @POST
    @Path("userByEmail")
    @Consumes({MediaType.TEXT_PLAIN})
    @Produces(MediaType.APPLICATION_XML)
    public UserAccount getUser(String email) {

        return this.restHelper.getUserByEmail(email);
    }

    @GET
    @Path("userByEmail")
    @Produces(MediaType.APPLICATION_XML)
    public UserAccount getUsertest() {

        return this.restHelper.getUserByEmail("admint@koppa");
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
