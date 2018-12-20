package com.company.carservice.core;

import com.company.carservice.entity.Employee;
import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.Transaction;
import com.haulmont.cuba.core.app.EmailerAPI;
import com.haulmont.cuba.core.global.EmailInfo;
import com.haulmont.cuba.core.global.Scripting;
import groovy.lang.Binding;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

@Component("carservice_EmployeeWorkerMBean")
public class EmployeeWorkerMBeanImpl implements EmployeeWorkerMBean
{
    @Inject
    private Persistence persistence;

    @Inject
    private Scripting scripting;

    @Inject
    private EmailerAPI emailerAPI;

    @Override
    public String sendGreetings() {
        List<Employee> employees = getBirthdayEmployees();
        employees.forEach(this::sendGreetings);
        return String.format("Sent for (%d) employees", employees.size());
    }

    private void sendGreetings(Employee employee) {
        String emailText = createGreetingText(employee);
        EmailInfo emailInfo = new EmailInfo(employee.getEmail(), "С днём рождения!", emailText);

        emailerAPI.sendEmailAsync(emailInfo);
    }

    private String createGreetingText(Employee employee) {
        Binding scriptParams = new Binding();
        scriptParams.setVariable("recipient", String.format("%s %s", employee.getFirstName(), employee.getLastName()));
        scriptParams.setVariable("age", getEmployeeAge(employee));
        return scripting.runGroovyScript("com/company/carservice/GreetingText.groovy", scriptParams);
    }

    private int getEmployeeAge(Employee employee) {
        int currYear = LocalDate.now().getYear();
        Calendar empBirthday = Calendar.getInstance();
        empBirthday.setTime(employee.getBirthDate());
        return currYear - empBirthday.get(Calendar.YEAR);
    }

    private List<Employee> getBirthdayEmployees() {
        Binding params = new Binding();
        params.setVariable("table", Employee.TABLE);
        params.setVariable("column", "BIRTH_DATE");
        String query = scripting.runGroovyScript("com/company/carservice/BirthdayEmployeesSQL.groovy", params);
        try (Transaction tx = persistence.createTransaction()) {
            return persistence.getEntityManager()
                    .createNativeQuery(query, Employee.class)
                    .getResultList();
        }

    }
}
