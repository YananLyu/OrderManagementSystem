package com.astronet.oms.entity;

import com.astronet.oms.enums.ERole;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author Yanan Lyu
 * @date 2021/01/01
 */
@Getter
@Setter
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERole name;

    public Role() {

    }
}
