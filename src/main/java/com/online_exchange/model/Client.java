package com.online_exchange.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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

    @OneToOne(mappedBy = "client")
    private User user;
    
    private String testProperty;

    public Client() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Transactionrequest getTransactionrequest() {
        return transactionrequest;
    }

    public void setTransactionrequest(Transactionrequest transactionrequest) {
        this.transactionrequest = transactionrequest;
    }

    public List<Completedtransaction> getCompletedtransactions() {
        return completedtransactions;
    }

    public void setCompletedtransactions(List<Completedtransaction> completedtransactions) {
        this.completedtransactions = completedtransactions;
    }

    public List<Transactionoffer> getTransactionoffers() {
        return transactionoffers;
    }

    public void setTransactionoffers(List<Transactionoffer> transactionoffers) {
        this.transactionoffers = transactionoffers;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void purge() {
        this.setCompletedtransactions(null);
        this.setTransactionoffers(null);
        this.setTransactionrequest(null);
        this.setUser(null);
    }

    public void prune() {
        for (Completedtransaction compl : this.getCompletedtransactions()) {
            compl.purge();
        }
        for (Transactionoffer offer : this.getTransactionoffers()) {
            offer.purge();
        }
        this.getTransactionrequest().prune();
    }

    /**
     * @return the testProperty
     */
    public String getTestProperty() {
        return testProperty;
    }

    /**
     * @param testProperty the testProperty to set
     */
    public void setTestProperty(String testProperty) {
        this.testProperty = testProperty;
    }

}
