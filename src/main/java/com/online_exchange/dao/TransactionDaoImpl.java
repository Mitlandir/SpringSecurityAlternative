package com.online_exchange.dao;

import com.online_exchange.model.Completedtransaction;
import com.online_exchange.model.Transactionoffer;
import com.online_exchange.model.Transactionrequest;
import com.online_exchange.model.User;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.persistence.internal.oxm.schema.model.Restriction;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TransactionDaoImpl implements TransactionDao {

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

    public Transactionrequest fetchTransactionrequest(int requestid) {
        Transactionrequest request = (Transactionrequest) sessionFactory.openSession().getNamedQuery("Transactionrequest.findById").setParameter("id", requestid).uniqueResult();
        request.prune();
        return request;
    }

    public List<Transactionrequest> fetchTransactionrequests(int exchangerid) {
        List<Transactionrequest> requests = sessionFactory.openSession().getNamedQuery("Transactionrequest.findAll").list();
        List<Transactionoffer> offers = sessionFactory.openSession().createCriteria(Transactionoffer.class).add(Restrictions.eq("exchanger", new User(exchangerid))).list();
        for (Transactionoffer offer : offers) {
            for (Transactionrequest request : requests) {
                if (offer.getTransactionRequest().getId().equals(request.getId())) {
                    request.setAlreadyOffered(true);
                }
            }
        }
        for(Transactionrequest req : requests){
            req.prune();
        }
        return requests;
    }

    public Transactionoffer fetchTransactionoffer(int offerid) {
        Transactionoffer offer = (Transactionoffer) sessionFactory.openSession().get(Transactionoffer.class, offerid);
        offer.prune();
        return offer;
    }

    public List<Transactionoffer> fetchTransactionoffers(int clientid) {
        List<Transactionoffer> offers = (ArrayList<Transactionoffer>) sessionFactory.openSession().createCriteria(Transactionoffer.class).list();
        for(Transactionoffer offer : offers){
            offer.prune();
        }
        return offers;
    }

    public boolean deleteTransactionrequest(Transactionrequest request) {
        try{
        sessionFactory.openSession().delete(request);
        }catch(HibernateException e){
           return false; 
        }
        return false;
    }

    public boolean deleteTransactionoffer(Transactionoffer offer) {
        try{
        sessionFactory.openSession().delete(offer);
        }catch(HibernateException e){
           return false; 
        }
        return false;
    }

    public Completedtransaction fetchCompletedtransaction(int completedtransactionid) {
        Completedtransaction trans = (Completedtransaction) sessionFactory.openSession().get(Completedtransaction.class, completedtransactionid);
        trans.prune();
        return trans;
    }

    public List<Completedtransaction> fetchCompletedtransactions() {
        List<Completedtransaction> transList = sessionFactory.openSession().createCriteria(Completedtransaction.class).list();
        for(Completedtransaction trans : transList){
            trans.prune();
        }
        return transList;
    }

}
