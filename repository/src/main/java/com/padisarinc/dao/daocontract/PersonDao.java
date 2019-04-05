package com.padisarinc.dao.daocontract;

import com.padisarinc.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;

public interface PersonDao {
    void save(Person person);
    void delete(Person person);
    void update(Person person);
}
