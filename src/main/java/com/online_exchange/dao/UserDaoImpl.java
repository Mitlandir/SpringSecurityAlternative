package com.online_exchange.dao;

import com.online_exchange.model.Client;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.online_exchange.model.User;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {
    
    @Autowired
    SessionFactory sessionFactory;

	public User findById(int id) {
		return getByKey(id);
	}

	public User findBySSO(String sso) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("ssoId", sso));
		return (User) crit.uniqueResult();
	}
        
        public List<Client> find (Integer client){
            Session ses = sessionFactory.openSession();
            ses.beginTransaction();
            List<Client> lista = ses.createCriteria(Client.class).add(Restrictions.eq("email", client)).list();
            for(int i = 0; i < lista.size(); i++){
                System.out.println(lista.get(i).getEmail());
            }
            return lista;
        }

	
}
