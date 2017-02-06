/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.online_exchange.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author re5pect
 */
@Entity
@Table(name = "transactionoffer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transactionoffer.findAll", query = "SELECT t FROM Transactionoffer t"),
    @NamedQuery(name = "Transactionoffer.findById", query = "SELECT t FROM Transactionoffer t WHERE t.id = :id"),
    @NamedQuery(name = "Transactionoffer.findByAmount", query = "SELECT t FROM Transactionoffer t WHERE t.amount = :amount"),
    @NamedQuery(name = "Transactionoffer.findByRate", query = "SELECT t FROM Transactionoffer t WHERE t.rate = :rate")})
public class Transactionoffer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "amount")
    private double amount;
    @Basic(optional = false)
    @Column(name = "rate")
    private double rate;
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    @ManyToOne
    private Client client;
    @JoinColumn(name = "transactionRequest_id", referencedColumnName = "id")
    @ManyToOne
    private Transactionrequest transactionRequest;
    @JoinColumn(name = "exchanger_id", referencedColumnName = "id")
    @ManyToOne
    private Exchanger exchanger;

    public Transactionoffer() {
    }

    public Transactionoffer(Integer id) {
        this.id = id;
    }

    public Transactionoffer(Integer id, double amount, double rate) {
        this.id = id;
        this.amount = amount;
        this.rate = rate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Transactionrequest getTransactionRequest() {
        return transactionRequest;
    }

    public void setTransactionRequest(Transactionrequest transactionRequest) {
        this.transactionRequest = transactionRequest;
    }

    public Exchanger getExchanger() {
        return exchanger;
    }

    public void setExchanger(Exchanger exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transactionoffer)) {
            return false;
        }
        Transactionoffer other = (Transactionoffer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.online_exchange.model.Transactionoffer[ id=" + id + " ]";
    }
    
}
