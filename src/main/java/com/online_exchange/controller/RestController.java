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
    public Transactionrequest test() throws JsonProcessingException {
        Client client1 = new Client();
        client1.setEmail("pera@gmail.com");
        client1.setPassword("macka123");
        client1.setId(1);
        
        
        Exchanger exchanger1 = new Exchanger();
        exchanger1.setName("Panter");
        exchanger1.setPassword("omglol");
        exchanger1.setId(1);
        Exchanger exchanger2 = new Exchanger();
        exchanger2.setName("Pirana");
        exchanger2.setPassword("roflmao");
        exchanger1.setId(2);
        
        Transactionrequest request1 = new Transactionrequest();
        request1.setAmount(450);
        request1.setClient(client1);
        request1.setRate(120);
        request1.setId(1);
        
        List<Transactionrequest> requests = new ArrayList<Transactionrequest>();
        requests.add(request1);
        
        
        Transactionoffer offer1 = new Transactionoffer();
        offer1.setAmount(450);
        offer1.setRate(119);
        offer1.setId(1);
        offer1.setClient(client1);
        offer1.setExchanger(exchanger1);
        offer1.setTransactionRequest(request1);
        
        Transactionoffer offer2 = new Transactionoffer();
        offer2.setAmount(450);
        offer2.setRate(121);
        offer2.setId(2);
        offer2.setClient(client1);
        offer2.setExchanger(exchanger2);
        offer2.setTransactionRequest(request1);
        
        List<Transactionoffer> offers = new ArrayList<Transactionoffer>();
        offers.add(offer1);
        offers.add(offer2);
        request1.setTransactionofferCollection(offers);
        
        client1.setTransactionrequestCollection(requests);
        client1.setTransactionofferCollection(offers);
        
        List<Transactionoffer> offersFromExchanger1 = new ArrayList<Transactionoffer>();
        offersFromExchanger1.add(offer1);
        
        List<Transactionoffer> offersFromExchanger2 = new ArrayList<Transactionoffer>();
        offersFromExchanger2.add(offer2);
        
        exchanger1.setTransactionofferCollection(offersFromExchanger1);
        exchanger2.setTransactionofferCollection(offersFromExchanger2);
        
        System.out.println(request1);
        
        return request1;

    }

    @RequestMapping(value = "/danijemozdakurcina", method = RequestMethod.GET)
    public void test2() throws JsonProcessingException {
        List<Client> lista = sessionFactory.openSession().getNamedQuery("Client.findAll").list();
        for (Client lista1 : lista) {
            System.out.println(lista1.getEmail());
        }

    }

}
