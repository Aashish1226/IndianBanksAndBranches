package com.BanksAndBranches.project.DTO.RequestDTO;

import jakarta.validation.constraints.NotNull;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
public class BanksRequestDTO {
    @NotNull(message = "Bank Name cannot be null")
    private String bankName;
}
