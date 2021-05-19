package com.ozguryaz.core.service;

import com.ozguryaz.core.dao.ActorDao;
import com.ozguryaz.core.domain.Actor;

public class ActorService extends BaseService<Actor, ActorDao> {

    public ActorService() {
        super(ActorDao.class);
    }
}
