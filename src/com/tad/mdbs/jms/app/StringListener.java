package com.tad.mdbs.jms.app;

import com.tad.mdbs.jms.listener.JMSListener;

import javax.inject.Singleton;

@Singleton
public class StringListener implements JMSListener<String> {
    @Override
    public void onMessage(String message) {
        System.out.println("Just received a message "+message);
    }
}
