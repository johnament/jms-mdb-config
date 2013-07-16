package com.tad.mdbs.jms.config;

import com.tad.mdbs.jms.listener.JMSListener;

/**
 * Sets up configuration for listeners.
 *
 * Conceptually, two versions are supported - a class version and an instance version.
 * I would suspect that a third one, using some kind of listener factory could also be introduced.
 *
 */
public interface JMSConfiguration {

    /**
     * begins setting up a listener based on a listener class.
     *
     * When use listener classes, you can have contextual instances available (e.g. DI works).
     * The instance could be RequestScoped or ApplicationScoped (singleton), depending on how annotated
     *
     * @param clazz
     * @return
     */
    public JMSListenerConfiguration createListener(Class<? extends JMSListener<?>> clazz);

    /**
     * This version supports an instance of a listener.  This could be a SAM or a full instantiated version.
     * Either way, this listener is intended to be a singleton.
     *
     * @param listener
     * @return
     */
    public JMSListenerConfiguration createListener(JMSListener<?> listener);

    /**
     * Assumes that a fully created configuration is passed in and can be used.
     *
     * @param jmsListenerConfiguration
     * @return
     */
    public JMSConfiguration addListenerConfiguration(JMSListenerConfiguration jmsListenerConfiguration);
}
