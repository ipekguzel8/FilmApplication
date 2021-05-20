package com.ozguryaz.core.dao;
import com.ozguryaz.core.domain.Film;
import com.ozguryaz.core.domain.FilmActor;
import com.ozguryaz.core.domain.User;
import com.ozguryaz.core.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class UserDao extends BaseDao<User>{
    public UserDao() {
        super(User.class);
    }
    public List<User> findAllUser(User user2) {
        String username = user2.getUsername();
        String password = user2.getPassword();
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            String hql = "Select user " +
                    "From User user " +
                    "where  user.username= :username and user.password= :password";

            Query query = session.createQuery(hql);
            query.setParameter("username", username);
            query.setParameter("password", password);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
