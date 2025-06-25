package com.tech_it_easy.controller.mappers;

import com.tech_it_easy.controller.dtos.CiModuleRequestDto;
import com.tech_it_easy.controller.dtos.CiModuleResponseDto;
import com.tech_it_easy.controller.models.CiModule;

import java.util.ArrayList;
import java.util.List;

public class CiModuleMapper {
    public static CiModule toEntity(CiModuleRequestDto dto) {
        if (dto == null) {
            return null;
        }
        return new CiModule(dto.name, dto.type, dto.price);
    }

    public static CiModuleResponseDto toDto(CiModule entity) {
        if (entity == null) {
            return null;
        }
        CiModuleResponseDto dto = new CiModuleResponseDto();
        dto.name = entity.getName();
        dto.type = entity.getType();
        dto.price = entity.getPrice();
        return dto;
    }

    public static List<CiModuleResponseDto> toDtoList(List<CiModule> entities) {
        if (entities == null || entities.isEmpty()) {
            return new ArrayList<>();
        }
        List<CiModuleResponseDto> dtos = new ArrayList<>();
        for (CiModule entity : entities) {
            dtos.add(toDto(entity));
        }
        return dtos;
    }
}
