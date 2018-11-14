package com.yellow.photoshare.dao;

import com.yellow.photoshare.entity.UserEntity;

import javax.persistence.EntityManager;

public class UserDAO extends AbstractDAO {

    public UserDAO(EntityManager entityManager) {
        super(entityManager);
    }

    public UserEntity persist(String name, String surname, String username, Integer age, String email) {
        beginTransaction();
        UserEntity userEntity = new UserEntity(name, surname, username, age, email);
        entityManager.persist(userEntity);
        commitTransaction();
        return userEntity;
    }
}
