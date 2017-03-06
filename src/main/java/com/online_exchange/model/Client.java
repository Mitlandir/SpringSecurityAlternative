package com.online_exchange.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(mappedBy = "client")
    private Transactionrequest transactionrequest;

    @OneToMany(mappedBy = "client")
    private List<Completedtransaction> completedtransactions;

    @OneToMany(mappedBy = "client")
    private List<Transactionoffer> transactionoffers;
    
    public Client(){}

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the transactionrequest
     */
    public Transactionrequest getTransactionrequest() {
        return transactionrequest;
    }

    /**
     * @param transactionrequest the transactionrequest to set
     */
    public void setTransactionrequest(Transactionrequest transactionrequest) {
        this.transactionrequest = transactionrequest;
    }

    /**
     * @return the completedtransactions
     */
    public List<Completedtransaction> getCompletedtransactions() {
        return completedtransactions;
    }

    /**
     * @param completedtransactions the completedtransactions to set
     */
    public void setCompletedtransactions(List<Completedtransaction> completedtransactions) {
        this.completedtransactions = completedtransactions;
    }

    /**
     * @return the transactionoffers
     */
    public List<Transactionoffer> getTransactionoffers() {
        return transactionoffers;
    }

    /**
     * @param transactionoffers the transactionoffers to set
     */
    public void setTransactionoffers(List<Transactionoffer> transactionoffers) {
        this.transactionoffers = transactionoffers;
    }
    
    public void purge(){
        this.setCompletedtransactions(null);
        this.setTransactionoffers(null);
        this.setTransactionrequest(null);
    }
    
    public void prune(){
        for(Completedtransaction compl : this.getCompletedtransactions()){
            compl.prune();
        }
        for(Transactionoffer offer : this.getTransactionoffers()){
            offer.prune();
        }
        this.getTransactionrequest().prune();
    }

}
