package com.BanksAndBranches.project.Controller;

import com.BanksAndBranches.project.DTO.ResponseDTO.*;
import com.BanksAndBranches.project.Services.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@Slf4j
@RestController
@RequestMapping("/banks")
public class BankController {

    private final BanksService banksService;
    private final BranchesService branchesService;

    public BankController(BanksService banksService, BranchesService branchesService) {
        this.banksService = banksService;
        this.branchesService = branchesService;
    }
}
