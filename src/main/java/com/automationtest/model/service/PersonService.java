package com.automationtest.model.service;
import com.automationtest.model.entity.Person;
import com.automationtest.model.repository.CRUDRepository;
import com.automationtest.model.service.imp.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonService implements Service<Person,String> {
    private static final PersonService personService = new PersonService();
    private PersonService() {
    }

    public static PersonService getUserService() {
        return personService;
    }

    @Override
    public Person save(Person person) throws Exception {
        try (CRUDRepository<Person,String> crudRepository = new CRUDRepository<>()){
            return crudRepository.save(person);
        }
    }

    public Person edit(Person person) throws Exception{
        try (CRUDRepository<Person,String> crudRepository = new CRUDRepository<>()){
                return crudRepository.save(person);
        }
    }

    @Override
    public Person remove(String id) throws Exception {
        try (CRUDRepository<Person,String> crudRepository = new CRUDRepository<>()){
            return crudRepository.remove(Person.class,id);
        }
    }

    @Override
    public Person findById(String id) throws Exception {
        try (CRUDRepository<Person,String> crudRepository = new CRUDRepository<>()){
            return crudRepository.findById(Person.class,id);
        }
    }

    @Override
    public List<Person> findAll() throws Exception {
        try (CRUDRepository<Person,String> crudRepository = new CRUDRepository<>()){
            return crudRepository.findAll(Person.class);
        }
    }

    public Person findByName(String name) throws Exception {
        try (CRUDRepository<Person,String> crudRepository = new CRUDRepository<>()){
            Map<String,Object> params = new HashMap<>();
            params.put("name",name);
            List<Person> personList = crudRepository.findBy("Person.FindByName",params);
            return (personList.isEmpty() ? null : personList.get(0));
        }
    }


}
