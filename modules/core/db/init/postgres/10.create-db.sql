-- begin CARSERVICE_CUSTOMER
create table CARSERVICE_CUSTOMER (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    DTYPE varchar(31),
    --
    NAME varchar(100) not null,
    EMAIL varchar(50) not null,
    PHONE varchar(255) not null,
    --
    primary key (ID)
)^
-- end CARSERVICE_CUSTOMER
-- begin CARSERVICE_COMPANY
create table CARSERVICE_COMPANY (
    ID uuid,
    --
    INN varchar(12) not null,
    --
    primary key (ID)
)^
-- end CARSERVICE_COMPANY
-- begin CARSERVICE_INDIVIDUAL
create table CARSERVICE_INDIVIDUAL (
    ID uuid,
    --
    PASSPORT_NO varchar(255) not null,
    --
    primary key (ID)
)^
-- end CARSERVICE_INDIVIDUAL
-- begin CARSERVICE_CITY
create table CARSERVICE_CITY (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    CODE varchar(255) not null,
    --
    primary key (ID)
)^
-- end CARSERVICE_CITY
-- begin CARSERVICE_CAR_SERVICE_CENTER
create table CARSERVICE_CAR_SERVICE_CENTER (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    PHONE varchar(255) not null,
    CITY_ID uuid,
    --
    primary key (ID)
)^
-- end CARSERVICE_CAR_SERVICE_CENTER
-- begin CARSERVICE_EMPLOYEE
create table CARSERVICE_EMPLOYEE (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    FIRST_NAME varchar(255) not null,
    LAST_NAME varchar(255) not null,
    BIRTH_DATE date,
    EMAIL varchar(255),
    SALARY varchar(255),
    CENTER_ID uuid,
    --
    primary key (ID)
)^
-- end CARSERVICE_EMPLOYEE
-- begin CARSERVICE_REPAIR
create table CARSERVICE_REPAIR (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    DESCRIPTION varchar(255),
    CENTER_ID uuid,
    --
    primary key (ID)
)^
-- end CARSERVICE_REPAIR
-- begin CARSERVICE_CAR_SERVICE_CENTER_CUSTOMER_LINK
create table CARSERVICE_CAR_SERVICE_CENTER_CUSTOMER_LINK (
    CAR_SERVICE_CENTER_ID uuid,
    CUSTOMER_ID uuid,
    primary key (CAR_SERVICE_CENTER_ID, CUSTOMER_ID)
)^
-- end CARSERVICE_CAR_SERVICE_CENTER_CUSTOMER_LINK
-- begin CARSERVICE_REPAIR_EMPLOYEE_LINK
create table CARSERVICE_REPAIR_EMPLOYEE_LINK (
    REPAIR_ID uuid,
    EMPLOYEE_ID uuid,
    primary key (REPAIR_ID, EMPLOYEE_ID)
)^
-- end CARSERVICE_REPAIR_EMPLOYEE_LINK
