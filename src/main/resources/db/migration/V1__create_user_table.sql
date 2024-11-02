create table user_account
(
    id          uuid primary key,
    email       text not null unique,
    password    text not null
);