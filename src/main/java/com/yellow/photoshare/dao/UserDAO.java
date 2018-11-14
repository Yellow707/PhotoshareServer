package com.yellow.photoshare.dao;

import com.yellow.photoshare.entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class UserDAO {

    private SessionFactory sessionFactory;

    public UserDAO() {

    }

    public void persist(UserEntity userEntity) {
        Session session = this.sessionFactory.getCurrentSession();
    }
}
