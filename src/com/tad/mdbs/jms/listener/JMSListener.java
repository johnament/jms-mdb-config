package com.tad.mdbs.jms.listener;

public interface JMSListener<T> {
    public void onMessage(T message);
}
