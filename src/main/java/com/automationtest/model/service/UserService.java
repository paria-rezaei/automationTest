package com.automationtest.model.service;


import com.automationtest.model.entity.User;
import com.automationtest.model.repository.CRUDRepository;
import com.automationtest.model.service.imp.Service;

import java.util.List;

public class UserService implements Service<User,String> {
    @Override
    public User save(User user) throws Exception {
        try (CRUDRepository<User,String> crudRepository = new CRUDRepository<>()){
            return crudRepository.save(user);
        }
    }

    public User edit(User user) throws Exception{
        try (CRUDRepository<User,String> crudRepository = new CRUDRepository<>()){
            return crudRepository.save(user);
        }
    }

    @Override
    public User remove(String id) throws Exception {
        try (CRUDRepository<User,String> crudRepository = new CRUDRepository<>()){
            return crudRepository.remove(User.class,id);
        }
    }

    @Override
    public User findById(String id) throws Exception {
        try (CRUDRepository<User,String> crudRepository = new CRUDRepository<>()){
            return crudRepository.findById(User.class,id);
        }
    }

    @Override
    public List<User> findAll() throws Exception {
        try (CRUDRepository<User,String> crudRepository = new CRUDRepository<>()){
            return crudRepository.findAll(User.class);
        }
    }
}
