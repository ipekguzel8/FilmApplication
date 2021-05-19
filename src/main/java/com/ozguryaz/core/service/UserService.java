package com.ozguryaz.core.service;

import com.ozguryaz.core.dao.UserDao;
import com.ozguryaz.core.domain.User;

public class UserService extends BaseService<User, UserDao>{
    public UserService() {
        super(UserDao.class);
    }
}
