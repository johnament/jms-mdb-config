package com.tad.mdbs.jms.config;

import javax.inject.Qualifier;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * A qualifier for an event with the JMS configuration in it, indicating that the application may start up configuration.
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Qualifier
public @interface StartupConfiguration {
}
