package com.tech_it_easy.controller.mappers;

import com.tech_it_easy.controller.dtos.TelevisionRequestDto;
import com.tech_it_easy.controller.models.Television;
import com.tech_it_easy.controller.dtos.TelevisionResponseDto;
import com.tech_it_easy.controller.dtos.TelevisionSalesDto;

import java.util.ArrayList;
import java.util.List;

public class TelevisionMapper {
    public static Television toEntity(TelevisionRequestDto dto) {
        if (dto == null) {
            return null;
        }
        return new Television(dto.type, dto.brand, dto.name,
                              dto.price, dto.availableSize, dto.refreshRate,
                              dto.isSmartTv, dto.hasWiFi, dto.hasVoiceControl,
                              dto.hasHDR, dto.hasBluetooth, dto.hasAmbiLight,
                              dto.originalStock, dto.sold, dto.screenType, dto.screenQuality, dto.remoteController);
    }

    public static TelevisionResponseDto toDto(Television tv) {
        if (tv == null) {
            return null;
        }
        TelevisionResponseDto dto = new TelevisionResponseDto();
        dto.id = tv.getId();
        dto.type = tv.getType();
        dto.brand = tv.getBrand();
        dto.name = tv.getName();
        dto.price = tv.getPrice();
        dto.availableSize = tv.getAvailableSize();
        dto.refreshRate = tv.getRefreshRate();
        dto.isSmartTv = tv.getIsSmartTv();
        dto.hasWiFi = tv.getHasWiFi();
        dto.hasVoiceControl = tv.getHasVoiceControl();
        dto.hasHDR = tv.getHasHDR();
        dto.hasBluetooth = tv.getHasBluetooth();
        dto.hasAmbiLight = tv.getHasAmbiLight();
        dto.originalStock = tv.getOriginalStock();
        dto.sold = tv.getSold();
        dto.soldDate = tv.getSoldDate();
        dto.stockDate = tv.getStockDate();
        dto.screenType = tv.getScreenType();
        dto.screenQuality = tv.getScreenQuality();
        if (tv.getRemoteController() != null) {
            dto.remoteController = tv.getRemoteController();
        }
        return dto;
    }

    public static List<TelevisionResponseDto> toDtoList(List<Television> televisions) {
        if (televisions == null || televisions.isEmpty()) {
            return new ArrayList<>();
        }
        List<TelevisionResponseDto> dtos = new ArrayList<>();
        for (Television tv : televisions) {
            dtos.add(toDto(tv));
        }
        return dtos;
    }

    public static TelevisionSalesDto toSalesDto(Television tv) {
        if (tv == null) {
            return null;
        }
        return new TelevisionSalesDto(tv.getId(), tv.getPrice(), tv.getOriginalStock(), tv.getSold());
    }

    public static List<TelevisionSalesDto> toSalesDtoList(List<Television> televisions) {
        if (televisions == null || televisions.isEmpty()) {
            return new ArrayList<>();
        }
        List<TelevisionSalesDto> salesDtos = new ArrayList<>();
        for (Television tv : televisions) {
            salesDtos.add(toSalesDto(tv));
        }
        return salesDtos;
    }
}