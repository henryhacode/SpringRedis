package henry.springredis.service.impl;

import henry.springredis.entity.Person;
import henry.springredis.repository.PersonRepository;
import henry.springredis.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;

    @Override
    public List<Person> findAll() {
        return (List<Person>) personRepository.findAll();
    }

    @Override
    public Person findById(Long id) {
        return personRepository.findById(id).orElse(null);
    }

    @Override
    public Person save(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person delete(Long id) {
        Person person = personRepository.findById(id).orElse(null);
        personRepository.deleteById(id);
        return person;
    }
}
