package com.BanksAndBranches.project.Repository;

import com.BanksAndBranches.project.Entity.Branches;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchesRepository extends JpaRepository<Branches, Long> {
}
