/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Resources.UsersResource;
import Util.HibernateStuff;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author himelr
 */
public class Test {

    public static void main(String[] args) {

        Note note1 = new Note();
        Note note2 = new Note("lil", Urgency.HIGH);
        Note note3 = new Note();
        Note note4 = new Note("hello", Urgency.MEDIUM);

        ArrayList<Note> notes = new ArrayList<>();
        ArrayList<Note> notes2 = new ArrayList<>();
        notes.add(note1);
        notes.add(note2);
        notes.add(note3);
        notes.add(note4);
        UserAccount user = new UserAccount("test", "kapap");
        AdminAccount aduser = new AdminAccount("admint", "admin");

//        Collections.sort(notes);
//       notes.forEach((note) -> {
//           System.out.println(note.searchUrgency());
//       });
        SessionFactory sessionFactory = HibernateStuff.getInstance().getSessionFactory();
        Session session
                = sessionFactory.openSession();
        session.beginTransaction();
        Note note12 = new Note("kerk", Urgency.HIGH);
        notes2.add(note12);
        user.setNotes(notes);
        aduser.setNotes(notes2);
        session.saveOrUpdate(note12);
        session.saveOrUpdate(note1);
        session.saveOrUpdate(new Note("left", Urgency.MEDIUM));
        session.saveOrUpdate(note2);
        session.saveOrUpdate(note3);

        session.saveOrUpdate(user);
        session.saveOrUpdate(aduser);
        session.getTransaction().commit();

//        Criteria criteria = session.createCriteria(UserAccount.class);
//        criteria.setMaxResults(5);
//        List users = criteria.list();
//
//        users.forEach((user1) -> {
//            UserAccount user1 = (UserAccount) user1;
//            System.out.println(user1.getEmail());
//        });
//        String lul = "2";
//        Long ulu = Long.parseLong(lul);
//        updateUser(ulu, "lonhlhh");
//        UsersResource resource = new UsersResource();
//        System.out.println(resource.getOneUser());
    }

    public static void updateUser(Long UserAccountID, String password) {
        SessionFactory sessionFactory = HibernateStuff.getInstance().getSessionFactory();
        Session session
                = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            UserAccount userAccount
                    = (UserAccount) session.get(UserAccount.class, UserAccountID);
            userAccount.setPassword(password);
            session.update(userAccount);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {

        }
    }

}
