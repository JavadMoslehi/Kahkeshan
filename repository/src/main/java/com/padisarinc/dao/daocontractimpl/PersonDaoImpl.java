package com.padisarinc.dao.daocontractimpl;

import com.padisarinc.dao.daocontract.PersonDao;
import com.padisarinc.entities.Person;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
        sessionFactory.openSession().save(person);
    }

    @Override
    public void delete(Person person) {
        sessionFactory.openSession().delete(person);
    }

    @Override
    public void update(Person person) {
        sessionFactory.openSession().update(person);
    }
}