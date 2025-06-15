package com.BanksAndBranches.project.Mapper;
import com.BanksAndBranches.project.DTO.RequestDTO.BanksRequestDTO;
import com.BanksAndBranches.project.DTO.ResponseDTO.BanksResponseDTO;
import com.BanksAndBranches.project.Entity.Banks;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {BranchesMapper.class})
public interface BanksMapper {
   Banks toEntity(BanksRequestDTO banksRequestDTO);
   BanksResponseDTO toResponse(Banks banks);
}
