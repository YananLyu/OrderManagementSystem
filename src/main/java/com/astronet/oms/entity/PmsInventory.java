package com.astronet.oms.entity;

import com.astronet.oms.entity.auditor.Auditable;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Yanan Lyu
 * @date 3/7/21 11:36 PM
 */

@Builder
@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@DynamicInsert
@Entity
@Table(name = "pms_inventory")
public class PmsInventory extends Auditable<String> {

    /**
     * ID，唯一主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
     * zipcode
     */
    @Size(max = 25)
    @Column(name = "addr_country")
    private String addrCountry;

    /**
     * 多对一的关系，多个仓库可以对应一个人
     * 通过user_id这个外键，把仓库指定给某个user
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

}
