alter table CARSERVICE_EMPLOYEE add constraint FK_CARSERVICE_EMPLOYEE_ON_CENTER foreign key (CENTER_ID) references CARSERVICE_CAR_SERVICE_CENTER(ID);
create unique index IDX_CARSERVICE_EMPLOYEE_UNIQ_FIRST_NAME on CARSERVICE_EMPLOYEE (FIRST_NAME) ;
create unique index IDX_CARSERVICE_EMPLOYEE_UNIQ_LAST_NAME on CARSERVICE_EMPLOYEE (LAST_NAME) ;
create index IDX_CARSERVICE_EMPLOYEE_ON_CENTER on CARSERVICE_EMPLOYEE (CENTER_ID);
