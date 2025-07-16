package com.tech_it_easy.controller.controllers;

import com.tech_it_easy.controller.dtos.CiModuleRequestDto;
import com.tech_it_easy.controller.dtos.CiModuleResponseDto;
import com.tech_it_easy.controller.services.CiModuleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/cimodules")
public class CiModuleController {
    private final CiModuleService service;

    public CiModuleController(CiModuleService service) {
        this.service = service;
    }

    @PostMapping()
    public ResponseEntity<CiModuleResponseDto> addCiModule(@RequestBody CiModuleRequestDto ciModuleRequestDto) {
        CiModuleResponseDto ciModuleResponseDto = this.service.addCiModuleAndMapToDto(ciModuleRequestDto);

        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentRequest().path("/" + ciModuleResponseDto.id).toUriString());
        return ResponseEntity.created(uri).body(ciModuleResponseDto);
    }

    @GetMapping()
    public ResponseEntity<List<CiModuleResponseDto>> getCiModules() {
        List<CiModuleResponseDto> allCiModuleDtos = this.service.getCiModulesAndMapToDto();
        return ResponseEntity.ok(allCiModuleDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CiModuleResponseDto> getCiModuleById(@PathVariable Long id) {
        CiModuleResponseDto ciModuleResponseDto = this.service.getCiModuleByIdAndMapToDto(id);
        return ResponseEntity.ok(ciModuleResponseDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CiModuleResponseDto> updateCiModule(@PathVariable Long id, @RequestBody CiModuleRequestDto ciModuleRequestDto) {
        CiModuleResponseDto ciModuleResponseDto = this.service.updateCiModuleAndMapToDto(id, ciModuleRequestDto);
        return ResponseEntity.ok(ciModuleResponseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCiModule(@PathVariable Long id) {
        this.service.deleteCiModule(id);
        return ResponseEntity.noContent().build();
    }
}
