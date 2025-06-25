package com.tech_it_easy.controller.services;

import com.tech_it_easy.controller.dtos.RemoteControllerRequestDto;
import com.tech_it_easy.controller.dtos.RemoteControllerResponseDto;
import com.tech_it_easy.controller.exceptions.NotNullException;
import com.tech_it_easy.controller.exceptions.RecordNotFoundException;
import com.tech_it_easy.controller.mappers.RemoteControllerMapper;
import com.tech_it_easy.controller.models.RemoteController;
import com.tech_it_easy.controller.repositories.RemoteControllerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RemoteControllerService {
    private final RemoteControllerRepository remoteControllerRepository;

    public RemoteControllerService(RemoteControllerRepository remoteControllerRepository) {
        this.remoteControllerRepository = remoteControllerRepository;
    }

    public List<RemoteController> getRemoteControllers() {
        return this.remoteControllerRepository.findAll();
    }

    public RemoteController getRemoteControllerById(Long id) {
        return this.remoteControllerRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("RemoteController with ID " + id + " not found."));
    }

    public RemoteController addRemoteController(RemoteControllerRequestDto remoteControllerRequestDto) {
        return this.remoteControllerRepository.save(RemoteControllerMapper.toEntity(remoteControllerRequestDto));
    }

    public RemoteController updateRemoteController(Long id, RemoteControllerRequestDto remoteControllerRequestDto) {
        if (remoteControllerRequestDto == null) {
            throw new NotNullException("Request body cannot be null.");
        }
        RemoteController existingRemoteController = this.remoteControllerRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("RemoteController with ID " + id + " not found."));
        RemoteController updatedRemoteController = RemoteControllerMapper.toEntity(remoteControllerRequestDto);
        updatedRemoteController.setId(existingRemoteController.getId());
        return this.remoteControllerRepository.save(updatedRemoteController);
    }

    public void deleteRemoteController(Long id) {
        if (id == null) {
            throw new NotNullException("RemoteController ID cannot be null.");
        }
        if (!this.remoteControllerRepository.existsById(id)) {
            throw new RecordNotFoundException("RemoteController with ID " + id + " not found.");
        }
        RemoteController remoteController = getRemoteControllerById(id);
        this.remoteControllerRepository.delete(remoteController);
    }

    public RemoteControllerResponseDto addRemoteControllerAndMapToDto(RemoteControllerRequestDto remoteControllerRequestDto) {
        RemoteController remoteController = this.addRemoteController(remoteControllerRequestDto);
        return RemoteControllerMapper.toDto(remoteController);
    }

    public List<RemoteControllerResponseDto> getRemoteControllersAndMapToDto() {
        List<RemoteController> remoteControllers = this.getRemoteControllers();
        return RemoteControllerMapper.toDtoList(remoteControllers);
    }

    public RemoteControllerResponseDto getRemoteControllerByIdAndMapToDto(Long id) {
        RemoteController remoteController = this.getRemoteControllerById(id);
        return RemoteControllerMapper.toDto(remoteController);
    }

    public RemoteControllerResponseDto updateRemoteControllerAndMapToDto(Long id, RemoteControllerRequestDto remoteControllerRequestDto) {
        RemoteController remoteController = this.updateRemoteController(id, remoteControllerRequestDto);
        return RemoteControllerMapper.toDto(remoteController);
    }
}
