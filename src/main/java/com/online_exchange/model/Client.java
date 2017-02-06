/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.online_exchange.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author re5pect
 */
@Entity
@Table(name = "client")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c"),
    @NamedQuery(name = "Client.findById", query = "SELECT c FROM Client c WHERE c.id = :id"),
    @NamedQuery(name = "Client.findByEmail", query = "SELECT c FROM Client c WHERE c.email = :email"),
    @NamedQuery(name = "Client.findByPassword", query = "SELECT c FROM Client c WHERE c.password = :password")})
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @OneToMany(mappedBy = "client")
    private Collection<Transactionrequest> transactionrequestCollection;
    @OneToMany(mappedBy = "client")
    private Collection<Completedtransaction> completedtransactionCollection;
    @OneToMany(mappedBy = "client")
    private Collection<Transactionoffer> transactionofferCollection;

    public Client() {
    }

    public Client(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlTransient
    public Collection<Transactionrequest> getTransactionrequestCollection() {
        return transactionrequestCollection;
    }

    public void setTransactionrequestCollection(Collection<Transactionrequest> transactionrequestCollection) {
        this.transactionrequestCollection = transactionrequestCollection;
    }

    @XmlTransient
    public Collection<Completedtransaction> getCompletedtransactionCollection() {
        return completedtransactionCollection;
    }

    public void setCompletedtransactionCollection(Collection<Completedtransaction> completedtransactionCollection) {
        this.completedtransactionCollection = completedtransactionCollection;
    }

    @XmlTransient
    public Collection<Transactionoffer> getTransactionofferCollection() {
        return transactionofferCollection;
    }

    public void setTransactionofferCollection(Collection<Transactionoffer> transactionofferCollection) {
        this.transactionofferCollection = transactionofferCollection;
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
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.online_exchange.model.Client[ id=" + id + " ]";
    }
    
}
