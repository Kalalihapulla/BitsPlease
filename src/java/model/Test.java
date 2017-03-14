package model;

import Util.HibernateStuff;
import java.util.ArrayList;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import service.MessageFacadeREST;
import service.NoteFacadeREST;
import service.UserAccountFacadeREST;

public class Test {

    public static void main(String[] args) {

//        UserAccountFacadeREST accountFacadeREST = new UserAccountFacadeREST();
//        accountFacadeREST.create(new UserAccount());
//        MessageFacadeREST eST = new MessageFacadeREST();
//        eST.create(new Message("test", "admint", "helllo"));
        //populate();
//        MessageFacadeREST eST =new MessageFacadeREST();
//        Long lul = 2L;       
//        eST.remove(lul, "test@ulu");

//populate();

//        UserAccountFacadeREST accountFacadeREST = new UserAccountFacadeREST();
//        accountFacadeREST.findAll();
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

        populate();

    }

    public static void updatePassword(Long UserAccountID, String password) {
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

    /**
     * Populates the database with a bunch of data to be tested with.
     */
    public static void populate() {
        Note note1 = new Note();
        Note note2 = new Note("Stop the robbery", 2, "Janitor");
        Note note3 = new Note();
        Note note4 = new Note("Take out the garbage", 0, "Janitor");

        ArrayList<Note> notes = new ArrayList<>();
        ArrayList<Note> notes2 = new ArrayList<>();
        ArrayList<Message> m1 = new ArrayList<>();
        ArrayList<Message> m2 = new ArrayList<>();
        notes.add(note1);
        notes.add(note2);
        notes.add(note3);
        notes.add(note4);
        UserAccount user = new UserAccount("test@ulu", "kapap", "JANITOR", "Kappa", "Keepo");
        AdminAccount aduser = new AdminAccount("admint@koppa", "admin", "MANAGEMENT", "Kala", "Kukko");
        UserAccount ua = new UserAccount();
        Message message1 = new Message("lul@ulu", "Gret@bo", "Hello", "HI");
        Message message2 = new Message("gebbo", "ttt", "elelll", "lko");
        Message message3 = new Message("gobbos", "way", "auuu", "llls");
        m1.add(message3);
        m1.add(message2);
        m2.add(message2);

        user.setMessages(m2);

        aduser.setMessages(m1);
        SessionFactory sessionFactory = HibernateStuff.getInstance().getSessionFactory();
        Session session
                = sessionFactory.openSession();
        session.beginTransaction();
        Note note12 = new Note("Fill the shelves", 1, "Janitor");
        Note note124 = new Note("Drink coffee", 0, "Janitor");
        notes2.add(note12);
        user.setNotes(notes);
        aduser.setNotes(notes2);
        session.saveOrUpdate(note12);
        session.saveOrUpdate(note1);
        session.saveOrUpdate(new Note("Go home", 2, "Janitor"));
        session.saveOrUpdate(note2);
        session.saveOrUpdate(note3);
        session.saveOrUpdate(note124);
        session.saveOrUpdate(message1);
        session.saveOrUpdate(message2);
        session.saveOrUpdate(message3);
        session.saveOrUpdate(ua);
        session.saveOrUpdate(user);
        session.saveOrUpdate(aduser);
        session.getTransaction().commit();
    }
}
