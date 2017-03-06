package com.online_exchange.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Exchanger implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "STATE", nullable = false)
    private String state = State.ACTIVE.getState();

    @OneToMany(mappedBy = "exchanger")
    private List<Completedtransaction> completedtransactions;

    @OneToMany(mappedBy = "exchanger")
    private List<Transactionoffer> transactionoffers;

    public Exchanger() {
    }

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
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
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

    public void purge() {
        this.setCompletedtransactions(null);
        this.setTransactionoffers(null);
    }

    public void prune() {
        for(Completedtransaction compl : this.getCompletedtransactions()){
            compl.prune();
        }
        for(Transactionoffer offer : this.getTransactionoffers()){
            offer.prune();
        }
    }

}
