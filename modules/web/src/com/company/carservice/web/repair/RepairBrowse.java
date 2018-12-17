package com.company.carservice.web.repair;

import com.haulmont.cuba.gui.screen.*;
import com.company.carservice.entity.Repair;


@UiController("carservice_Repair.browse")
@UiDescriptor("repair-browse.xml")
@LookupComponent("repairsTable")
@LoadDataBeforeShow
public class RepairBrowse extends StandardLookup<Repair> {
}