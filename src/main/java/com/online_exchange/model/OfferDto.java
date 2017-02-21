package com.online_exchange.model;

import java.util.List;

public class OfferDto {
    
    private Transactionoffer object;
    private List<Transactionoffer> list;
    private String message;
    
    public OfferDto(){}
    
    public OfferDto(Transactionoffer object){
        this.object = object;
    }
    
    public OfferDto(List<Transactionoffer> list){
        this.list = list;
    }
    
    public OfferDto(String message){
        this.message = message;
    }
    
    public void addToList(Transactionoffer object){
        this.list.add(object);
    }

    /**
     * @return the object
     */
    public Transactionoffer getObject() {
        return object;
    }

    /**
     * @param object the object to set
     */
    public void setObject(Transactionoffer object) {
        this.object = object;
    }

    /**
     * @return the list
     */
    public List<Transactionoffer> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<Transactionoffer> list) {
        this.list = list;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }
    
}
