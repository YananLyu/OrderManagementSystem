package com.astronet.order_sys.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "item_link")
    private String itemLink;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "price_buyer")
    private Integer priceBuyer;

    @Column(name = "price_middle_seller")
    private Integer priceMiddleSeller;

    @Column(name = "price_seller")
    private Integer priceSeller;

    @Column(name = "quantity_left")
    private Integer quantityLeft;

    @Column(name = "quantity_total")
    private Integer quantityTotal;

    @Column(name = "seller_platform")
    private String sellerPlatform;

    @Column(name = "available_status")
    private String availableStatus;

    public Item() {
    }

    public Item(Date createTime, String itemLink, String itemName, Integer priceBuyer, Integer priceMiddleSeller,
                Integer priceSeller, Integer quantityLeft, Integer quantityTotal, String sellerPlatform,
                String availableStatus) {
        this.createTime = createTime;
        this.itemLink = itemLink;
        this.itemName = itemName;
        this.priceBuyer = priceBuyer;
        this.priceMiddleSeller = priceMiddleSeller;
        this.priceSeller = priceSeller;
        this.quantityLeft = quantityLeft;
        this.quantityTotal = quantityTotal;
        this.sellerPlatform = sellerPlatform;
        this.availableStatus = availableStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getItemLink() {
        return itemLink;
    }

    public void setItemLink(String itemLink) {
        this.itemLink = itemLink;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getPriceBuyer() {
        return priceBuyer;
    }

    public void setPriceBuyer(Integer priceBuyer) {
        this.priceBuyer = priceBuyer;
    }

    public Integer getPriceMiddleSeller() {
        return priceMiddleSeller;
    }

    public void setPriceMiddleSeller(Integer priceMiddleSeller) {
        this.priceMiddleSeller = priceMiddleSeller;
    }

    public Integer getPriceSeller() {
        return priceSeller;
    }

    public void setPriceSeller(Integer priceSeller) {
        this.priceSeller = priceSeller;
    }

    public Integer getQuantityLeft() {
        return quantityLeft;
    }

    public void setQuantityLeft(Integer quantityLeft) {
        this.quantityLeft = quantityLeft;
    }

    public Integer getQuantityTotal() {
        return quantityTotal;
    }

    public void setQuantityTotal(Integer quantityTotal) {
        this.quantityTotal = quantityTotal;
    }

    public String getSellerPlatform() {
        return sellerPlatform;
    }

    public void setSellerPlatform(String sellerPlatform) {
        this.sellerPlatform = sellerPlatform;
    }

    public String getAvailableStatus() {
        return availableStatus;
    }

    public void setAvailableStatus(String availableStatus) {
        this.availableStatus = availableStatus;
    }
}
