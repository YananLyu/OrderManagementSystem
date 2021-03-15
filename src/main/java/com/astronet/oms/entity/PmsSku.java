package com.astronet.oms.entity;

/**
 * @author: Yanan Lyu
 * @date 3/2/21 5:09 PM
 */

import com.astronet.oms.entity.auditor.Auditable;
import com.astronet.oms.enums.OfferStatusEnum;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;


import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

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
@Table(name = "pms_sku")
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
     *
     * TODO：NotNull保证发布offer时候，spu 必须指定。你再确认下
     */
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "spu_id")
    private PmsSpu pmsSpu;

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
     * 需求数量
     */
    @NotNull
    @Column(name = "quantity")
    private Long quantity;

    /**
     * 剩余数量、库存
     */
    @NotNull
    @Column(name = "quantity_left")
    private Long quantityLeft;

    /**
     * offer/product有效状态，
     * 1: ACTIVE
     * 0: INACTIVE
     * default value: 1;offer创建时候便默认为ACTIVE
     *
     *     @NotNull
     *     @Column(name = "offer_status", columnDefinition = "TINYINT DEFAULT 1")
     *     private Integer offerStatus;
     */
    @NotNull
    @Column(name = "offer_status")
    private OfferStatusEnum offerStatus;

    /**
     * 该offer的备注或注释
     */
    @Size(max = 255)
    @Column(name = "offer_note")
    private String offerNote;

    /**
     * sku和inventory是M:N的关系
     * 仓库ID，表示可以下单到哪些仓库
     */
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "sku_inventory",
            joinColumns = @JoinColumn(name = "sku_id"),
            inverseJoinColumns = @JoinColumn(name = "inventory_id"))
    private Set<PmsInventory> pmsInventories = new HashSet<>();

}
