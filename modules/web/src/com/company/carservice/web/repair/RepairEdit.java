package com.company.carservice.web.repair;

import com.haulmont.cuba.gui.screen.*;
import com.company.carservice.entity.Repair;


@UiController("carservice_Repair.edit")
@UiDescriptor("repair-edit.xml")
@EditedEntityContainer("repairDc")
@LoadDataBeforeShow
public class RepairEdit extends StandardEditor<Repair> {
}