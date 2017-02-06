package com.online_exchange.service;

import com.online_exchange.model.User;

public interface UserService {

	User findById(int id);
	
	User findBySso(String sso);
	
}