package com.tech_it_easy.controller.services;

import com.tech_it_easy.controller.dtos.CiModuleRequestDto;
import com.tech_it_easy.controller.dtos.CiModuleResponseDto;
import com.tech_it_easy.controller.exceptions.NotNullException;
import com.tech_it_easy.controller.exceptions.RecordNotFoundException;
import com.tech_it_easy.controller.mappers.CiModuleMapper;
import com.tech_it_easy.controller.models.CiModule;
import com.tech_it_easy.controller.repositories.CiModuleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CiModuleService {
    private final CiModuleRepository ciModuleRepository;

    public CiModuleService(CiModuleRepository ciModuleRepository) {
        this.ciModuleRepository = ciModuleRepository;
    }

    public List<CiModule> getCiModules() {
        return this.ciModuleRepository.findAll();
    }

    public CiModule getCiModuleById(Long id) {
        return this.ciModuleRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("CiModule with ID " + id + " not found."));
    }

    public CiModule addCiModule(CiModuleRequestDto ciModuleRequestDto) {
        return this.ciModuleRepository.save(CiModuleMapper.toEntity(ciModuleRequestDto));
    }

    public CiModule updateCiModule(Long id, CiModuleRequestDto ciModuleRequestDto) {
        if (ciModuleRequestDto == null) {
            throw new NotNullException("Request body cannot be null.");
        }
        CiModule existingCiModule = this.ciModuleRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("CiModule with ID " + id + " not found."));
        CiModule updatedCiModule = CiModuleMapper.toEntity(ciModuleRequestDto);
        updatedCiModule.setId(existingCiModule.getId());
        return this.ciModuleRepository.save(updatedCiModule);
    }

    public void deleteCiModule(Long id) {
        if (id == null) {
            throw new NotNullException("CiModule ID cannot be null.");
        }
        if (!this.ciModuleRepository.existsById(id)) {
            throw new RecordNotFoundException("CiModule with ID " + id + " not found.");
        }
        CiModule ciModule = getCiModuleById(id);
        this.ciModuleRepository.delete(ciModule);
    }

    public CiModuleResponseDto addCiModuleAndMapToDto(CiModuleRequestDto ciModuleRequestDto) {
        CiModule ciModule = this.addCiModule(ciModuleRequestDto);
        return CiModuleMapper.toDto(ciModule);
    }

    public List<CiModuleResponseDto> getCiModulesAndMapToDto() {
        List<CiModule> ciModules = this.getCiModules();
        return CiModuleMapper.toDtoList(ciModules);
    }

    public CiModuleResponseDto getCiModuleByIdAndMapToDto(Long id) {
        CiModule ciModule = this.getCiModuleById(id);
        return CiModuleMapper.toDto(ciModule);
    }

    public CiModuleResponseDto updateCiModuleAndMapToDto(Long id, CiModuleRequestDto ciModuleRequestDto) {
        CiModule ciModule = this.updateCiModule(id, ciModuleRequestDto);
        return CiModuleMapper.toDto(ciModule);
    }
}
