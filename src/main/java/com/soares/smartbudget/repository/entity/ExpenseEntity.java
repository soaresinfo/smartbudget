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
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "expense")
public class ExpenseEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 8174956646170236783L;

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "id_expense", nullable = false, columnDefinition = "binary(16)")
    private UUID idExpense;

    @Column(name = "planned_value", nullable = false, columnDefinition = "decimal(10,2)")
    private BigDecimal plannedValue;

    @Column(name = "description", nullable = false, columnDefinition = "varchar(100)")
    private String description;
}
