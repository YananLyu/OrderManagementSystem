create table mms_authorities
(
    id          bigint auto_increment
        primary key,
    authorities varchar(255) not null,
    user_id     bigint       not null
)
    comment '角色表/权限表';

create table mms_user
(
    id       bigint auto_increment
        primary key,
    email    varchar(50)       not null,
    password varchar(50)       not null,
    enable   tinyint default 1 not null
)
    comment '用户基本信息';

create table mms_user_info
(
    id           bigint auto_increment
        primary key,
    user_id      bigint                             not null comment '用户ID',
    first_name   varchar(50)                        not null,
    last_name    varchar(50)                        null,
    wechat_name  varchar(50)                        null,
    phone_number varchar(13)                        null,
    wechat_ID    varchar(50)                        null,
    create_time  datetime default CURRENT_TIMESTAMP null,
    create_user  bigint                             null,
    update_user  bigint                             null,
    update_time  datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '更新时间'
)
    comment '用户详细信息表';

create table oms_express_tracking
(
    id              bigint auto_increment
        primary key,
    order_id        bigint                             not null comment '订单ID',
    tracking_number varchar(32)                        not null comment 'Tracking number',
    create_time     datetime default CURRENT_TIMESTAMP not null,
    create_user     bigint                             null,
    update_user     bigint                             null,
    update_time     datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '更新时间'
)
    comment '快递信息表。 1:m，一个订单可以对应多个tracking number， order_id是外键，对应oms_order中的id';

create table oms_order
(
    id                 bigint auto_increment comment '订单ID'
        primary key,
    user_id            bigint                             not null comment '用户ID',
    sku_create_user_id bigint                             null comment '该商品创建者的user_id',
    sku_id             bigint                             not null comment 'Offer ID',
    inventory_id       bigint                             not null comment '邮寄地址ID',
    total_amount       decimal(10, 2)                     null comment '订单总金额',
    pay_amount         decimal(10, 2)                     null comment '返款金额（商品金额 + 佣金bonus）',
    refund_status      tinyint  default -1                not null comment '返款状态.-1：not requested, 0->requested，1->confirmed, 2->rejected',
    quantity           bigint                             not null comment '下单数量',
    order_status       int                                null comment '订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单',
    note               varchar(500)                       null comment '订单备注',
    platform_seller    varchar(50)                        not null comment '销售、购买平台',
    product_name       varchar(50)                        not null comment '产品名',
    product_link       varchar(1000)                      not null comment '产品购买链接',
    unit_price         decimal(10, 2)                     not null comment '原价/单价',
    commission_bonus   decimal(10, 2)                     not null comment '佣金',
    receiver_line1     varchar(32)                        not null comment '地址1',
    receiver_line2     varchar(32)                        null comment '地址2',
    receiver_city      varchar(32)                        not null comment '城市',
    receiver_state     varchar(32)                        not null comment '州',
    receiver_zipcode   varchar(5)                         not null comment '邮编',
    receiver_country   varchar(32)                        null comment '国家',
    create_time        datetime default CURRENT_TIMESTAMP not null,
    create_user        bigint                             null,
    update_user        bigint                             null,
    update_time        datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '更新时间'
)
    comment '订单表';

create table oms_payment
(
    id             bigint auto_increment
        primary key,
    payment_id     bigint                             not null comment '请求回款的ID',
    user_id        bigint                             not null comment '用户ID',
    expect_time    datetime                           null comment '期望支付日期',
    amount_money   decimal(10, 2)                     not null comment '要支付的金额',
    payment_status tinyint  default 0                 not null comment 'payment状态. 0->requested，1->confirmed, 2->rejected',
    create_time    datetime default CURRENT_TIMESTAMP not null comment '创建日期',
    create_user    bigint                             null comment '创建表的用户',
    update_user    bigint                             null comment '更新表的用户',
    update_time    datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '更新时间'
)
    comment '支付信息表. 1:m, 该表对应多个payment_order';

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

create table pms_inventory
(
    id           bigint auto_increment
        primary key,
    addr_type    tinyint(1) default 0                 not null comment '2: admin 地址， 1： mod 地址， 0： user 地址',
    addr_line1   varchar(255)                         not null comment '地址1',
    addr_line2   varchar(255)                         null comment '地址2',
    addr_city    varchar(20)                          not null comment '城市',
    addr_state   varchar(20)                          not null comment '州',
    addr_zipcode varchar(5)                           not null comment '邮编',
    addr_country varchar(20)                          null comment '国家',
    create_user  bigint                               null comment '创建者的user_id',
    update_user  bigint                               null comment '更新者的user_id',
    create_time  datetime   default CURRENT_TIMESTAMP null comment '创建时间',
    update_time  datetime   default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '更新时间'
)
    comment '仓库 表';

create table pms_sku
(
    id               bigint auto_increment
        primary key,
    spu_id           bigint                               not null comment 'product id, 外键',
    inventory_id     bigint                               not null comment '仓库ID，表示可以下单到哪些仓库',
    unit_price       decimal(10, 2)                       not null comment '原价/单价',
    commission_bonus decimal(10, 2)                       not null comment '佣金',
    quantity         bigint                               not null comment '需求数量',
    quantity_left    bigint                               not null comment '剩余数量，库存',
    offer_status     tinyint(1) default 1                 not null comment 'offer/task有效状态，false代表无效',
    offer_note       varchar(255)                         null comment '该offer的备注或注释',
    expire_time      datetime                             null comment 'offer过期日期',
    create_time      datetime   default CURRENT_TIMESTAMP not null comment 'offer创建日期',
    update_time      datetime   default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment 'offer更新时间',
    create_user      bigint                               null comment '该offer创建者的user_id',
    update_user      bigint                               null comment '该offer更新者的user_id'
)
    comment 'sku 表 即 offer 表';

create table pms_sku_inventory
(
    id           bigint auto_increment
        primary key,
    sku_id       bigint not null comment '商品sku_id',
    inventory_id bigint not null comment '仓库inventory_id'
)
    comment '商品_仓库表  （多对多中间表）';

create table pms_spu
(
    id              bigint auto_increment
        primary key,
    platform_seller varchar(50)                        not null comment '销售、购买平台',
    product_name    varchar(50)                        not null comment '产品名',
    product_link    varchar(1000)                      not null comment '产品购买链接',
    create_user     bigint                             null comment '该商品创建者的user_id',
    update_user     bigint                             null comment '该商品更新者的user_id',
    create_time     datetime default CURRENT_TIMESTAMP not null comment '商品创建日期',
    update_time     datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '更新时间'
)
    comment 'spu表 即 产品表';

