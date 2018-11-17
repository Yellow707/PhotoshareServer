package com.yellow.photoshare.dao;

import com.yellow.photoshare.entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAO implements UserDaoInt {

    private static final Logger logger = LoggerFactory.getLogger(UserDAO.class);

    private SessionFactory sessionFactory;

    @Autowired(required=true)
//    @Qualifier(value="userService")
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    @Override
    public void addPerson(UserEntity p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(p);
        logger.info("Person saved successfully, Person Details="+p);
    }

    @Override
    public void updatePerson(UserEntity p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(p);
        logger.info("Person updated successfully, Person Details="+p);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<UserEntity> listPersons() {
        Session session = this.sessionFactory.getCurrentSession();
        List<UserEntity> personsList = session.createQuery("from Person").list();
        for(UserEntity p : personsList){
            logger.info("Person List::"+p);
        }
        return personsList;
    }

    @Override
    public UserEntity getPersonById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        UserEntity p = (UserEntity) session.load(UserEntity.class, new Integer(id));
        logger.info("Person loaded successfully, Person details="+p);
        return p;
    }

    @Override
    public void removePerson(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        UserEntity p = (UserEntity) session.load(UserEntity.class, new Integer(id));
        if(null != p){
            session.delete(p);
        }
        logger.info("Person deleted successfully, person details="+p);
    }

}
