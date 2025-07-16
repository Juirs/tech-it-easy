package com.tech_it_easy.controller.controllers;

import com.tech_it_easy.controller.dtos.IdInputDto;
import com.tech_it_easy.controller.dtos.TelevisionRequestDto;
import com.tech_it_easy.controller.dtos.TelevisionResponseDto;
import com.tech_it_easy.controller.dtos.TelevisionSalesDto;
import com.tech_it_easy.controller.services.TelevisionService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/televisions")
public class TelevisionController {

    private final TelevisionService service;

    public TelevisionController(TelevisionService service) {
        this.service = service;
    }

    @PostMapping()
    public ResponseEntity<TelevisionResponseDto> addTelevision(@Valid @RequestBody TelevisionRequestDto televisionRequestDto) {
        TelevisionResponseDto televisionResponseDto = this.service.addTelevisionAndMapToDto(televisionRequestDto);

        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentRequest().path("/" + televisionResponseDto.id).toUriString());
        return ResponseEntity.created(uri).body(televisionResponseDto);
    }

    @GetMapping()
    public ResponseEntity<List<TelevisionResponseDto>> getTelevision(@RequestParam(required = false) String brand) {
        List<TelevisionResponseDto> allTelevisionDtos = this.service.getTelevisionsAndMapToDto(brand);
        return ResponseEntity.ok(allTelevisionDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TelevisionResponseDto> getTelevisionById(@PathVariable Long id) {
        TelevisionResponseDto televisionResponseDto = this.service.getTelevisionByIdAndMapToDto(id);
        return ResponseEntity.ok(televisionResponseDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TelevisionResponseDto> updateTelevision(@PathVariable Long id, @Valid @RequestBody TelevisionRequestDto televisionRequestDto) {
        TelevisionResponseDto televisionResponseDto = this.service.updateTelevisionAndMapToDto(id, televisionRequestDto);
        return ResponseEntity.ok(televisionResponseDto);
    }

    @PutMapping("/{id}/remotecontroller")
    public ResponseEntity<TelevisionResponseDto> updateTelevisionRemoteController(@PathVariable Long id, @RequestBody IdInputDto remoteControllerId) {
        TelevisionResponseDto televisionResponseDto = this.service.updateTelevisionRemoteControllerAndMapToDto(id, remoteControllerId.id);
        return ResponseEntity.ok(televisionResponseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTelevision(@PathVariable Long id) {
        this.service.deleteTelevision(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/sales")
    public ResponseEntity<List<TelevisionSalesDto>> getTelevisionSalesInfo(@RequestParam(required = false) Long id) {
        List<TelevisionSalesDto> salesInfo = this.service.getTelevisionSalesInfo(id);
        return ResponseEntity.ok(salesInfo);
    }

    @GetMapping("/sales/{id}")
    public ResponseEntity<List<TelevisionSalesDto>> getTelevisionSalesById(@PathVariable Long id) {
        return getTelevisionSalesInfo(id);
    }
}