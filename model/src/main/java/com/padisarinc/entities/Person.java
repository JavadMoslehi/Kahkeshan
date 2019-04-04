package com.padisarinc.entities;

import org.hibernate.validator.constraints.NotEmpty;
import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tbl_person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long id;

    @NotEmpty(message = "Please enter your firstName")
    @Size(min = 5, max = 10, message = "نام نمیتواند کمتر از 5 کاراکتر باشد")
    private String name;

    private String family;

    private int age;

    public Person() {
        System.out.println("Person default created");
    }

    public Person(String name, String family, int age) {
        this.name = name;
        this.family = family;
        this.age = age;
        System.out.println("Person initialized created");
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
