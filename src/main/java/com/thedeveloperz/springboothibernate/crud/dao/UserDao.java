package com.thedeveloperz.springboothibernate.crud.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.thedeveloperz.springboothibernate.crud.model.User;

@Transactional
public interface UserDao extends CrudRepository<User, Long>{
public User findByEmail(String email);
}
