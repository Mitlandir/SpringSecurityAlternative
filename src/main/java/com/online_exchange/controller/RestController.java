package com.online_exchange.controller;

import com.online_exchange.dao.TransactionDao;
import com.online_exchange.dao.TransactionDaoImpl;
import com.online_exchange.model.Client;
import com.online_exchange.model.Completedtransaction;
import com.online_exchange.model.Transactionoffer;
import com.online_exchange.model.Transactionrequest;
import java.util.ArrayList;
import java.util.List;
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

    @RequestMapping(value = "/sendtransactionrequest", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Transactionrequest sendTransactionRequest(@RequestBody Transactionrequest req) {
        return transactionDao.sendTransactionrequest(req);

    }

    @RequestMapping(value = "/sendtransactionoffer", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Transactionoffer sendTransactionOffer(@RequestBody Transactionoffer offer) {
        return transactionDao.sendTransactionoffer(offer);
    }

    @RequestMapping(value = "/sendcompletedtransaction", method = RequestMethod.POST)
    public Completedtransaction sendCompletedtransaction(@RequestBody Completedtransaction trans) {
        return transactionDao.sendCompletedtransaction(trans);
    }
    
    @RequestMapping(value = "/fetchtransactionrequest/{requestid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Transactionrequest fetchTransactionrequest(@PathVariable int requestid){
        return transactionDao.fetchTransactionrequest(requestid);
    }
    
    @RequestMapping(value = "/fetchtransactionrequests/{exchangerid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Transactionrequest> fetchTransactionrequests(@PathVariable int exchangerid){
        return transactionDao.fetchTransactionrequests(exchangerid);
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public List<Client> test() {
        List<Client> list = new ArrayList<Client>();
        Client client1 = new Client();
        Client client2 = new Client();

        client1.setEmail("yahoo");
        client1.setPassword("konj");
        client2.setEmail("hotmail");
        client2.setPassword("mis");

        list.add(client1);
        list.add(client2);

        return list;
    }

    @RequestMapping(value = "/test2", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Client> test2() {
        List<Client> list = new ArrayList<Client>();
        Client client1 = new Client();
        Client client2 = new Client();

        client1.setEmail("yahoo");
        client1.setPassword("konj");
        client2.setEmail("hotmail");
        client2.setPassword("mis");

        list.add(client1);
        list.add(client2);

        return list;
    }

}
