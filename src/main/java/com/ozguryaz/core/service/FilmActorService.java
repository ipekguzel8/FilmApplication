package com.ozguryaz.core.service;

import com.ozguryaz.core.dao.FilmActorDao;
import com.ozguryaz.core.domain.Actor;
import com.ozguryaz.core.domain.Film;
import com.ozguryaz.core.domain.FilmActor;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class FilmActorService extends BaseService<FilmActor, FilmActorDao> {

    public FilmActorService() {
        super(FilmActorDao.class);
    }

    public void save (List<FilmActor> musteriUrunList) {
        getDao().saveFilmActor(musteriUrunList);
    }

    public List<Actor> findByActorId(Long actorId) {
        return getDao().findByActorId(actorId);
    }
    public List<FilmActor> findAllActor(Film film){
        return getDao().findAllActor(film);
    }
}