package com.company.carservice.web.carservicecenter;

import com.company.carservice.entity.*;
import com.company.carservice.service.CityService;
import com.haulmont.cuba.core.global.MessageTools;
import com.haulmont.cuba.gui.components.AbstractEditor;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.components.TabSheet;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.data.CollectionDatasource;

import javax.inject.Inject;
import java.util.Map;
import java.util.UUID;

public class CarServiceCenterEdit extends AbstractEditor<CarServiceCenter>
{
    @Inject
    private TabSheet tabSheet;

    @Inject
    private Table<Customer> customerTable;

    @Inject
    private MessageTools messageTools;

    @Inject
    private CollectionDatasource<Customer, UUID> customerDs;

    @Inject
    private CityService cityService;

    @Override
    protected void initNewItem(CarServiceCenter item) {
        City defaultCity = cityService.getDefaultCity();
        item.setCity(defaultCity);
    }

    @Override
    public void init(Map<String, Object> params) {
        customerDs.addCollectionChangeListener(event -> initCustomersTabCaption());
        addClientTypeColumn();
    }

    private void addClientTypeColumn() {
        customerTable.addGeneratedColumn("clientType", this::createClientTypeLabel);
        String clientTypeCaption = messageTools.loadString("msg://com.company.carservice.entity/Customer.clientType");
        customerTable.getColumn("clientType").setCaption(clientTypeCaption);
    }

    private Component createClientTypeLabel(Customer customer) {
        return new Table.PlainTextCell(getCustomerLabel(customer));
    }

    private String getCustomerLabel(Customer customer) {
        if (customer instanceof Individual) {
            return messageTools.loadString("msg://com.company.carservice.entity/Individual");
        } else if (customer instanceof Company) {
            return messageTools.loadString("msg://com.company.carservice.entity/Company");
        } else {
            throw new IllegalArgumentException("Unknown customer type");
        }
    }

    @Override
    public void postInit() {
        initCustomersTabCaption();
    }

    private void initCustomersTabCaption() {
        tabSheet.getTab("customersTab").setCaption(String.format("Customers (%d)", customerDs.size()));
    }
}