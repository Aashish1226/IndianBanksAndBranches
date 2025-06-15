package com.BanksAndBranches.project.Entity;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.annotation.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name = "branches" , indexes = {
        @Index(name = "idx_ifsc" , columnList = "ifsc"),
        @Index(name = "idx_bank_branch", columnList = "bank_id, branch_name")
})
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Branches{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    @Column(name = "create_date", nullable = false, updatable = false)
    private LocalDateTime createDate;

    @LastModifiedDate
    @Column(name = "update_date", nullable = false)
    private LocalDateTime updateDate;

    @Column(name = "ifsc", nullable = false, unique = true)
    private String ifsc;

    @Column(name = "branch_name" , nullable = false)
    private String branchName;

    @Column(name = "address" , nullable = false)
    private String address;

    @Column(name = "city1")
    private String city1;

    @Column(name = "city2")
    private String city2;

    @Column(name = "state" , nullable = false)
    private String state;

    @Column(name = "std_code")
    private String stdCode;

    @Column(name = "phone")
    private String phone;

    @ManyToOne
    @JoinColumn(name = "bank_id" , nullable = false)
    private Banks banks;

    @Column(name = "operational", columnDefinition = "boolean default true")
    private Boolean operational = true;

}
