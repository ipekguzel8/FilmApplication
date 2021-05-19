package com.ozguryaz.core.dao;

import com.ozguryaz.core.domain.Actor;
import com.ozguryaz.core.domain.Film;
import com.ozguryaz.core.domain.FilmActor;
import com.ozguryaz.core.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class FilmActorDao extends BaseDao<FilmActor> {

    public FilmActorDao() {
        super(FilmActor.class);
    }

    public void saveFilmActor(List<FilmActor> musteriUrunList) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            for (FilmActor filmActor : musteriUrunList) {
                session.merge(filmActor);
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void saveFilmActor(FilmActor filmActor) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(filmActor);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Actor> findByActorId(Long actorId) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            String hql =
                    "Select     actor.name " +
                            "From       Actor actor " +
                            "where      actor.id = :actorId ";
            Query query = session.createQuery(hql);
            query.setParameter("actorId", actorId);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<FilmActor> findAllActor(Film film) {
        Long Id= film.getId();
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            String hql = "Select filmActor " +
                    "From FilmActor filmActor " +
                    "where  filmActor .film.id=" + Id+"";
            Query query = session.createQuery(hql);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;

    }
}
