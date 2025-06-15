package com.BanksAndBranches.project.Entity;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.annotation.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "banks",
        indexes = {
                @Index(name = "idx_bank_name", columnList = "bank_name")
        })
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Banks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    @Column(name = "create_date", nullable = false, updatable = false)
    private LocalDateTime createDate;

    @LastModifiedDate
    @Column(name = "update_date", nullable = false)
    private LocalDateTime updateDate;


    @Column(name = "bank_name", nullable = false, unique = true)
    private String bankName;

    @Column(name = "operational", columnDefinition = "boolean default true")
    private Boolean operational = true;

    @OneToMany(mappedBy = "banks", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Branches> branches;

    private Boolean isActive = true;

}
