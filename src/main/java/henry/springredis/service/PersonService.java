package henry.springredis.service;

import henry.springredis.entity.Person;

import java.util.List;

public interface PersonService {
    List<Person> findAll();
    Person findById(Long id);
    Person save(Person person);
    Person delete(Long id);
}
