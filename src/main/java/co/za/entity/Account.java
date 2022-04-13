package co.za.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "DATE")
    private LocalDateTime date;

    @Column(name = "PAYMENT_TYPE")
    private String paymentType;

    @Column(name = "DEBIT")
    private BigDecimal debit;

    @Column(name = "CREDITS")
    private BigDecimal credit;

    @Column(name = "BALANCE")
    private BigDecimal balance;

    @Column(name = "CURRENT_BALANCE")
    private BigDecimal currentBalance;

}
