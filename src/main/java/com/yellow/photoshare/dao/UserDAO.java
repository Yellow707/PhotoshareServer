package com.yellow.photoshare.dao;

import com.yellow.photoshare.entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAO implements IUserDao {

    private static final Logger logger = LoggerFactory.getLogger(UserDAO.class);

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    @Override
    public void addPerson(UserEntity userEntity) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(userEntity);
        logger.info("Person saved successfully, Person Details="+ userEntity);
    }

    @Override
    public void updatePerson(UserEntity userEntity) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(userEntity);
        logger.info("Person updated successfully, Person Details="+ userEntity);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<UserEntity> listPersons() {
        Session session = this.sessionFactory.getCurrentSession();
        List<UserEntity> personsList = session.createQuery("from Person").list();
        for(UserEntity userEntity : personsList){
            logger.info("Person List::"+ userEntity);
        }
        return personsList;
    }

    @Override
    public UserEntity getPersonById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        UserEntity userEntity = session.load(UserEntity.class, new Integer(id));
        logger.info("Person loaded successfully, Person details="+ userEntity);
        return userEntity;
    }

    @Override
    public void removePerson(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        UserEntity userEntity = session.load(UserEntity.class, new Integer(id));
        if(null != userEntity){
            session.delete(userEntity);
        }
        logger.info("Person deleted successfully, person details="+ userEntity);
    }

}
