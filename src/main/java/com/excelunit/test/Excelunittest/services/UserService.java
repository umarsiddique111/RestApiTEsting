package com.excelunit.test.Excelunittest.services;

import java.util.Hashtable;

import org.springframework.stereotype.Service;

import com.excelunit.test.Excelunittest.model.User;

@Service
public class UserService {
	
	Hashtable<String, User> Users = new Hashtable<String, User>();
	
	public UserService() {
		User user = new User();
		user.setId(1);
		user.setemail("ali@yahoo.com");
		user.setName("ali");
		user.setPassword("ali123");
		Users.put("1", user);
		
		
		user = new User();
		user.setId(2);
		user.setemail("umar@yahoo.com");
		user.setName("umar");
		user.setPassword("umar123");
		Users.put("2", user);
		
		user = new User();
		user.setId(3);
		user.setemail("saleem@yahoo.com");
		user.setName("saleem");
		user.setPassword("saleem123");
		Users.put("3", user);
	}
	
	public User getUser(String id) {
			if(Users.containsKey(id))
			return Users.get(id);
			else 
				return null;	
		
	}
	public Hashtable<String, User> getAll(){
		
		return Users;
	}
	public User deleteUser(String id) {
		if(Users.containsKey(id))
		return Users.remove(id);
		else
		return null;	
		
	}
	public User updateUser(String id,User name) {
		if (Users.containsKey(id))
			return Users.put(id, name);
		else
			return null;
	}

}
