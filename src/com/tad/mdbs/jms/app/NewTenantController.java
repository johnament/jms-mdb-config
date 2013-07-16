package com.tad.mdbs.jms.app;

import javax.inject.Inject;
import javax.jms.Destination;

/**
 * Handles setting up new customers in our multitenant system.
 */
public class NewTenantController {

    @Inject
    private StartupConfigurer startupConfigurer;

    public void addCustomer(String tenantName) {
        // do real work.
        Destination d = createTenantDestination(tenantName);
        startupConfigurer.addJMSListenerConfiguration(new TenantJMSConfiguration(d));
    }

    public Destination createTenantDestination(String tenantName) {
        return null; //TODO create a dynamic destination.
    }
}
