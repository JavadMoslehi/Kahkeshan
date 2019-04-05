package com.padisarinc.servicecontract;


import com.padisarinc.entities.Person;

import java.util.List;

public interface PersonService {
    void save(Person person);
    void delete(Person person);
    void update(Person person);
    List<Person> getList();
}
