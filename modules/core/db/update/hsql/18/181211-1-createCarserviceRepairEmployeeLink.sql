create table CARSERVICE_REPAIR_EMPLOYEE_LINK (
    REPAIR_ID varchar(36) not null,
    EMPLOYEE_ID varchar(36) not null,
    primary key (REPAIR_ID, EMPLOYEE_ID)
);
