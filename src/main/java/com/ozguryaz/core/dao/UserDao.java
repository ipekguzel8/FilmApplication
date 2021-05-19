package com.ozguryaz.core.dao;
import com.ozguryaz.core.domain.User;
public class UserDao extends BaseDao<User>{
    public UserDao() {
        super(User.class);
    }
}
