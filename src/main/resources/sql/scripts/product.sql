create table product
(
    product_id          int auto_increment
        primary key,
    product_name        varchar(255)  not null,
    product_category    varchar(32)   not null,
    product_image_url   varchar(256)  not null,
    product_price       int           not null,
    product_stock       int           not null,
    product_description varchar(1024) null,
    created_date        timestamp     not null,
    last_modified_date  timestamp     not null
);

