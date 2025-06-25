package com.tech_it_easy.controller.dtos;

import com.tech_it_easy.controller.models.RemoteController;
import com.tech_it_easy.controller.models.ScreenQuality;
import com.tech_it_easy.controller.models.ScreenType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.time.LocalDate;

public class TelevisionResponseDto {
    public Long id;
    public String type;
    public String brand;
    public String name;
    public Double price;
    public Double availableSize;
    public int refreshRate;
    public Boolean isSmartTv;
    public Boolean hasWiFi;
    public Boolean hasVoiceControl;
    public Boolean hasHDR;
    public Boolean hasBluetooth;
    public Boolean hasAmbiLight;
    public int originalStock;
    public int sold;
    public RemoteController remoteController;

    public LocalDate soldDate;
    public LocalDate stockDate;

    @Enumerated(EnumType.STRING)
    public ScreenType screenType;

    @Enumerated(EnumType.STRING)
    public ScreenQuality screenQuality;
}
