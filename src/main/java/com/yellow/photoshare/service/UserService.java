package com.yellow.photoshare.service;

import com.yellow.photoshare.dao.UserDAO;
import com.yellow.photoshare.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService implements IUserService {

    private UserDAO personDAO;

    @Autowired
    public void setPersonDAO(UserDAO personDAO) {
        this.personDAO = personDAO;
    }

    @Override
    @Transactional
    public void addPerson(UserEntity userEntity) {
        this.personDAO.addPerson(userEntity);
    }

    @Override
    @Transactional
    public void updatePerson(UserEntity userEntity) {
        this.personDAO.updatePerson(userEntity);
    }

    @Override
    @Transactional
    public List<UserEntity> listPersons() {
        return this.personDAO.listPersons();
    }

    @Override
    @Transactional
    public UserEntity getPersonById(int id) {
        return this.personDAO.getPersonById(id);
    }

    @Override
    @Transactional
    public void removePerson(int id) {
        this.personDAO.removePerson(id);
    }

}
