/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

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
import model.Note;
import model.Status;
import model.UserAccount;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Note REST
 * @author himel
 */
@Stateless
@Path("model.note")
public class NoteFacadeREST extends AbstractFacade<Note> {

    private SessionFactory sessionFactory;

    @PersistenceContext(unitName = "ProjectTestUDPU")
    private EntityManager em;

    public NoteFacadeREST() {
        super(Note.class);
    }
/**
 * Note is created.
 * @param note Note which is created.
 */
    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Note note) {
        this.sessionFactory = HibernateStuff.getInstance().getSessionFactory();
        Session session
                = sessionFactory.openSession();
        session.beginTransaction();

        session.saveOrUpdate(note);
        session.getTransaction().commit();

    }
/**
 * Updates note status
 * @param id Note id
 * @param status New status
 */
    @PUT
    @Path("{id}")
    @Consumes({MediaType.TEXT_PLAIN})
    public void editStatus(@PathParam("id") Long id, String status) {
        this.sessionFactory = HibernateStuff.getInstance().getSessionFactory();
        Session session
                = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Note note
                    = (Note) session.get(Note.class, id);

            note.setStatus(strtost(status));
            session.update(note);
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
 * Removes note by id
 * @param id Note id
 */
    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
       this.sessionFactory = HibernateStuff.getInstance().getSessionFactory();
        Session session
                = sessionFactory.openSession();
        Transaction tx = null;

        tx = session.beginTransaction();
        session.delete(find(id));
      
      
    }
/**
 * Note by id return.
 * @param id Note id 
 * @return Note with the matching id.
 */
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Note find(@PathParam("id") Long id) {
        this.sessionFactory = HibernateStuff.getInstance().getSessionFactory();
        Session session
                = sessionFactory.openSession();
        Transaction tx = null;

        tx = session.beginTransaction();
        Note note
                = (Note) session.get(Note.class, id);
        return note;
    }
/**
 * GET all notes
 * @return list of all notes.
 */
    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Note> findAll() {

        this.sessionFactory = HibernateStuff.getInstance().getSessionFactory();
        Session session
                = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Note.class);
        List notes = criteria.list();
        List<Note> allnotes = new ArrayList();
        notes.forEach((note) -> {
            Note note1 = (Note) note;
            allnotes.add(note1);

        });
        Collections.sort(allnotes);
        return allnotes;
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Note> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
/**
 * Receives a string of status and changes it.
 * @param status String of the status 
 * @return Matching enum
 */
    public static Status strtost(String status) {
        if (status.equals("STATUS_APPROVED")) {
            return Status.STATUS_APPROVED;

        }
        if (status.equals("STATUS_PROCESSING")) {
            return Status.STATUS_PROCESSING;

        }
        if (status.equals("STATUS_DONE")) {
            return Status.STATUS_DONE;

        }

        return null;

    }

}
