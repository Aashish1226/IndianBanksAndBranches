package com.BanksAndBranches.project.Mapper;
import com.BanksAndBranches.project.DTO.RequestDTO.BranchesRequestDTO;
import com.BanksAndBranches.project.DTO.ResponseDTO.BranchesResponseDTO;
import com.BanksAndBranches.project.Entity.Branches;
import org.apache.commons.csv.CSVRecord;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface BranchesMapper {

    Branches toEntity(BranchesRequestDTO branchesRequestDTO);

    @Mapping(source = "banks.bankName" , target = "bankName")
    @Mapping(source = "banks.id"  , target = "bankId")
    BranchesResponseDTO toResponse(Branches branches);

    @Mapping(target = "ifsc", expression = "java(record.get(\"IFSC\").trim())")
    @Mapping(target = "branchName", expression = "java(record.get(\"BRANCH\").trim())")
    @Mapping(target = "address", expression = "java(record.get(\"ADDRESS\").trim())")
    @Mapping(target = "city1", expression = "java(record.get(\"CITY1\").trim())")
    @Mapping(target = "city2", expression = "java(record.get(\"CITY2\").trim())")
    @Mapping(target = "state", expression = "java(record.get(\"STATE\").trim())")
    @Mapping(target = "stdCode", expression = "java(record.get(\"STD CODE\").trim())")
    @Mapping(target = "phone", expression = "java(record.get(\"PHONE\").trim())")
    @Mapping(target = "operational", constant = "true")
    @Mapping(target = "banks", ignore = true)
    Branches toBranch(CSVRecord record);

}
