package com.astronet.oms.entity;

import com.astronet.oms.entity.auditor.Auditable;
import com.astronet.oms.enums.PaymentTypeEnum;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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
@Table(name = "user_payment_methods")
public class UserPaymentMethods extends Auditable<String> {

    /**
     * ID，唯一主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * user_id    1:M
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

//    /**
//     * 信用卡信息
//     */
//    @Size(max = 255)
//    @Column(name = "card_info")
//    private String cardInfo;

    /**
     * Payment Type
     */
    @NotNull
    @Column(name = "payment_type")
    private PaymentTypeEnum paymentType;

    /**
    * Credit Card Company
    * E.g., Chase, Bank of America, Wells Fargo, U.S. Bank, Citibank, Captial One,
    * PNC, BarclayCard US, Staples, Office Depot, Dell, Target.
    */
    @NotNull
    @Size(max = 20)
    @Column(name = "card_company")
    private String cardCompany;

    /**
    * Card Network
    * E.g., Visa, MasterCard, American Express, Discover, Store credit card.
    */
    @NotNull
    @Size(max = 20)
    @Column(name = "card_network")
    private String cardNetwork;

    /**
     * account holder
     */
    @NotNull
    @Column(name = "account_holder")
    private String accountHolder;

    /**
     * account number
     */
    @NotNull
    @Column(name = "account_number")
    private Long accountNumber;

}
