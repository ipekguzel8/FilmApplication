package com.ozguryaz.core.service;

import com.ozguryaz.core.dao.FilmDao;
import com.ozguryaz.core.domain.Film;

public class FilmService extends BaseService<Film, FilmDao> {

    public FilmService() {
        super(FilmDao.class);
    }

    @Override
    public void save(Film film) {
        super.save(film);
    }

    private void validateSaveUrun(Film film) {

        if (!film.getName().startsWith("U")) {
            String message = "Ürün Kodu U ile başlamak zorunda";
            // throw new SyException(message, SyException.EnumExceptionType.WARNING);
        }
    }
}
