package com.soares.smartbudget.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

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
    @GeneratedValue
    @UuidGenerator
    @Column(name = "id_investment", nullable = false, columnDefinition = "binary(16)")
    private UUID idInvestment;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_investment_type", referencedColumnName = "id_investment_type", columnDefinition = "binary(16)")
    private InvestmentTypeEntity investmentType;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_location", referencedColumnName = "id_location", columnDefinition = "binary(16)")
    private LocationEntity location;

    @Column(name = "balance", nullable = false, columnDefinition = "decimal(10,2)")
    private BigDecimal balance;

    @Column(name = "month_revenue", nullable = false, columnDefinition = "decimal(10,2)")
    private BigDecimal monthRevenue;

    @Column(name = "last_update_date", nullable = false, columnDefinition = "date")
    private LocalDateTime lastUpdateDate;
}
