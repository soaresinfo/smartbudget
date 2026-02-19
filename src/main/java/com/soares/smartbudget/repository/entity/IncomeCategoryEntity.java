package com.soares.smartbudget.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "income_category")
public class IncomeCategoryEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = -8094445257853020439L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_income_category", nullable = false, columnDefinition = "bigint")
    private Long idIncomeCategory;

    @Column(name = "description")
    private String description;

}
