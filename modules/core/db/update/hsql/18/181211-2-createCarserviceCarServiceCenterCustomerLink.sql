alter table CARSERVICE_CAR_SERVICE_CENTER_CUSTOMER_LINK add constraint FK_CARSERCENCUS_ON_CAR_SERVICE_CENTER foreign key (CAR_SERVICE_CENTER_ID) references CARSERVICE_CAR_SERVICE_CENTER(ID);
alter table CARSERVICE_CAR_SERVICE_CENTER_CUSTOMER_LINK add constraint FK_CARSERCENCUS_ON_CUSTOMER foreign key (CUSTOMER_ID) references CARSERVICE_CUSTOMER(ID);