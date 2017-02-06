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
@Table(name = "exchanger")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Exchanger.findAll", query = "SELECT e FROM Exchanger e"),
    @NamedQuery(name = "Exchanger.findById", query = "SELECT e FROM Exchanger e WHERE e.id = :id"),
    @NamedQuery(name = "Exchanger.findByName", query = "SELECT e FROM Exchanger e WHERE e.name = :name"),
    @NamedQuery(name = "Exchanger.findByPassword", query = "SELECT e FROM Exchanger e WHERE e.password = :password")})
public class Exchanger implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "password")
    private String password;
    @OneToMany(mappedBy = "exchanger")
    private Collection<Completedtransaction> completedtransactionCollection;
    @OneToMany(mappedBy = "exchanger")
    private Collection<Transactionoffer> transactionofferCollection;

    public Exchanger() {
    }

    public Exchanger(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        if (!(object instanceof Exchanger)) {
            return false;
        }
        Exchanger other = (Exchanger) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.online_exchange.model.Exchanger[ id=" + id + " ]";
    }
    
}
