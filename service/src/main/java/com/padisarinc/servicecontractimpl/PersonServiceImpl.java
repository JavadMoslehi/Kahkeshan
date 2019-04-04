package com.padisarinc.servicecontractimpl;

import com.padisarinc.dao.PersonDao;
import com.padisarinc.entities.Person;
import com.padisarinc.servicecontract.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service//This is Like @Component, it is child of @Component
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonDao personDao;

    @Override
    public void save(Person person) {
        personDao.save(person);
    }
}