package com.online_exchange.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.online_exchange.dao.TransactionDao;
import com.online_exchange.dao.TransactionDaoImpl;
import com.online_exchange.model.Client;
import com.online_exchange.model.Completedtransaction;
import com.online_exchange.model.Exchanger;
import com.online_exchange.model.Transactionoffer;
import com.online_exchange.model.Transactionrequest;
import com.online_exchange.model.User;
import com.online_exchange.model.UserProfile;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class RestController {

    @Autowired
    TransactionDao transactionDao;

    @Autowired
    SessionFactory sessionFactory;

    @RequestMapping(value = "/sendtransactionrequest", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Transactionrequest sendTransactionRequest(@RequestBody Transactionrequest req) {
        return transactionDao.sendTransactionrequest(req);

    }

    @RequestMapping(value = "/fetchtransactionrequest/{requestid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Transactionrequest fetchTransactionrequest(@PathVariable int requestid) {
        return transactionDao.fetchTransactionrequest(requestid);
    }

    @RequestMapping(value = "/fetchtransactionrequests/{exchangerid}", produces = MediaType.APPLICATION_JSON_VALUE)//TODO: hash ID's
    public List<Transactionrequest> fetchTransactionrequests(@PathVariable int exchangerid) {
        return transactionDao.fetchTransactionrequests(exchangerid);
    }

    @RequestMapping(value = "/sendtransactionoffer", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Transactionoffer sendTransactionOffer(@RequestBody Transactionoffer offer) {
        return transactionDao.sendTransactionoffer(offer);
    }

    @RequestMapping(value = "/fetchtransactionoffer/{offerid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Transactionoffer fetchTransactionoffer(@PathVariable int offerid) {
        return transactionDao.fetchTransactionoffer(offerid);
    }

    @RequestMapping(value = "/fetchtransactionoffers/{clientid}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Transactionoffer> fetchTransactionoffers(@PathVariable int clientid) {
        return transactionDao.fetchTransactionoffers(clientid);
    }

    @RequestMapping(value = "/sendcompletedtransaction", method = RequestMethod.POST)
    public Completedtransaction sendCompletedtransaction(@RequestBody Completedtransaction trans) {
        return transactionDao.sendCompletedtransaction(trans);
    }
    
    @RequestMapping(value = "/exchanger/sec")
    @ResponseBody
    public String sec(){
        return "only exchangers allowed";
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() throws JsonProcessingException {
        User user = new User();
        user.setEmail("f@konjc.com");
        user.setFirstName("f");
        user.setPassword("s");
        user.setSsoId("12sf");
        user.setState("Active");
        user.setLastName("11f");
        Set<UserProfile> userProfiles = new HashSet<UserProfile>();

        UserProfile userProfile = new UserProfile(5);

        userProfiles.add(userProfile);
        user.setUserProfiles(userProfiles);
        System.out.println(user);
        
        Session s = sessionFactory.openSession();
        Transaction t = s.beginTransaction();
        s.save(user);
        t.commit();
        s.close();
        
        //sessionFactory.openSession().save(userProfile);
        
        return "kurcinnaaaaa!!";

    }

    @RequestMapping(value = "/danijemozdakurcina", method = RequestMethod.GET)
    public void test2() throws JsonProcessingException {
        List<Client> lista = sessionFactory.openSession().getNamedQuery("Client.findAll").list();
        for (Client lista1 : lista) {
            System.out.println(lista1.getEmail());
        }

    }

}
