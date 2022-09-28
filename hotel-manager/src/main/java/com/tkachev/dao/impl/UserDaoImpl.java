package com.tkachev.dao.impl;

import com.tkachev.dao.AbstractGenericDao;
import com.tkachev.dao.UserDao;
import com.tkachev.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends AbstractGenericDao<User, Integer> implements UserDao {

    public UserDaoImpl() {
        super(User.class);
    }
}
