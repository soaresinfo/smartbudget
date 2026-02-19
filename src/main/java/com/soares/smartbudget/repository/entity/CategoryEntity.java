package com.soares.smartbudget.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "category")
public class CategoryEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 8174956646170236783L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_category", nullable = false, columnDefinition = "bigint")
    private Long idCategory;

    @Column(name = "planned_value", nullable = true, columnDefinition = "decimal(10,2)")
    private BigDecimal plannedValue;

    @Column(name = "description", nullable = false, columnDefinition = "varchar(100)")
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "parent_id_category")
    private CategoryEntity parent;

}
