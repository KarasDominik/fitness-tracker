alter table measurement
    add column date timestamp not null default current_timestamp;