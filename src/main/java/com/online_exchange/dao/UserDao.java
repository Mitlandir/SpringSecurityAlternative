package com.online_exchange.dao;

import com.online_exchange.model.Client;
import com.online_exchange.model.User;
import java.util.List;

public interface UserDao {

	User findById(int id);
	
	User findBySSO(String sso);
	
        public List <Client> find(Integer client);
}

