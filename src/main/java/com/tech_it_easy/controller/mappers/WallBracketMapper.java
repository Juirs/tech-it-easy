package com.tech_it_easy.controller.mappers;

import com.tech_it_easy.controller.dtos.WallBracketRequestDto;
import com.tech_it_easy.controller.dtos.WallBracketResponseDto;
import com.tech_it_easy.controller.models.WallBracket;

import java.util.ArrayList;
import java.util.List;

public class WallBracketMapper {
    public static WallBracket toEntity(WallBracketRequestDto dto) {
        if (dto == null) {
            return null;
        }
        return new WallBracket(dto.name, dto.size, dto.adjustable, dto.price);
    }

    public static WallBracketResponseDto toDto(WallBracket entity) {
        if (entity == null) {
            return null;
        }
        WallBracketResponseDto dto = new WallBracketResponseDto();
        dto.id = entity.getId();
        dto.name = entity.getName();
        dto.size = entity.getSize();
        dto.adjustable = entity.getAdjustable();
        dto.price = entity.getPrice();
        return dto;
    }

    public static List<WallBracketResponseDto> toDtoList(List<WallBracket> entities) {
        if (entities == null || entities.isEmpty()) {
            return new ArrayList<>();
        }
        List<WallBracketResponseDto> dtos = new ArrayList<>();
        for (WallBracket entity : entities) {
            dtos.add(toDto(entity));
        }
        return dtos;
    }
}
