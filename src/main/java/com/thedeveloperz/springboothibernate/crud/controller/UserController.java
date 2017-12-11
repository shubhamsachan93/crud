package com.thedeveloperz.springboothibernate.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thedeveloperz.springboothibernate.crud.dao.UserDao;
import com.thedeveloperz.springboothibernate.crud.model.User;

@Controller
public class UserController {
//create a new user and save it in database
	@Autowired
	private UserDao userDao;
	@RequestMapping("/create")
	@ResponseBody
	public String create(String email,String name){
		String userId="";
		try{
			User user = new User(email,name);
			userDao.save(user);
			userId = String.valueOf(user.getId());
		}catch (Exception ex) {
		      return "Error creating the user: " + ex.toString();
	    }
	    return "User succesfully created with id = " + userId;
	}
	@RequestMapping("/delete")
	@ResponseBody
	public String delete(long id){
		try{
		User user = new User(id);
		userDao.delete(user);
		}catch(Exception ex){
			return "error deleting the user"+ex.toString();
		}
		return "user deleted successfully";
	}
}
