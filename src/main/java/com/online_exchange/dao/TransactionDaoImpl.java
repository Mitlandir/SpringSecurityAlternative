
package com.online_exchange.dao;

import com.online_exchange.model.Completedtransaction;
import com.online_exchange.model.Transactionoffer;
import com.online_exchange.model.Transactionrequest;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TransactionDaoImpl implements TransactionDao{

    
    @Autowired
    SessionFactory sessionFactory;
    

    public Transactionrequest sendTransactionrequest(Transactionrequest transactionrequest) {
        sessionFactory.openSession().save(transactionrequest);
        return transactionrequest;
    }

    public Transactionoffer sendTransactionoffer(Transactionoffer transactionoffer) {
        sessionFactory.openSession().save(transactionoffer);
        return transactionoffer;
    }

    public Completedtransaction sendCompletedtransaction(Completedtransaction trans) {
        sessionFactory.openSession().save(trans);
        return trans;
    }
    
    public Transactionrequest fetchTransactionrequest(int requestid){
        //placeholder START
        Transactionrequest req = new Transactionrequest();
        req.setAmount(25);
        req.setRate(22);
        req.setId(5);
        //placeholder END
        return req;   
    }
    
    public List<Transactionrequest> fetchTransactionrequests(int exchangerid){
        //placeholder START
        List<Transactionrequest> list = new ArrayList<Transactionrequest>();
        Transactionrequest t1 = new Transactionrequest();
        Transactionrequest t2 = new Transactionrequest();
        t1.setAmount(123);
        t1.setRate(35);
        t2.setAmount(3556);
        t2.setRate(65);
        list.add(t1);
        list.add(t2);
        //placeholder END
        return list;
    }
    
    
}
