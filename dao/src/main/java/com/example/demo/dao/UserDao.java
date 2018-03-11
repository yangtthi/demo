package com.example.demo.dao;

import com.example.demo.entity.test.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by yangtthi on 18/3/11.
 */
public interface UserDao extends MongoRepository<User, ObjectId> {

    List<User> findAll();

    User findById(String id);

    User findByName(String name);

}
