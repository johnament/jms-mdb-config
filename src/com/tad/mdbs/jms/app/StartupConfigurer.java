package com.tad.mdbs.jms.app;


import com.tad.mdbs.jms.config.JMSConfiguration;
import com.tad.mdbs.jms.config.JMSListenerConfiguration;
import com.tad.mdbs.jms.config.StartupConfiguration;
import com.tad.mdbs.jms.listener.JMSListener;

import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.Session;

@Singleton
public class StartupConfigurer {

    private Destination someQueue;
    private Destination someTopic;

    private Destination anotherQueue;

    @Inject
    private Event<Message> onMessageEvent;

    private JMSConfiguration jmsConfiguration;

    public void setupConfig(@Observes @StartupConfiguration JMSConfiguration jmsConfiguration) {
        // setup a listen using the StringListener class, binding to someQueue.
        jmsConfiguration.createListener(StringListener.class).to(someQueue);

        // create a lambda expression for this listener, which takes all messages and prints them out, functionally what StringListener does.
        JMSListener<Message> messageListener = x -> System.out.println(x);
        jmsConfiguration.createListener(messageListener).to(someTopic);

        // create another lambda, but this time fire events using CDI.
        // even though syntactically this compiles, probably need some CDI spec clarifications about what happens here.
        JMSListener<Message> eventListener = fooMsg -> onMessageEvent.fire(fooMsg);
        jmsConfiguration.createListener(eventListener).to(anotherQueue).acknowledgeMode(Session.AUTO_ACKNOWLEDGE).messageSelector("events='all'");

        this.jmsConfiguration = jmsConfiguration;
    }

    /**
     * Allows the runtime registration of new listeners.
     *
     * @param jmsListenerConfiguration
     */
    public void addJMSListenerConfiguration(JMSListenerConfiguration jmsListenerConfiguration) {
        this.jmsConfiguration.addListenerConfiguration(jmsListenerConfiguration);
    }
}
