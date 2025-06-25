package com.tech_it_easy.controller.services;

import com.tech_it_easy.controller.dtos.TelevisionRequestDto;
import com.tech_it_easy.controller.dtos.TelevisionSalesDto;
import com.tech_it_easy.controller.dtos.TelevisionResponseDto;
import com.tech_it_easy.controller.exceptions.NameTooLongException;
import com.tech_it_easy.controller.exceptions.NotNullException;
import com.tech_it_easy.controller.exceptions.RecordNotFoundException;
import com.tech_it_easy.controller.mappers.TelevisionMapper;
import com.tech_it_easy.controller.models.RemoteController;
import com.tech_it_easy.controller.models.Television;
import com.tech_it_easy.controller.repositories.RemoteControllerRepository;
import com.tech_it_easy.controller.repositories.TelevisionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TelevisionService {
    private final TelevisionRepository televisionRepository;
    private final RemoteControllerRepository remoteControllerRepository;

    public TelevisionService (TelevisionRepository televisionRepository,
                              RemoteControllerRepository remoteControllerRepository) {
        this.televisionRepository = televisionRepository;
        this.remoteControllerRepository = remoteControllerRepository;
    }

    public List<Television> getTelevisions(String brand) {
        if (brand != null) {
            return this.televisionRepository.findByBrandIgnoreCase(brand);
        }
        return this.televisionRepository.findAll();
    }

    public Television getTelevisionById(Long id) {
        return this.televisionRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Television with ID " + id + " not found."));
    }

    public Television addTelevision(TelevisionRequestDto televisionRequestDto) {
        if (televisionRequestDto.name.length() > 20) {
            throw new NameTooLongException("Television name exceeds 20 characters.");
        }
        return this.televisionRepository.save(TelevisionMapper.toEntity(televisionRequestDto));
    }

    public void deleteTelevision(Long id) {
        if (id == null) {
            throw new NotNullException("Television ID cannot be null.");
        }
        if (!this.televisionRepository.existsById(id)) {
            throw new RecordNotFoundException("Television with ID " + id + " not found.");
        }
        Television television = getTelevisionById(id);
        this.televisionRepository.delete(television);
    }

    public Television updateTelevision(Long id, TelevisionRequestDto televisionRequestDto) {
        if (televisionRequestDto == null) {
            throw new NotNullException("Request body cannot be null.");
        }
        Television existingTelevision = this.televisionRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Television with ID " + id + " not found."));
        Television updatedTelevision = TelevisionMapper.toEntity(televisionRequestDto);
        updatedTelevision.setId(existingTelevision.getId());
        return this.televisionRepository.save(updatedTelevision);
    }

    public List<TelevisionSalesDto> getTelevisionSalesInfo(Long id) {
        if (id != null) {
            Television television = this.televisionRepository.findById(id)
                    .orElseThrow(() -> new RecordNotFoundException("Television with ID " + id + " not found."));
            return List.of(TelevisionMapper.toSalesDto(television));
        }
        List<Television> televisions = this.televisionRepository.findAll();
        return TelevisionMapper.toSalesDtoList(televisions);
    }

    public TelevisionResponseDto addTelevisionAndMapToDto(TelevisionRequestDto televisionRequestDto) {
        Television television = this.addTelevision(televisionRequestDto);
        return TelevisionMapper.toDto(television);
    }

    public List<TelevisionResponseDto> getTelevisionsAndMapToDto(String brand) {
        List<Television> televisions = this.getTelevisions(brand);
        return TelevisionMapper.toDtoList(televisions);
    }

    public TelevisionResponseDto getTelevisionByIdAndMapToDto(Long id) {
        Television television = this.getTelevisionById(id);
        return TelevisionMapper.toDto(television);
    }

    public TelevisionResponseDto updateTelevisionAndMapToDto(Long id, TelevisionRequestDto televisionRequestDto) {
        Television television = this.updateTelevision(id, televisionRequestDto);
        return TelevisionMapper.toDto(television);
    }

    public TelevisionResponseDto updateTelevisionRemoteControllerAndMapToDto(Long id, Long remoteControllerId) {
        Television television = this.getTelevisionById(id);
        RemoteController remoteController = this.remoteControllerRepository.findById(remoteControllerId)
                .orElseThrow(() -> new RecordNotFoundException("Remote Controller with ID " + remoteControllerId + " not found."));

        television.setRemoteController(remoteController);
        Television updatedTelevision = this.televisionRepository.save(television);
        return TelevisionMapper.toDto(updatedTelevision);
    }

    public void assignRemoteControllerToTelevision(Long televisionId, Long remoteControllerId) {
        Television television = this.getTelevisionById(televisionId);
        RemoteController remoteController = this.remoteControllerRepository.findById(remoteControllerId)
                .orElseThrow(() -> new RecordNotFoundException("Remote Controller with ID " + remoteControllerId + " not found."));

        television.setRemoteController(remoteController);
        this.televisionRepository.save(television);
    }
}