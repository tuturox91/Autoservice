package org.sniklz.autoservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.sniklz.autoservice.dto.response.MasterResponseDto;
import org.sniklz.autoservice.dto.request.MasterRequestDto;
import org.sniklz.autoservice.model.Master;
import org.sniklz.autoservice.service.MasterService;
import org.sniklz.autoservice.service.mapper.UniversalDtoMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/master")
public class MasterController {

    private final UniversalDtoMapper<MasterRequestDto, MasterResponseDto, Master> masterMapper;
    private final MasterService masterService;

    public MasterController(UniversalDtoMapper<MasterRequestDto, MasterResponseDto, Master> masterMapper, MasterService masterService) {
        this.masterMapper = masterMapper;
        this.masterService = masterService;
    }


    @PostMapping
    @Operation(description = "Add master")
    public MasterResponseDto addMaster(@RequestBody MasterRequestDto requestDto) {
        return masterMapper.toDto(masterService.save(masterMapper.toModel(requestDto)));
    }

    @PutMapping("/{id}")
    @Operation (description = "Update master")
    public  MasterResponseDto updateMaster(@Parameter(description = "Master id") @PathVariable Long id, @RequestBody MasterRequestDto requestDto) {
        Master master = masterMapper.toModel(requestDto);
        master.setId(id);
        return masterMapper.toDto(masterService.update(master));
    }

    @GetMapping("/{id}")
    @Operation (description = "Get master by id")
    public MasterResponseDto getMasterById(@PathVariable Long id) {
        return masterMapper.toDto(masterService.getMasterById(id));
    }


    @GetMapping("/salary/{masterId}")
    @Operation (description = "Calculate master salary")
    public BigDecimal calculateMasterSalary(@Parameter(description = "Master id") @PathVariable Long masterId) {
        return masterService.calculateMasterSalary(masterId);
    }

}
