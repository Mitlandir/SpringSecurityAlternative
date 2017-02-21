package com.online_exchange.model;

import java.util.List;

public class CompletedDto {
    
    private Completedtransaction object;
    private List<Completedtransaction> list;
    private String message;
    
    public CompletedDto(){}
    
    public CompletedDto(Completedtransaction object){
        this.object = object;
    }
    
    public CompletedDto(List<Completedtransaction> list){
        this.list = list;
    }
    
    public CompletedDto(String message){
        this.message = message;
    }
    
    public void addOToList(Completedtransaction object){
        this.list.add(object);
    }

    /**
     * @return the object
     */
    public Completedtransaction getObject() {
        return object;
    }

    /**
     * @param object the object to set
     */
    public void setObject(Completedtransaction object) {
        this.object = object;
    }

    /**
     * @return the list
     */
    public List<Completedtransaction> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<Completedtransaction> list) {
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
