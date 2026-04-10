package com.restapi.api.generics;

public class collectionGeneric<T> {

    private T element;

    public collectionGeneric(T element){
        this.element = element;
    }

    public T getElement(){
        return  this.element;
    }
    
}
