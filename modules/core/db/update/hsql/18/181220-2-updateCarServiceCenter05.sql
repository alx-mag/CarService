alter table CARSERVICE_CAR_SERVICE_CENTER add constraint FK_CARSERVICE_CAR_SERVICE_CENTER_ON_CREATOR foreign key (CREATOR_ID) references SEC_USER(ID);
create index IDX_CARSERVICE_CAR_SERVICE_CENTER_ON_CREATOR on CARSERVICE_CAR_SERVICE_CENTER (CREATOR_ID);
