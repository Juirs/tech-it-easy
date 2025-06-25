package com.tech_it_easy.controller.controllers;

import com.tech_it_easy.controller.dtos.WallBracketRequestDto;
import com.tech_it_easy.controller.dtos.WallBracketResponseDto;
import com.tech_it_easy.controller.services.WallBracketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/wallbrackets")
public class WallBracketController {
    private final WallBracketService service;

    public WallBracketController(WallBracketService service) {
        this.service = service;
    }

    @PostMapping()
    public ResponseEntity<WallBracketResponseDto> addWallBracket(@RequestBody WallBracketRequestDto wallBracketRequestDto) {
        WallBracketResponseDto wallBracketResponseDto = this.service.addWallBracketAndMapToDto(wallBracketRequestDto);

        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentRequest().path("/" + wallBracketResponseDto.id).toUriString());
        return ResponseEntity.created(uri).body(wallBracketResponseDto);
    }

    @GetMapping()
    public ResponseEntity<List<WallBracketResponseDto>> getWallBrackets() {
        List<WallBracketResponseDto> allWallBracketDtos = this.service.getWallBracketsAndMapToDto();
        return ResponseEntity.ok(allWallBracketDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WallBracketResponseDto> getWallBracketById(@PathVariable Long id) {
        WallBracketResponseDto wallBracketResponseDto = this.service.getWallBracketByIdAndMapToDto(id);
        return ResponseEntity.ok(wallBracketResponseDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WallBracketResponseDto> updateWallBracket(@PathVariable Long id, @RequestBody WallBracketRequestDto wallBracketRequestDto) {
        WallBracketResponseDto wallBracketResponseDto = this.service.updateWallBracketAndMapToDto(id, wallBracketRequestDto);
        return ResponseEntity.ok(wallBracketResponseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteWallBracket(@PathVariable Long id) {
        this.service.deleteWallBracket(id);
        return ResponseEntity.ok("WallBracket with ID " + id + " removed successfully.");
    }
}
