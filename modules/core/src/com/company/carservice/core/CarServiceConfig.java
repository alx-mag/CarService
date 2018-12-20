package com.company.carservice.core;

import com.haulmont.cuba.core.config.Config;
import com.haulmont.cuba.core.config.Property;
import com.haulmont.cuba.core.config.Source;
import com.haulmont.cuba.core.config.SourceType;

@Source(type = SourceType.DATABASE)
public interface CarServiceConfig extends Config {

    @Property("cuba.email.smtpHost")
    String getSmtpHost();

    @Property("cuba.email.fromAddress")
    String getSenderEmail();
}
