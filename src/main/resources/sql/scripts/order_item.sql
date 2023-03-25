create table order_item
(
    order_item_id int auto_increment
        primary key,
    order_id      int not null,
    product_id    int not null,
    quantity      int not null,
    amount        int not null
);

