create table CARSERVICE_CUSTOMER (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    DTYPE varchar(100),
    --
    NAME varchar(100) not null,
    EMAIL varchar(50) not null,
    PHONE varchar(255) not null,
    --
    -- from carservice_Individual
    PASSPORT_NO varchar(255) not null,
    --
    -- from carservice_Company
    INN varchar(12) not null,
    --
    primary key (ID)
);