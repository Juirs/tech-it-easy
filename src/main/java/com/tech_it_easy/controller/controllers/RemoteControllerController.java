package com.tech_it_easy.controller.controllers;

import com.tech_it_easy.controller.dtos.RemoteControllerRequestDto;
import com.tech_it_easy.controller.dtos.RemoteControllerResponseDto;
import com.tech_it_easy.controller.services.RemoteControllerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/remotecontrollers")
public class RemoteControllerController {
    private final RemoteControllerService service;

    public RemoteControllerController(RemoteControllerService service) {
        this.service = service;
    }

    @PostMapping()
    public ResponseEntity<RemoteControllerResponseDto> addRemoteController(@RequestBody RemoteControllerRequestDto remoteControllerRequestDto) {
        RemoteControllerResponseDto remoteControllerResponseDto = this.service.addRemoteControllerAndMapToDto(remoteControllerRequestDto);

        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentRequest().path("/" + remoteControllerResponseDto.id).toUriString());
        return ResponseEntity.created(uri).body(remoteControllerResponseDto);
    }

    @GetMapping()
    public ResponseEntity<List<RemoteControllerResponseDto>> getRemoteController() {
        List<RemoteControllerResponseDto> allRemoteControllers = this.service.getRemoteControllersAndMapToDto();
        return ResponseEntity.ok(allRemoteControllers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RemoteControllerResponseDto> getRemoteControllerById(@PathVariable Long id) {
        RemoteControllerResponseDto remoteControllerResponseDto = this.service.getRemoteControllerByIdAndMapToDto(id);
        return ResponseEntity.ok(remoteControllerResponseDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RemoteControllerResponseDto> updateRemoteController(@PathVariable Long id, @RequestBody RemoteControllerRequestDto remoteControllerRequestDto) {
        RemoteControllerResponseDto remoteControllerResponseDto = this.service.updateRemoteControllerAndMapToDto(id, remoteControllerRequestDto);
        return ResponseEntity.ok(remoteControllerResponseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRemoteController(@PathVariable Long id) {
        this.service.deleteRemoteController(id);
        return ResponseEntity.ok("Remote Controller with ID " + id + " removed successfully.");
    }
}