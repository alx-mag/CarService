update CARSERVICE_CITY set DEFAULT_CITY = false where DEFAULT_CITY is null ;
alter table CARSERVICE_CITY alter column DEFAULT_CITY set not null ;
