package com.ozguryaz.core.dao;

import com.ozguryaz.core.domain.Actor;
import com.ozguryaz.core.domain.Film;

public class FilmDao extends BaseDao<Film> {
    public FilmDao() {
        super(Film.class);
    }
}
