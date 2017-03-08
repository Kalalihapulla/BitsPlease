/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Util.HibernateStuff;
import java.util.ArrayList;
import java.util.List;
import model.UserAccount;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Izymi
 */
public class RestHelper {

    private SessionFactory sessionFactory;

    public UserAccount getUserByEmail(String email) {

        List<UserAccount> users = findAll();
        for (UserAccount user : users) {
            if (user.getEmail().equals(email)) {
                return user;

            }

        }
        return null;

    }

    public List<UserAccount> findAll() {

        this.sessionFactory = HibernateStuff.getInstance().getSessionFactory();
        Session session
                = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(UserAccount.class);

        List users = criteria.list();
        List<UserAccount> allusers = new ArrayList();
        users.forEach((user) -> {
            UserAccount user1 = (UserAccount) user;
            allusers.add(user1);

        });
        System.out.println(allusers);
        return allusers;

    }
}
