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
@Table(name = "investment_type")
public class InvestmentTypeEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -4199522083931622264L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_investment_type", nullable = false, columnDefinition = "bigint")
    private Long idInvestmentType;

    @Column(name = "description", nullable = false, columnDefinition = "varchar(100)")
    private String description;

}
