package com.example.demo.work;

public class WorkExecutorException extends Exception {

    public WorkExecutorException(String msg, Exception e) {super(msg, e);}

    public WorkExecutorException(String msg) { super(msg);}
}
