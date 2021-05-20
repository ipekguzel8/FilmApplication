package com.ozguryaz.core.service;

import com.ozguryaz.core.dao.UserDao;
import com.ozguryaz.core.domain.User;
import java.util.List;

public class UserService extends BaseService<User, UserDao>{
    public UserService() {
        super(UserDao.class);
    }
    public List<User> findAllUser(User user){
        return getDao().findAllUser(user);
    }
}
