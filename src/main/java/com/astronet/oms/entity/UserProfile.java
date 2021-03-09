package com.astronet.oms.entity;

import com.astronet.oms.entity.auditor.Auditable;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import javax.validation.constraints.Size;

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
@Table(name = "user_profile")
public class UserProfile extends Auditable<String> {

    /**
     * ID，唯一主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 微信ID
     */
    @Size(max = 50)
    @Column(name = "wechat_id")
    private String wechatId;

    /**
     * 微信名
     */
    @Size(max = 50)
    @Column(name = "wechat_name")
    private String wechatName;

    /**
     * 微信名
     */
    @Size(max = 13)
    @Column(name = "phone_number")
    private String phoneNumber;


    /**
     * 用user 的id 当做该表的外键。共享ID
     * Using a Shared Primary Key
     */
    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;
}
