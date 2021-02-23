package com.astronet.order_sys.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @Entity 注解该类为数据库表实体类，JPA可自动扫描识别到
 * @Table 注解数据表信息，其中name指定表名
 */
@Entity
@Table(name = "oms_sku")
public class OmsSku {

    /**
     * ID，唯一主键，按Alt+Enter可以快速导入引入
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 佣金
     */
    @Column(name = "commission_id")
    @NotNull(message = "CommissionId cannot be null")
    private Long commissionId;

    /**
     * 产品名
     */
    @Column(name = "product_name")
    @NotNull(message = "product name cannot be null")
    private String productName;

    /**
     * 产品购买链接
     */
    @NotNull(message = "product link cannot be null")
    @Column(name = "link")
    private String link;

    /**
     * 产品数量
     */
    @Min(value = 0, message = "quantity should not be less than 0")
    @Column(name = "quantity")
    @NotNull(message = "quantity should not be null")
    private Long quantity;

    /**
     * 产品原价、单价
     */
    @NotNull(message = "price should not be null")
    @Min(value = 0, message = "price should not be less than 0")
    @Column(name = "unit_price", scale = 4)
    private Double unitPrice;

    /**
     * 产品优惠价
     */
    @NotNull(message = "Discount price should not be null")
    @Min(value = 0, message = "price should not be less than 0")
    @Column(name = "discount_price", scale = 4)
    private Double discountPrice;

    /**
     * 产品创建时间
     */
    @Column(name = "create_time")
    @CreationTimestamp
    private Date createTime;

    /**
     * 产品过期时间
     */
    @Column(name = "expire_time")
    private Date expireTime;

    @Column(name = "create_user")
    private Long createUser;

    @Column(name = "update_user")
    private Long updateUser;

    @Column(name = "update_time")
    @UpdateTimestamp
    private Date updateTime;

    public OmsSku() {
    }

    public OmsSku(Long commissionId, String productName, String link, Long quantity, Double unitPrice,
                  Double discountPrice, Date createTime, Date expireTime, Long createUser, Long updateUser,
                  Date updateTime) {
        this.commissionId = commissionId;
        this.productName = productName;
        this.link = link;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.discountPrice = discountPrice;
        this.createTime = createTime;
        this.expireTime = expireTime;
        this.createUser = createUser;
        this.updateUser = updateUser;
        this.updateTime = updateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCommissionId() {
        return commissionId;
    }

    public void setCommissionId(Long commissionId) {
        this.commissionId = commissionId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(Double discountPrice) {
        this.discountPrice = discountPrice;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public Long getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "OmsSku{" +
                "id=" + id +
                ", commissionId=" + commissionId +
                ", productName='" + productName + '\'' +
                ", link='" + link + '\'' +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                ", discountPrice=" + discountPrice +
                ", createTime=" + createTime +
                ", expireTime=" + expireTime +
                ", createUser=" + createUser +
                ", updateUser=" + updateUser +
                ", updateTime=" + updateTime +
                '}';
    }
}
