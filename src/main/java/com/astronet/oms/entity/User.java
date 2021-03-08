package com.astronet.oms.entity;

import com.astronet.oms.entity.auditor.Auditable;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @author Yanan Lyu
 * @date 2021/01/01
 */
@Builder
@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@DynamicInsert
@Entity
@Table(	name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")
        })
public class User extends Auditable<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 20)
    private String username;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    @Size(max = 100)
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    /**
     * 连接用户的详细信息userInfo
     * 用user 的id 当做该表的外键。共享ID
     * Using a Shared Primary Key
     */
    @OneToOne(mappedBy = "user", cascade = CascadeType.REMOVE)
    @PrimaryKeyJoinColumn
    private UserInfo userInfo;

    /**
     * 连接用户的钱，userMoney
     * 用user 的id 当做该表的外键。共享ID
     * Using a Shared Primary Key
     */
    @OneToOne(mappedBy = "user", cascade = CascadeType.REMOVE)
    @PrimaryKeyJoinColumn
    private UserMoney userMoney;

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}

