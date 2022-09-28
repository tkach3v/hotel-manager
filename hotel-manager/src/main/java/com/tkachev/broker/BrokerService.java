package com.tkachev.broker;

public interface BrokerService {

    <T> void sendMessage(T entity);
}
