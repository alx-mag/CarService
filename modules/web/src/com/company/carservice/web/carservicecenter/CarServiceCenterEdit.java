package com.company.carservice.web.carservicecenter;

import com.company.carservice.entity.City;
import com.company.carservice.entity.Customer;
import com.company.carservice.entity.Employee;
import com.company.carservice.service.CityService;
import com.haulmont.cuba.gui.components.AbstractEditor;
import com.company.carservice.entity.CarServiceCenter;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.components.TabSheet;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.data.CollectionDatasource;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Map;
import java.util.UUID;

public class CarServiceCenterEdit extends AbstractEditor<CarServiceCenter>
{
    @Inject
    private TabSheet tabSheet;

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
    }

    @Override
    public void postInit() {
        initCustomersTabCaption();
    }

    private void initCustomersTabCaption() {
        tabSheet.getTab("customersTab").setCaption(String.format("Customers (%d)", customerDs.size()));
    }
}