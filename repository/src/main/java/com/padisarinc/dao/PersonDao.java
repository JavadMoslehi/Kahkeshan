package com.padisarinc.dao;

import com.padisarinc.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;

public interface PersonDao {
    void save(Person person);
}
