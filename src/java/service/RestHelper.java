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
 * Gives rest classes additional functionality
 * @author Himel
 */
public class RestHelper {

    private SessionFactory sessionFactory;
/**
 * return user by email
 * @param email user's email
 * @return user
 */
    public UserAccount getUserByEmail(String email) {

        List<UserAccount> users = findAll();
        for (UserAccount user : users) {
            if (user.getEmail().equals(email)) {
                return user;

            }

        }
        return new UserAccount();

    }
/**
 * All users
 * @return list of users
 */
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
/**
 * Checks if email exists
 * @param ua user which is tested
 * @return boolean
 */
    public boolean checkEmail(UserAccount ua) {
        List<UserAccount> users = findAll();
        for (UserAccount user : users) {
            if (user.getEmail().equals(ua.getEmail())) {
                return false;

            }
        }
        return true;
    }
}
