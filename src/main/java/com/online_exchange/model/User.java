package com.online_exchange.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "APP_USER")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "SSO_ID", unique = true, nullable = false)
    private String ssoId;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "STATE", nullable = false)
    private String state = State.ACTIVE.getState();

    @OneToMany(mappedBy = "client")
    @JsonBackReference
    private List<Transactionrequest> transactionrequests;

    @OneToMany(mappedBy = "exchanger")
    @JsonBackReference
    private List<Completedtransaction> completedtransactionsExchanger;

    @OneToMany(mappedBy = "client")
    @JsonBackReference
    private List<Completedtransaction> completedtransactionsClient;

    @OneToMany(mappedBy = "client")
    @JsonBackReference
    private List<Transactionoffer> transactionoffersClient;
    @OneToMany(mappedBy = "exchanger")
    @JsonBackReference
    private List<Transactionoffer> transactionoffersExchanger;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "APP_USER_USER_PROFILE",
            joinColumns = {
                @JoinColumn(name = "USER_ID")},
            inverseJoinColumns = {
                @JoinColumn(name = "USER_PROFILE_ID")})
    private List<UserProfile> userProfiles = new ArrayList<UserProfile>();

    public User() {
    }

    public User(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((ssoId == null) ? 0 : ssoId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof User)) {
            return false;
        }
        User other = (User) obj;
        if (id != other.id) {
            return false;
        }
        if (ssoId == null) {
            if (other.ssoId != null) {
                return false;
            }
        } else if (!ssoId.equals(other.ssoId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", ssoId=" + ssoId + ", password=" + password
                + ", firstName=" + firstName + ", lastName=" + lastName
                + ", email=" + email + ", state=" + state + ", userProfiles=" + userProfiles + "]";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSsoId() {
        return ssoId;
    }

    public void setSsoId(String ssoId) {
        this.ssoId = ssoId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<UserProfile> getUserProfiles() {
        return userProfiles;
    }

    public void setUserProfiles(List<UserProfile> userProfiles) {
        this.userProfiles = userProfiles;
    }

    public List<Transactionrequest> getTransactionrequests() {
        return transactionrequests;
    }

    public void setTransactionrequests(List<Transactionrequest> transactionrequests) {
        this.transactionrequests = transactionrequests;
    }

    public void setCompletedtransactionsClient(List<Completedtransaction> completedtransactionsClient) {
        this.completedtransactionsClient = completedtransactionsClient;
    }

    public List<Transactionoffer> getTransactionoffersClient() {
        return transactionoffersClient;
    }

    public void setTransactionoffersClient(List<Transactionoffer> transactionoffersClient) {
        this.transactionoffersClient = transactionoffersClient;
    }

    /**
     * @return the transactionoffersExchanger
     */
    public List<Transactionoffer> getTransactionoffersExchanger() {
        return transactionoffersExchanger;
    }

    /**
     * @param transactionoffersExchanger the transactionoffersExchanger to set
     */
    public void setTransactionoffersExchanger(List<Transactionoffer> transactionoffersExchanger) {
        this.transactionoffersExchanger = transactionoffersExchanger;
    }

    /**
     * @return the completedtransactionsClient
     */
    public List<Completedtransaction> getCompletedtransactionsClient() {
        return completedtransactionsClient;
    }

    /**
     * @return the completedtransactionsExchanger
     */
    public List<Completedtransaction> getCompletedtransactionsExchanger() {
        return completedtransactionsExchanger;
    }

    /**
     * @param completedtransactionsExchanger the completedtransactionsExchanger
     * to set
     */
    public void setCompletedtransactionsExchanger(List<Completedtransaction> completedtransactionsExchanger) {
        this.completedtransactionsExchanger = completedtransactionsExchanger;
    }

    public void purge() {
        this.setCompletedtransactionsClient(null);
        this.setCompletedtransactionsExchanger(null);
        this.setTransactionoffersClient(null);
        this.setTransactionoffersExchanger(null);
        this.setTransactionrequests(null);
    }

    public void prune() {

    }

}
