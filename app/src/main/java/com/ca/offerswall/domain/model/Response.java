package com.ca.offerswall.domain.model;

public abstract class Response<T> {
    T data;
    Throwable exception;
    public static class Success<T> extends Response<T>{
        public Success(T successData) {
            this.data =  successData;
        }
    }

    public static class Error<T> extends Response<T>{
        public Error(Throwable exception, T errorData) {
            this.exception = exception;
        }
    }

    public T getData() {
        return data;
    }

    public Throwable getException() {
        return exception;
    }
}
