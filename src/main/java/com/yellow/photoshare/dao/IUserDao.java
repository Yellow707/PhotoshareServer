package com.yellow.photoshare.dao;

import com.yellow.photoshare.entity.UserEntity;

import java.util.List;

public interface IUserDao {

    void addPerson(UserEntity userEntity);
    void updatePerson(UserEntity userEntity);
    List<UserEntity> listPersons();
    UserEntity getPersonById(int id);
    void removePerson(int id);
}
