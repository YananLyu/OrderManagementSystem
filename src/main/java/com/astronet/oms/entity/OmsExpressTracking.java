package com.astronet.oms.entity;

/**
 * @author: Yanan Lyu
 * @date 3/2/21 5:09 PM
 */

import com.astronet.oms.entity.auditor.Auditable;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
@Table(name = "oms_express_tracking")
public class OmsExpressTracking extends Auditable<String> {

    /**
     * ID，唯一主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * order_id    1:M
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private OmsOrder omsOrder;

    /**
     * 该tracking number包含的商品数量
     */
    @NotNull
    @Column(name = "quantity")
    private Long quantity;

    /**
     * tracking 状态
     * 0: PENDING, 默认值
     * 1：RECEIVE
     * 2: ISSUE
     */
    @NotNull
    @Column(name = "tracking_status", columnDefinition = "TINYINT DEFAULT 0")
    private Integer trackingStatus;

    /**
     * 该快递的备注
     */
    @Size(max = 255)
    @Column(name = "tracking_note")
    private String trackingNote;

}
