package com.yellow.photoshare.dao;

import com.yellow.photoshare.entity.UserEntity;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
@Transactional
public class UserDAO  {

    private static final Logger logger = LoggerFactory.getLogger(UserDAO.class);

    @PersistenceContext
    private EntityManager entityManager;


//    @Override
    public void addPerson(UserEntity userEntity) {
        entityManager.persist(userEntity);
        logger.info("Person saved successfully, Person Details="+ userEntity);
    }

//    @Override
    public void updatePerson(UserEntity userEntity) {
        entityManager.merge(userEntity);
        logger.info("Person updated successfully, Person Details="+ userEntity);
    }

    @SuppressWarnings("unchecked")
    public List<UserEntity> listPersons() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserEntity> cq = cb.createQuery(UserEntity.class);
        Root<UserEntity> rootEntry = cq.from(UserEntity.class);
        CriteriaQuery<UserEntity> all = cq.select(rootEntry);
        TypedQuery<UserEntity> allQuery = entityManager.createQuery(all);
        return allQuery.getResultList();
    }

    public UserEntity getPersonByUsername(String username) {
        FullTextEntityManager fullTextEntityManager
                = Search.getFullTextEntityManager(entityManager);
        try {
            fullTextEntityManager.createIndexer().startAndWait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory()
                .buildQueryBuilder()
                .forEntity(UserEntity.class)
                .get();

        org.apache.lucene.search.Query query = queryBuilder
                .keyword()
                .onField("username")
                .matching(username)
                .createQuery();

        org.hibernate.search.jpa.FullTextQuery jpaQuery
                = fullTextEntityManager.createFullTextQuery(query, UserEntity.class);

        List<UserEntity> results = jpaQuery.getResultList();

        return results.get(0);
    }

//    @Override
    public void removePerson(int id) {
        UserEntity userEntity = entityManager.find(UserEntity.class, new Integer(id));
        if(null != userEntity){
            entityManager.remove(userEntity);
        }
        logger.info("Person deleted successfully, person details="+ userEntity);
    }

}
