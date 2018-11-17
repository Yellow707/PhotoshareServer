package com.yellow.photoshare.dao;

import com.yellow.photoshare.entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
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
        List<UserEntity> personsList = session.createQuery("FROM UserEntity").list();
        for(UserEntity userEntity : personsList){
            logger.info("Person List::"+ userEntity);
        }
        return personsList;
    }

    @Override
    public UserEntity getPersonByUsername(String username) {
        Session session = this.sessionFactory.getCurrentSession();

        FullTextSession fullTextSession = Search.getFullTextSession(session);
//        fullTextSession.createIndexer().start();


        Transaction tx = fullTextSession.beginTransaction();

// create native Lucene query using the query DSL
// alternatively you can write the Lucene query using the Lucene query parser
// or the Lucene programmatic API. The Hibernate Search DSL is recommended though
        QueryBuilder qb = fullTextSession.getSearchFactory()
                .buildQueryBuilder().forEntity(UserEntity.class).get();
        org.apache.lucene.search.Query query = qb
                .keyword()
                .onFields("Username")
                .matching(username)
                .createQuery();

// wrap Lucene query in a org.hibernate.Query
        org.hibernate.Query hibQuery =
                fullTextSession.createFullTextQuery(query, UserEntity.class);

// execute search
        List<UserEntity> result = hibQuery.list();

        tx.commit();
        session.close();

        return result.get(0);
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
