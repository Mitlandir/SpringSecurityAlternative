package com.online_exchange.controller;

import com.online_exchange.dao.TransactionDao;
import com.online_exchange.dao.TransactionDaoImpl;
import com.online_exchange.model.Completedtransaction;
import com.online_exchange.model.Transactionoffer;
import com.online_exchange.model.Transactionrequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
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

    @RequestMapping(value = "/test", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Transactionrequest test(@RequestBody Transactionrequest req) {
        transactionDao.sendTransactionrequest(req);
        return req;
    }

}
