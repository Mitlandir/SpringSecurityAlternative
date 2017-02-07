
package com.online_exchange.dao;

import com.online_exchange.model.Client;
import com.online_exchange.model.Completedtransaction;
import com.online_exchange.model.Exchanger;
import com.online_exchange.model.Transactionoffer;
import com.online_exchange.model.Transactionrequest;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.persistence.internal.oxm.schema.model.Restriction;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
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
        return (Transactionrequest) sessionFactory.openSession().getNamedQuery("Transactionrequest.findById").setParameter("id", requestid).uniqueResult();
    }
    
    public List<Transactionrequest> fetchTransactionrequests(int exchangerid){
        return null;
    }

    public Transactionoffer fetchTransactionoffer(int offerid) {
        //placeholder START
        Transactionoffer offer = new Transactionoffer();
        offer.setAmount(240);
        offer.setId(5);
        offer.setRate(3);
        Transactionrequest request = new Transactionrequest();
        request.setAmount(240);
        request.setRate(5);
        request.setId(7);
        offer.setTransactionRequest(request);
        List<Transactionoffer> offers = new ArrayList<Transactionoffer>();
        offers.add(offer);
        request.setTransactionofferCollection(offers);
        //placeholder END
        return offer;
    }

    public List<Transactionoffer> fetchTransactionoffers(int clientid) {
        //placeholder START\\
        Client client1 = new Client();
        client1.setEmail("pera@gmail.com");
        client1.setPassword("123");
        Exchanger exchanger1 = new Exchanger();
        exchanger1.setName("panter");
        exchanger1.setPassword("panter");
        Exchanger exchanger2 = new Exchanger();
        exchanger2.setName("pirana");
        exchanger2.setPassword("pirana");
        Transactionrequest req = new Transactionrequest();
        req.setId(1);
        req.setRate(450);
        req.setAmount(230);
        List<Transactionoffer> offers = new ArrayList<Transactionoffer>();
        Transactionoffer o1 = new Transactionoffer();
        o1.setAmount(45);
        o1.setRate(77);
        o1.setId(6);
        offers.add(o1);
        Transactionoffer o2 = new Transactionoffer();
        o2.setAmount(4534);
        o2.setRate(133);
        o2.setId(7);
        offers.add(o2);
        List<Transactionrequest> requests = new ArrayList<Transactionrequest>();
        requests.add(req);
        
        req.setClient(client1);
        client1.setTransactionrequestCollection(requests);
        client1.setTransactionofferCollection(offers);
        req.setTransactionofferCollection(offers);
        exchanger1.setTransactionofferCollection(offers);
        o1.setExchanger(exchanger1);
        o1.setExchanger(exchanger2);
        o1.setTransactionRequest(req);
        o2.setTransactionRequest(req);
        //placeholder END
        return offers;
    }   

    public boolean deleteTransactionrequest(Transactionrequest request) {
        //TODO
        return false;
    }

    public boolean deleteTransactionoffer(Transactionoffer offer) {
        //TODO
        return false;
    }
    
}
