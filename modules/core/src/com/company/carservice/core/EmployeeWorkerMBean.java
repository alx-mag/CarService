package com.company.carservice.core;

import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;

@ManagedResource(description = "Performs operations on employers")
public interface EmployeeWorkerMBean
{
    @ManagedOperation(description = "Sends greetings email to all employers who celebrates a birthday today")
    String sendGreetings();
}
