package com.tech_it_easy.controller.mappers;

import com.tech_it_easy.controller.dtos.RemoteControllerRequestDto;
import com.tech_it_easy.controller.dtos.RemoteControllerResponseDto;
import com.tech_it_easy.controller.models.RemoteController;

import java.util.ArrayList;
import java.util.List;

public class RemoteControllerMapper {
    public static RemoteController toEntity(RemoteControllerRequestDto dto) {
        if (dto == null) {
            return null;
        }
        return new RemoteController(dto.compatibleWith, dto.batteryType, dto.name, dto.brand, dto.price, dto.originalStock);
    }

    public static RemoteControllerResponseDto toDto(RemoteController entity) {
        if (entity == null) {
            return null;
        }
        RemoteControllerResponseDto dto = new RemoteControllerResponseDto();
        dto.id = entity.getId();
        dto.compatibleWith = entity.getCompatibleWith();
        dto.batteryType = entity.getBatteryType();
        dto.name = entity.getName();
        dto.brand = entity.getBrand();
        dto.price = entity.getPrice();
        dto.originalStock = entity.getOriginalStock();
        return dto;
    }

    public static List<RemoteControllerResponseDto> toDtoList(List<RemoteController> entities) {
        if (entities == null || entities.isEmpty()) {
            return new ArrayList<>();
        }
        List<RemoteControllerResponseDto> dtos = new ArrayList<>();
        for (RemoteController entity : entities) {
            dtos.add(toDto(entity));
        }
        return dtos;
    }
}
