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
import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "income")
public class IncomeEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 799459604445361598L;

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "id_income", nullable = false, columnDefinition = "binary(16)")
    private UUID idIncome;

    @Column(name = "value")
    private BigDecimal value;

    @Column(name = "description")
    private String description;

    @Column(name = "income_date")
    private LocalDate incomeDate;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_income_category", referencedColumnName = "id_income_category", columnDefinition = "binary(16)")
    private IncomeCategoryEntity incomeCategory;
}
