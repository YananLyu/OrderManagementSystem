package com.astronet.oms.entity;

import com.astronet.oms.entity.auditor.Auditable;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author Yanan Lyu
 * @date 3/1/21 11:13 PM
 */

/**
 * @author bigo
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
@Table(name = "pms_spu")
public class PmsSpu extends Auditable<String> {

    /**
     * ID，唯一主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 一对多的关系，一个spu可以有多个sku
     * product/pms_spu id, 外键,将产品信息关联进来
     */
    @OneToMany(mappedBy = "pmsSpu", fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE})
    private List<PmsSku> pmsSkuSet;

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
//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(name = "update_time",
//            insertable = false,
//            updatable = false,
//            columnDefinition = "TIMESTAMP NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP")
//    private Date updateTime;

}
