package com.yellow.photoshare.service;

import com.yellow.photoshare.entity.UserEntity;

import java.util.List;

public interface IService {

    public void addPerson(UserEntity userEntity);
    public void updatePerson(UserEntity userEntity);
    public List<UserEntity> listPersons();
    public UserEntity getPersonById(int id);
    public void removePerson(int id);

}
