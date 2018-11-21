package com.yellow.photoshare.service;

import com.yellow.photoshare.dao.UserDAO;
import com.yellow.photoshare.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService implements IUserService {

    private UserDAO userDAO;

    @Autowired
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    @Transactional
    public void addPerson(UserEntity userEntity) {
        this.userDAO.addPerson(userEntity);
    }

    @Override
    @Transactional
    public void updatePerson(UserEntity userEntity) {
        this.userDAO.updatePerson(userEntity);
    }

    @Override
    @Transactional
    public List<UserEntity> listPersons() {
        return this.userDAO.listPersons();
    }

    @Override
    @Transactional
    public UserEntity getPersonByUsername(String username) {
        return this.userDAO.getPersonByUsername(username);
    }

    @Override
    @Transactional
    public void removePerson(Long id) {
        this.userDAO.removePerson(id);
    }

}
