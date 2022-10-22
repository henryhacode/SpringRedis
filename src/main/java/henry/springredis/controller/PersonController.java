package henry.springredis.controller;

import henry.springredis.entity.Person;
import henry.springredis.service.PersonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/persons")
@Slf4j
public class PersonController {
    private final PersonService personService;

    @GetMapping
    public List<Person> findAll() {
        return personService.findAll();
    }

    @Cacheable(value = "persons", key = "#id")
    @GetMapping("/{id}")
    public Person findById(@PathVariable Long id) {
        log.info("Getting person with id {}", id);
        return personService.findById(id);
    }

    @CachePut(value = "persons", key = "#person.id")
    @PostMapping
    public Person save(@RequestBody Person person) {
        return personService.save(person);
    }

    @CacheEvict(value = "persons", key = "#id")
    @DeleteMapping("/{id}")
    public Person delete(@PathVariable Long id) {
        return personService.delete(id);
    }
}
