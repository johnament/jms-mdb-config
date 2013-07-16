package com.tad.mdbs.jms.config;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;

/**
 * Defines configuration for setting up listeners.
 *
 * This class would have similar properties to ActivationConfigProperty, specific to JMS.
 *
 * Probably also needs getters.  Developers should be free to create adhoc implementations to fit their needs.
 *
 */
public interface JMSListenerConfiguration {

    /**
     * Specifies what destinations this listener can listen to.  A single listener can be bound to multiple destinations.
     *
     * @param destinations
     * @return
     */
    public JMSListenerConfiguration to(Destination... destinations);

    /**
     * Specifies what types of bodies and messages can be sent to this listener, based on standard mappings, e.g
     *
     * TextMessage -> String
     * ObjectMessage -> Serializable
     *
     * etc
     *
     * If not specified, this is inferred based on the type of listener configured (e.g. if it's typed to String, Strings and TextMessages will be forwarded).
     *
     * In a way, this acts as a selector, but on the type (e.g. a message of the wrong type should not be delivered here).
     *
     * @param classes
     * @return
     */
    public JMSListenerConfiguration supportedTypes(Class<?>...classes);

    /**
     * Configures the acknowledge mode
     *
     * @param acknowledgeMode
     * @return
     */
    public JMSListenerConfiguration acknowledgeMode(int acknowledgeMode);

    /**
     * Configures the message selector
     *
      * @param messageSelector
     * @return
     */
    public JMSListenerConfiguration messageSelector(String messageSelector);

    /**
     * Configures the connection factory
     *
     * @param connectionFactory
     * @return
     */
    public JMSListenerConfiguration connectionFactory(ConnectionFactory connectionFactory);


    /**
     * Mostly for method chaining, allows you to go back to the parent JMSConfiguration to setup your next listener.
     *
     * @return
     */
    public JMSConfiguration up();
}
