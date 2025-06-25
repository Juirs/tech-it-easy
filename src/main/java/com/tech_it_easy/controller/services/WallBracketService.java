package com.tech_it_easy.controller.services;

import com.tech_it_easy.controller.dtos.WallBracketRequestDto;
import com.tech_it_easy.controller.dtos.WallBracketResponseDto;
import com.tech_it_easy.controller.exceptions.NotNullException;
import com.tech_it_easy.controller.exceptions.RecordNotFoundException;
import com.tech_it_easy.controller.mappers.WallBracketMapper;
import com.tech_it_easy.controller.models.WallBracket;
import com.tech_it_easy.controller.repositories.WallBracketRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WallBracketService {
    private final WallBracketRepository wallBracketRepository;

    public WallBracketService(WallBracketRepository wallBracketRepository) {
        this.wallBracketRepository = wallBracketRepository;
    }

    public List<WallBracket> getWallBrackets() {
        return this.wallBracketRepository.findAll();
    }

    public WallBracket getWallBracketById(Long id) {
        return this.wallBracketRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("WallBracket with ID " + id + " not found."));
    }

    public WallBracket addWallBracket(WallBracketRequestDto wallBracketRequestDto) {
        return this.wallBracketRepository.save(WallBracketMapper.toEntity(wallBracketRequestDto));
    }

    public WallBracket updateWallBracket(Long id, WallBracketRequestDto wallBracketRequestDto) {
        if (wallBracketRequestDto == null) {
            throw new NotNullException("Request body cannot be null.");
        }
        WallBracket existingWallBracket = this.wallBracketRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("WallBracket with ID " + id + " not found."));
        WallBracket updatedWallBracket = WallBracketMapper.toEntity(wallBracketRequestDto);
        updatedWallBracket.setId(existingWallBracket.getId());
        return this.wallBracketRepository.save(updatedWallBracket);
    }

    public void deleteWallBracket(Long id) {
        if (id == null) {
            throw new NotNullException("WallBracket ID cannot be null.");
        }
        if (!this.wallBracketRepository.existsById(id)) {
            throw new RecordNotFoundException("WallBracket with ID " + id + " not found.");
        }
        WallBracket wallBracket = getWallBracketById(id);
        this.wallBracketRepository.delete(wallBracket);
    }

    public WallBracketResponseDto addWallBracketAndMapToDto(WallBracketRequestDto wallBracketRequestDto) {
        WallBracket wallBracket = this.addWallBracket(wallBracketRequestDto);
        return WallBracketMapper.toDto(wallBracket);
    }

    public List<WallBracketResponseDto> getWallBracketsAndMapToDto() {
        List<WallBracket> wallBrackets = this.getWallBrackets();
        return WallBracketMapper.toDtoList(wallBrackets);
    }

    public WallBracketResponseDto getWallBracketByIdAndMapToDto(Long id) {
        WallBracket wallBracket = this.getWallBracketById(id);
        return WallBracketMapper.toDto(wallBracket);
    }

    public WallBracketResponseDto updateWallBracketAndMapToDto(Long id, WallBracketRequestDto wallBracketRequestDto) {
        WallBracket wallBracket = this.updateWallBracket(id, wallBracketRequestDto);
        return WallBracketMapper.toDto(wallBracket);
    }
}
