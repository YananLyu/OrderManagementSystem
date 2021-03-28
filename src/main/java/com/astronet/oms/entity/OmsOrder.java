package com.astronet.oms.entity;

/**
 * @author: Yanan Lyu
 * @date 3/2/21 5:09 PM
 */

import com.astronet.oms.entity.auditor.Auditable;
import com.astronet.oms.enums.InboundStatusEnum;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

/**
 * @author Yanan Lyu
 * @Entity 注解该类为数据库表实体类，JPA可自动扫描识别到
 * @Table 注解数据表信息，其中name指定表名
 * @DynamicInsert 表示动态插入，如果某字段为空，那么使用数据库中配置的默认值，也可以在实体类中设置默认值
 * @Data 注在类上，提供类的get、set、equals、hashCode、canEqual、toString方法
 * @AllArgsConstructor ： 注在类上，提供类的全参构造
 * @NoArgsConstructor ： 注在类上，提供类的无参构造
 */

@Builder
@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@DynamicInsert
@Entity
@Table(name = "oms_order")
public class OmsOrder extends Auditable<String> {

    /**
     * ID，唯一主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * super_order_id
     * 默认为null，代表无super order id
     */
    @Column(name = "super_order_id")
    private Long super_order_id;

    /**
     * 订单状态
     * 订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单
     */
    @NotNull
    @Column(name = "order_status")
    private InboundStatusEnum orderStatus;

    /**
     * user_id
     * M：1，一个user_id 可以对应多个order，一个order只能对应一个user
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    /**
     * user name, 用户名字
     */
    @NotBlank
    @Size(max = 20)
    @Column(name = "user_name")
    private String username;

    /**
     * 订单总金额,即买家在该订单上花的钱
     */
    @Min(0)
    @NotNull
    @Column(name = "total_amount", precision = 10, scale = 2)
    private BigDecimal totalAmount;

    /**
     * 应该给买家返款的钱，商品金额+佣金
     */
    @Min(0)
    @NotNull
    @Column(name = "refund_amount", precision = 10, scale = 2)
    private BigDecimal refundAmount;

    /**
     * 购买的商品数量
     */
    @NotNull
    @Column(name = "quantity")
    private Long quantity;

    /** ***************************************************************************************************************
     * 以下为商品/sku创建者信息 + 收获产品/sku,spu的信息冗余。
     * order一旦生成，则不允许被动的改变
     * order一旦完成，主动的改变也不允许。应该处于一个archive的状态
     * ****************************************************************************************************************
     */

    /**
     * 该商品创建者的user_id
     * sku_created_by_user_id
     * 冗余数据，最好不要跟其它表通过外键相连
     */
    @Column(name = "sku_created_by_user_id")
    private Long skuCreatedByUserId;

    /**
     * 该商品创建者的用户名
     */
    @NotBlank
    @Size(max = 20)
    @Column(name = "sku_created_by_user_name")
    private String skuCreatedByUserName;

    /**
     * sku_id
     * 冗余备份数据最好不要跟其它表有外键关联
     */
    @Column(name = "sku_id")
    private Long skuId;

    /**
     * 产品销售平台
     */
    @Size(max = 50)
    @Column(name = "platform_seller")
    private String platformSeller;

    /**
     * 产品名称
     */
    @Size(max = 50)
    @Column(name = "product_name")
    private String productName;

    /**
     * 产品购买链接
     */
    @NotBlank
    @Size(max = 1000)
    @Column(name = "product_link")
    private String productLink;

    /**
     * 原价/单价
     */
    @Min(0)
    @NotNull
    @Column(name = "unit_price", precision = 10, scale = 2)
    private BigDecimal unitPrice;

    /**
     * 神医回收的价格
     */
    @Min(0)
    @NotNull
    @Column(name = "admin_price", precision = 10, scale = 2)
    private BigDecimal adminPrice;

    /**
     * moderator 中间人给的价格
     */
    @Min(0)
    @Column(name = "mod_price", precision = 10, scale = 2)
    private BigDecimal modPrice;

    /**
     * 该offer的备注或注释
     */
    @Size(max = 255)
    @Column(name = "offer_note")
    private String offerNote;


    /** ***************************************************************************************************************
     * 以下为收获地址的信息冗余。防止地址信息的改变带来的order信息的改变。
     * order一旦生成，则不允许被动的改变
     * order一旦完成，主动的改变也不允许。应该处于一个archive的状态
     * ****************************************************************************************************************
     */

    /**
     * inventory_id
     * inventory_id         bigint                             not null comment '邮寄地址ID',
     * 冗余备份的数据最好不要跟对应的表有外键关联关系
     */
    @Column(name = "inventory_id")
    private Long inventoryId;

    /**
     * offer/product有效状态，
     * 0: SELF_STORAGE, 即user 地址
     * 1: MOD_STORAGE, 即 moderator提供的仓库
     * 2: ADMIN_STORAGE, 即 管理员提供的仓库
     * default value: 0;
     */
    @Column(name = "addr_type", columnDefinition = "TINYINT DEFAULT 0")
    private Integer addrType;

    /**
     * 地址line1
     */
    @NotNull
    @Size(max = 255)
    @Column(name = "addr_line1")
    private String addrLine1;

    /**
     * 地址line2
     */
    @Size(max = 255)
    @Column(name = "addr_line2")
    private String addrLine2;

    /**
     * city
     */
    @NotNull
    @Size(max = 50)
    @Column(name = "addr_city")
    private String addrCity;

    /**
     * state
     */
    @NotNull
    @Size(max = 50)
    @Column(name = "addr_state")
    private String addrState;

    /**
     * zipcode
     */
    @NotNull
    @Size(max = 5)
    @Column(name = "addr_zipcode")
    private String addrZipcode;

    /**
     * country
     */
    @Size(max = 25)
    @Column(name = "addr_country")
    private String addrCountry;
}
