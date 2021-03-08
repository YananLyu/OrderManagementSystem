create table oms_authorities
(
    id          bigint auto_increment
        primary key,
    authorities varchar(255) not null,
    user_id     bigint       not null
)
    comment '角色表/权限表';

create table oms_express_tracking
(
    id          bigint auto_increment
        primary key,
    order_id    bigint                             not null comment '订单ID',
    tracking_id bigint                             not null comment '订单ID',
    create_time datetime default CURRENT_TIMESTAMP not null,
    create_user bigint                             null,
    update_user bigint                             null,
    update_time datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '更新时间'
)
    comment '快递信息表';

create table oms_order
(
    id          bigint auto_increment
        primary key,
    user_id     bigint                             not null comment '用户ID',
    sku_id      bigint                             not null comment '产品ID',
    quantity    bigint                             not null comment '数量',
    create_time datetime default CURRENT_TIMESTAMP not null,
    create_user bigint                             null,
    update_user bigint                             null,
    update_time datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '更新时间'
)
    comment '订单';

create table oms_payment
(
    id           bigint auto_increment
        primary key,
    payment_id   bigint                             not null comment '请求回款的ID',
    user_id      bigint                             not null comment '用户ID',
    expect_time  datetime                           null comment '期望支付日期',
    amount_money decimal                            not null comment '要支付的金额',
    status       tinyint  default 1                 not null comment 'payment状态',
    create_time  datetime default CURRENT_TIMESTAMP not null comment '创建日期',
    create_user  bigint                             null comment '创建表的用户',
    update_user  bigint                             null comment '更新表的用户',
    update_time  datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '更新时间'
)
    comment '支付信息表';

create table oms_payment_order
(
    id          bigint auto_increment
        primary key,
    payment_id  bigint                             not null comment '请求回款的ID',
    order_id    bigint                             not null comment '订单ID',
    create_time datetime default CURRENT_TIMESTAMP not null comment '创建日期',
    create_user bigint                             null comment '创建表的用户',
    update_user bigint                             null comment '更新表的用户',
    update_time datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '更新时间'
)
    comment 'payment_order表';

create table oms_sku
(
    id              bigint auto_increment
        primary key,
    commission_id   bigint                             not null comment 'order_id, 该产品被该order买走',
    platform_seller varchar(50)                        not null comment '销售、购买平台',
    product_name    varchar(50)                        not null comment '产品名',
    link            varchar(255)                       not null comment '产品购买链接',
    quantity        bigint                             not null comment '数量',
    unit_price      decimal                            not null comment '原价/单价',
    discount_price  decimal                            not null comment '优惠价',
    create_time     datetime default CURRENT_TIMESTAMP not null comment '商品创建日期',
    expire_time     datetime                           null comment '商品过期日期',
    create_user     bigint                             null comment '该商品创建者的user_id',
    update_user     bigint                             null comment '该商品更新者的user_id',
    update_time     datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '更新时间'
)
    comment '产品表';

create table oms_user
(
    id       bigint auto_increment
        primary key,
    email    varchar(50)       not null,
    password varchar(50)       not null,
    enable   tinyint default 1 not null
)
    comment '用户基本信息';

create table oms_user_info
(
    id           bigint auto_increment
        primary key,
    first_name   varchar(50)                        not null,
    last_name    varchar(50)                        null,
    wechat_name  varchar(50)                        null,
    phone_number bigint                             null,
    wechat_ID    varchar(50)                        null,
    user_id      bigint                             not null,
    create_time  datetime default CURRENT_TIMESTAMP null,
    create_user  bigint                             null,
    update_user  bigint                             null,
    update_time  datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '更新时间'
)
    comment '用户信息表';

