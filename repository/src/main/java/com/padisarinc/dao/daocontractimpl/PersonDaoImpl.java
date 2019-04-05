package com.padisarinc.dao.daocontractimpl;

import com.padisarinc.dao.daocontract.PersonDao;
import com.padisarinc.entities.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Root;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * @Repository means this class is able to auto wired in another class
 *
 * @Repository is child of @Component
 */
@Repository
public class PersonDaoImpl implements PersonDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Person person) {
        Session session = sessionFactory.openSession();
        session.save(person);
    }

    @Override
    public void delete(Person person) {
        Session session = sessionFactory.openSession();
        session.delete(person);
    }

    @Override
    public void update(Person person) {
        Session session = sessionFactory.openSession();
        session.update(person);
    }

    @Override
    public List<Person> getList() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Person> criteriaQuery = criteriaBuilder.createQuery(Person.class);
        Root<Person> personRoot = criteriaQuery.from(Person.class);
        criteriaQuery.select(personRoot);
        Query<Person> query = session.createQuery(criteriaQuery);
        List<Person> resultList = query.getResultList();
        return resultList;
    }
}