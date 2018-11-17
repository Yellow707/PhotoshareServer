package com.yellow.photoshare.service;

import com.yellow.photoshare.entity.UserEntity;

import java.util.List;

public interface IUserService {

    void addPerson(UserEntity userEntity);
    void updatePerson(UserEntity userEntity);
    List<UserEntity> listPersons();
    UserEntity getPersonByUsername(String username);
    void removePerson(int id);

}
