
package com.online_exchange.dao;

import com.online_exchange.model.Completedtransaction;
import com.online_exchange.model.Transactionoffer;
import com.online_exchange.model.Transactionrequest;
import org.springframework.stereotype.Repository;

public interface TransactionDao {
    
    public Transactionrequest sendTransactionrequest(Transactionrequest transactionrequest);
    public Transactionoffer sendTransactionoffer(Transactionoffer transactionoffer);
    public Completedtransaction sendCompletedtransaction(Completedtransaction trans);
}
