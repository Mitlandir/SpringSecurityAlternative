
package com.online_exchange.dao;

import com.online_exchange.model.Completedtransaction;
import com.online_exchange.model.Transactionoffer;
import com.online_exchange.model.Transactionrequest;
import java.util.List;
import org.springframework.stereotype.Repository;

public interface TransactionDao {
    
    public Transactionrequest sendTransactionrequest(Transactionrequest transactionrequest);
    public Transactionoffer sendTransactionoffer(Transactionoffer transactionoffer);
    public Completedtransaction sendCompletedtransaction(Completedtransaction trans);
    public Transactionrequest fetchTransactionrequest(int requestid);
    public List<Transactionrequest> fetchTransactionrequests(int exchangerid);
}
