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
@Table(name = "transaction")
public class TransactionEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = -1600630752444334445L;

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "id_transaction", nullable = false, columnDefinition = "binary(16)")
    private UUID idTransaction;

    @Column(name = "value_transaction", nullable = false, columnDefinition = "decimal(10,2)")
    private BigDecimal value;

    @Column(name = "description", nullable = false, columnDefinition = "varchar(100)")
    private String description;

    @Column(name = "transaction_date", nullable = false, columnDefinition = "date")
    private LocalDate transactionDate;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "id_expense", referencedColumnName = "id_expense", columnDefinition = "binary(16)")
    private ExpenseEntity expense;
}
