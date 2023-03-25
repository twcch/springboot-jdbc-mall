create table `order`
(
    order_id           int auto_increment
        primary key,
    user_id            int       not null,
    total_amount       int       not null,
    created_date       timestamp not null,
    last_modified_date timestamp not null
);

