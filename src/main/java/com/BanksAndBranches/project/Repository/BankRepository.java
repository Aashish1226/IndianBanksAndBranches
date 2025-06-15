package com.BanksAndBranches.project.Repository;

import com.BanksAndBranches.project.Entity.Banks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface BankRepository extends JpaRepository<Banks, Long> {
}
