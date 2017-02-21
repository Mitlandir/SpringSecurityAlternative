package com.online_exchange.model;

import java.util.List;

public class RequestDto {
    
    private Transactionrequest object;
    private List<Transactionrequest> list;
    private String message;
    
    public RequestDto(){}
    
    public RequestDto(Transactionrequest object){
        this.object = object;
    }
    
    public RequestDto(List<Transactionrequest> list){
        this.list = list;
    }
    
    public RequestDto(String message){
        this.message = message;
    }
    
    public void addToList(Transactionrequest object){
        this.list.add(object);
    }

    /**
     * @return the object
     */
    public Transactionrequest getObject() {
        return object;
    }

    /**
     * @param object the object to set
     */
    public void setObject(Transactionrequest object) {
        this.object = object;
    }

    /**
     * @return the list
     */
    public List<Transactionrequest> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<Transactionrequest> list) {
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
