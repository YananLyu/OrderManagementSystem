package com.astronet.oms.entity;

import com.astronet.oms.entity.auditor.Auditable;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author Yanan Lyu
 * @date 3/8/21 2:08 PM
 */

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@DynamicInsert
@Entity
@Table(name = "user_money")
public class UserMoney extends Auditable<String> {

    /**
     * ID，唯一主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用user 的id 当做该表的外键。共享ID
     * Using a Shared Primary Key
     */
    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;

    /**
     * on hold的钱数
     * 不可以为负值
     */
    @Min(0)
    @NotNull
    @Column(name = "on_hold", precision = 10, scale = 2)
    private BigDecimal onHold;

    /**
     * 用户金额的balance的钱数
     * 可以为负值
     */
    @NotNull
    @Column(name = "balance", precision = 10, scale = 2)
    private BigDecimal balance;

    /**
     * 用户金额的pending的钱数
     * 不可以为负值
     */
    @Min(0)
    @NotNull
    @Column(name = "pending", precision = 10, scale = 2)
    private BigDecimal pending;
}
