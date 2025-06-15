package com.BanksAndBranches.project.DTO.RequestDTO;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class BranchesRequestDTO {

    @NotNull(message = "IFSC code cannot be null")
    private String ifsc;

    @NotNull(message = "Branch Name cannot be null")
    private String branchName;

    @NotNull(message = "Address cannot be null")
    private String address;

    private String city1;

    private String city2;

    @NotNull(message = "State cannot be null")
    private String state;

    private String stdCode;

    private String phone;

    private Long bankId;
}
