package com.soares.smartbudget.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "investment")
public class InvestmentEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 5937794163811749493L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_investment", nullable = false, columnDefinition = "bigint")
    private Long idInvestment;

    @Column(name = "id_portfolio", nullable = false, columnDefinition = "varchar(36)")
    private String idPortfolio;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "id_investment_type", referencedColumnName = "id_investment_type", columnDefinition = "bigint")
    private InvestmentTypeEntity investmentType;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "id_location", referencedColumnName = "id_location", columnDefinition = "bigint")
    private LocationEntity location;

    @Column(name = "balance", nullable = false, columnDefinition = "decimal(10,2)")
    private BigDecimal balance;

    @Column(name = "month_revenue", nullable = false, columnDefinition = "decimal(10,2)")
    private BigDecimal monthRevenue;

    @Column(name = "contribution", columnDefinition = "decimal(10,2)")
    private BigDecimal contribution;

    @Column(name = "withdraw", columnDefinition = "decimal(10,2)")
    private BigDecimal withdraw;

    @Column(name = "last_update_date", nullable = false, columnDefinition = "date")
    private LocalDate lastUpdateDate;
}
