package com.astronet.oms.entity.auditor;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * @author: Yanan Lyu
 * @date 3/7/21 10:59 PM
 *
 * @MappedSuperclass 定义了这个类能够被其他实体类（我还是觉得用数据模型类这个叫法比较合适）继承；同时这个类并不会在数据中专门建立一张表。
 * AuditingEntityListener Spring Data JPA提供了一个JPA实体监听的类（AuditingEntityListener）,
 * 其中包含了@PrePersist和@PreUpdate的回调，这样就可以用来管理实体的每一次存储和更新。
 * @EntityListeners可以被用来监听模型事件（数据创建，修改，删除甚至自定义事件），我们在这里注册了AuditingEntityListener这个事件。
 */
@Getter(AccessLevel.PROTECTED)
@Setter(AccessLevel.PROTECTED)
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class Auditable<U> {
    @CreatedBy
    @Column(name = "created_by")
    private U createdBy;

    @CreatedDate
    @Column(name = "created_date")
    private Date createdDate;

    @LastModifiedBy
    @Column(name = "last_modified_by")
    private U lastModifiedBy;

    @LastModifiedDate
    @Column(name = "last_modified_date")
    private Date lastModifiedDate;
}
