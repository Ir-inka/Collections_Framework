package ru.netology.tournament;
public class NotRegisteredException extends RuntimeException{
    public NotRegisteredException(String msg) {
        super(msg);
    }
}