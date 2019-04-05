package com.padisarinc.servicecontractimpl;

import com.padisarinc.entities.Person;
import org.springframework.stereotype.Service;
import com.padisarinc.dao.daocontract.PersonDao;
import com.padisarinc.servicecontract.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
/**
 * @Service is Like @Component, it's child of @Component
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDao personDao;

    @Override
    public void save(Person person) {
        personDao.save(person);
    }

    @Override
    public void delete(Person person) {
        personDao.delete(person);
    }

    @Override
    public void update(Person person) {
        personDao.update(person);
    }

    @Override
    public List<Person> getList() {
        return personDao.getList();
    }
}