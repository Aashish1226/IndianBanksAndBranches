package com.BanksAndBranches.project.DTO.ResponseDTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class BranchesResponseDTO {
    private String bankName;
    private Long id;
    private String ifsc;
    private String branchName;
    private String address;
    private String state;
    private Long bankId;
}
