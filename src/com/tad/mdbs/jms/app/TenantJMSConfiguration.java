package com.tad.mdbs.jms.app;

import com.tad.mdbs.jms.config.JMSConfiguration;
import com.tad.mdbs.jms.config.JMSListenerConfiguration;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;

public class TenantJMSConfiguration implements JMSListenerConfiguration {
    public TenantJMSConfiguration(Destination d) {

    }

    @Override
    public JMSListenerConfiguration to(Destination... destinations) {
        return this;
    }

    @Override
    public JMSListenerConfiguration supportedTypes(Class<?>... classes) {
        return this;
    }

    @Override
    public JMSListenerConfiguration acknowledgeMode(int acknowledgeMode) {
        return this;
    }

    @Override
    public JMSListenerConfiguration messageSelector(String messageSelector) {
        return this;
    }

    @Override
    public JMSListenerConfiguration connectionFactory(ConnectionFactory connectionFactory) {
        return this;
    }

    @Override
    public JMSConfiguration up() {
        return null;
    }
}
