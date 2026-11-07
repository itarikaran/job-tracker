package com.arikaran.jobtracker.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "companies")
@Getter
@Setter
@NoArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "company_name", nullable = false, length = 150)
    private String companyName;

    private String district;

    @Column(columnDefinition = "TEXT")
    private String address;

    @Column(name = "last_updated",
            insertable = false, updatable = false)
    private LocalDateTime lastUpdated;

    @Column(nullable = false, length = 30)
    private String status;

    @Column(columnDefinition = "TEXT")
    private String notes;
}
