/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.online_exchange.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author re5pect
 */
@Entity
@Table(name = "transactionrequest")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transactionrequest.findAll", query = "SELECT t FROM Transactionrequest t"),
    @NamedQuery(name = "Transactionrequest.findById", query = "SELECT t FROM Transactionrequest t WHERE t.id = :id"),
    @NamedQuery(name = "Transactionrequest.findByAmount", query = "SELECT t FROM Transactionrequest t WHERE t.amount = :amount"),
    @NamedQuery(name = "Transactionrequest.findByRate", query = "SELECT t FROM Transactionrequest t WHERE t.rate = :rate")})
public class Transactionrequest implements Serializable {

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
    @OneToMany(mappedBy = "transactionRequest")
    @JsonBackReference
    private Collection<Transactionoffer> transactionofferCollection;
    @Transient
    private boolean alreadyOffered = false;

    public Transactionrequest() {
    }

    public Transactionrequest(Integer id) {
        this.id = id;
    }

    public Transactionrequest(Integer id, double amount, double rate) {
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

    @XmlTransient
    public Collection<Transactionoffer> getTransactionofferCollection() {
        return transactionofferCollection;
    }

    public void setTransactionofferCollection(Collection<Transactionoffer> transactionofferCollection) {
        this.transactionofferCollection = transactionofferCollection;
    }
    
    public void addTransactionoffer(Transactionoffer offer){
        this.transactionofferCollection.add(offer);
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
        if (!(object instanceof Transactionrequest)) {
            return false;
        }
        Transactionrequest other = (Transactionrequest) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.online_exchange.model.Transactionrequest[ id=" + id + " ]";
    }

    /**
     * @return the alreadyOffered
     */
    public boolean isAlreadyOffered() {
        return alreadyOffered;
    }

    /**
     * @param alreadyOffered the alreadyOffered to set
     */
    public void setAlreadyOffered(boolean alreadyOffered) {
        this.alreadyOffered = alreadyOffered;
    }
    
}
