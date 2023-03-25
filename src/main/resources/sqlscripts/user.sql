create table user
(
    user_id            int auto_increment
        primary key,
    user_name          varchar(256) not null,
    user_password      varchar(256) not null,
    user_email         varchar(256) not null,
    created_date       timestamp    not null,
    last_modified_date timestamp    not null,
    constraint user_email
        unique (user_email),
    constraint user_name
        unique (user_name)
);

