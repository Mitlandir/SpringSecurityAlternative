/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.online_exchange.model;


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
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author re5pect
 */
@Entity
@Table(name = "completedtransaction")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Completedtransaction.findAll", query = "SELECT c FROM Completedtransaction c"),
    @NamedQuery(name = "Completedtransaction.findById", query = "SELECT c FROM Completedtransaction c WHERE c.id = :id"),
    @NamedQuery(name = "Completedtransaction.findByAmount", query = "SELECT c FROM Completedtransaction c WHERE c.amount = :amount"),
    @NamedQuery(name = "Completedtransaction.findByRate", query = "SELECT c FROM Completedtransaction c WHERE c.rate = :rate")})
public class Completedtransaction implements Serializable {

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
    @JoinColumn(name = "exchanger_id", referencedColumnName = "id")
    @ManyToOne
    private User exchanger;
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    @ManyToOne
    private User client;
    @Transient
    private Transactionoffer transactionoffer;

    public Completedtransaction() {
    }

    public Completedtransaction(Integer id) {
        this.id = id;
    }

    public Completedtransaction(Integer id, double amount, double rate) {
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

    public User getExchanger() {
        return exchanger;
    }

    public void setExchanger(User exchanger) {
        this.exchanger = exchanger;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
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
        if (!(object instanceof Completedtransaction)) {
            return false;
        }
        Completedtransaction other = (Completedtransaction) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.online_exchange.model.Completedtransaction[ id=" + id + " ]";
    }
    
    public void purge(){
        this.setClient(null);
        this.setExchanger(null);
    }
    
    public void prune(){
        this.getClient().purge();
        this.getExchanger().purge();
    }

}
