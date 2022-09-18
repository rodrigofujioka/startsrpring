package br.tabajara.api.exceptions;

public class GenericExceptionStart extends RuntimeException{

    protected final Integer status;

    public GenericExceptionStart(String message, int statusCode){
        super(message);
        this.status = statusCode;
    }

    public Integer getStatus() {
        return status;
    }
}
