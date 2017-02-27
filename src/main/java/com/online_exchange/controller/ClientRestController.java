package com.online_exchange.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.online_exchange.dao.TransactionDao;
import com.online_exchange.model.Completedtransaction;
import com.online_exchange.model.Transactionoffer;
import com.online_exchange.model.Transactionrequest;
import org.hibernate.SessionFactory;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/client")
public class ClientRestController {
//RESTS relevant to Clients; only accessible to logged Clients
    @Autowired
    TransactionDao transactionDao;

    @Autowired
    SessionFactory sessionFactory;

    @RequestMapping(value = "/sendtransactionrequest", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String sendTransactionRequest(@RequestBody Transactionrequest req) {
        return new JSONObject(transactionDao.sendTransactionrequest(req)).toString();
    }

    @RequestMapping(value = "/fetchtransactionrequest/{requestid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String fetchTransactionrequest(@PathVariable int requestid) {
        return new JSONObject(transactionDao.fetchTransactionrequest(requestid)).toString();
    }


    @RequestMapping(value = "/fetchtransactionoffer/{offerid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String fetchTransactionoffer(@PathVariable int offerid) {
        return new JSONObject(transactionDao.fetchTransactionoffer(offerid)).toString();
    }

    @RequestMapping(value = "/fetchtransactionoffers/{clientid}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String fetchTransactionoffers(@PathVariable int clientid) {
        return new JSONArray(transactionDao.fetchTransactionoffers(clientid)).toString();
    }

    @RequestMapping(value = "/sendcompletedtransaction", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String sendCompletedtransaction(@RequestBody Completedtransaction trans) {
        return new JSONObject(transactionDao.sendCompletedtransaction(trans)).toString();
    }

    @RequestMapping(value = "/fetchcompletedtransaction/{completedtransactionid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String fetchCompletedtransaction(@PathVariable int completedtransactionid) {
        return new JSONObject(transactionDao.fetchCompletedtransaction(completedtransactionid)).toString();
    }

    @RequestMapping(value = "/exchanger/sec")
    @ResponseBody
    public String sec() {
        return "only exchangers allowed";
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String test() throws JsonProcessingException {
        return new JSONArray(transactionDao.fetchCompletedtransactions()).toString();
    }
}
