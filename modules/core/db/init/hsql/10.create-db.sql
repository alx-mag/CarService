-- begin CARSERVICE_CITY
create table CARSERVICE_CITY (
    ID varchar(36) not null,
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
    DEFAULT_CITY boolean not null,
    --
    primary key (ID)
)^
-- end CARSERVICE_CITY
-- begin CARSERVICE_REPAIR
create table CARSERVICE_REPAIR (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    DESCRIPTION varchar(255),
    CENTER_ID varchar(36),
    --
    primary key (ID)
)^
-- end CARSERVICE_REPAIR
-- begin CARSERVICE_CUSTOMER
create table CARSERVICE_CUSTOMER (
    ID varchar(36) not null,
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
-- begin CARSERVICE_EMPLOYEE
create table CARSERVICE_EMPLOYEE (
    ID varchar(36) not null,
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
    CENTER_ID varchar(36),
    --
    primary key (ID)
)^
-- end CARSERVICE_EMPLOYEE
-- begin CARSERVICE_INDIVIDUAL
create table CARSERVICE_INDIVIDUAL (
    ID varchar(36) not null,
    --
    PASSPORT_NO varchar(255) not null,
    --
    primary key (ID)
)^
-- end CARSERVICE_INDIVIDUAL
-- begin CARSERVICE_COMPANY
create table CARSERVICE_COMPANY (
    ID varchar(36) not null,
    --
    INN varchar(12) not null,
    --
    primary key (ID)
)^
-- end CARSERVICE_COMPANY
-- begin CARSERVICE_CAR_SERVICE_CENTER
create table CARSERVICE_CAR_SERVICE_CENTER (
    ID varchar(36) not null,
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
    CITY_ID varchar(36),
    --
    primary key (ID)
)^
-- end CARSERVICE_CAR_SERVICE_CENTER
-- begin CARSERVICE_REPAIR_EMPLOYEE_LINK
create table CARSERVICE_REPAIR_EMPLOYEE_LINK (
    EMPLOYEE_ID varchar(36) not null,
    REPAIR_ID varchar(36) not null,
    primary key (EMPLOYEE_ID, REPAIR_ID)
)^
-- end CARSERVICE_REPAIR_EMPLOYEE_LINK
-- begin CARSERVICE_CAR_SERVICE_CENTER_CUSTOMER_LINK
create table CARSERVICE_CAR_SERVICE_CENTER_CUSTOMER_LINK (
    CAR_SERVICE_CENTER_ID varchar(36) not null,
    CUSTOMER_ID varchar(36) not null,
    primary key (CAR_SERVICE_CENTER_ID, CUSTOMER_ID)
)^
-- end CARSERVICE_CAR_SERVICE_CENTER_CUSTOMER_LINK
