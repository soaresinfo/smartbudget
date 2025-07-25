package com.soares.smartbudget.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "location")
public class LocationEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = -4593520314380453585L;

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "id_location", nullable = false, columnDefinition = "binary(16)")
    private UUID idLocation;

    @Column(name = "description", nullable = false, columnDefinition = "varchar(100)")
    private String description;

}
