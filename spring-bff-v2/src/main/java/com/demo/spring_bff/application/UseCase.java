package com.demo.spring_bff.application;

public abstract class UseCase <IN, OUT>{

    public abstract OUT execute(IN input);
}
