package com.astronet.oms.entity;

/**
 * @author: Yanan Lyu
 * @date 3/2/21 5:09 PM
 */

import com.astronet.oms.entity.auditor.Auditable;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;


import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author bigo
 *
 * @Entity 注解该类为数据库表实体类，JPA可自动扫描识别到
 * @Table 注解数据表信息，其中name指定表名
 * @DynamicInsert 表示动态插入，如果某字段为空，那么使用数据库中配置的默认值，也可以在实体类中设置默认值
 * @Data 注在类上，提供类的get、set、equals、hashCode、canEqual、toString方法
 * @AllArgsConstructor ： 注在类上，提供类的全参构造
 * @NoArgsConstructor ： 注在类上，提供类的无参构造
 */
@Entity
@Table(name = "pms_sku")
@DynamicInsert
@Builder
@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PmsSku extends Auditable<String> {

    /**
     * ID，唯一主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 多对一的关系，一个spu可以有多个sku
     * product/pms_spu id, 外键,将产品信息关联进来
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "spu_id")
    private PmsSpu pmsSpu;

    /**
     * 仓库ID，表示可以下单到哪些仓库
     */
    @NotNull
    @Column(name = "inventory_id")
    private Long inventoryId;

    /**
     * '原价/单价'
     */
    @Min(0)
    @NotNull
    @Column(name = "unit_price", precision = 10, scale = 2)
    private BigDecimal unitPrice;

    /**
     * '佣金'
     */
    @Min(0)
    @Column(name = "commission_bonus", precision = 5, scale = 2)
    @NotNull
    private BigDecimal commissionBonus;

    /**
     * '需求数量'
     */
    @NotNull
    @Column(name = "quantity")
    private Long quantity;

    /**
     * '剩余数量、库存'
     */
    @NotNull
    @Column(name = "quantity_left")
    private Long quantityLeft;

    /**
     * offer/product有效状态，
     * 1: ACTIVE
     * 0: INACTIVE
     * default value: 1;offer创建时候便默认为ACTIVE
     */
    @NotNull
    @Column(name = "offer_status", columnDefinition = "TINYINT DEFAULT 1")
    private Integer offerStatus;

    /**
     * 该offer的备注或注释
     */
    @Size(max = 255)
    @Column(name = "offer_note")
    private String offerNote;

//    /**
//     * 产品创建者
//     */
//    @Column(name = "create_user")
//    private Long createUser;
//
//    /**
//     * 产品更新者
//     */
//    @Column(name = "update_user")
//    private Long updateUser;
//
//    /**
//     * 需求是这样的：
//     *
//     * 1. 创建时间与更新时间只能由数据库产生，不允许在实体类中产生，因为每个节点的时间/时区不一定一直。另外防止人为插入自定义时间时间。
//     * 2. 插入记录的时候创建默认时间，创建时间不能为空，时间一旦插入不允许日后在实体类中修改。
//     * 3. 记录创建后更新日志字段为默认为 null 表示该记录没有被修改过。一旦数据被修改，修改日期字段将记录下最后的修改时间。
//     *
//     * 产品创建时间
//     */
//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(name = "create_time",
//            nullable = false,
//            insertable = false,
//            updatable = false,
//            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
//    private Date createTime;
//
//    /**
//     * 产品更新时间
//     */
//
//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(name = "update_time",
//            insertable = false,
//            updatable = false,
//            columnDefinition = "TIMESTAMP NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP")
//    private Date updateTime;

}
