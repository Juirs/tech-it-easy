package com.tech_it_easy.controller.dtos;

import com.tech_it_easy.controller.models.RemoteController;
import com.tech_it_easy.controller.models.ScreenQuality;
import com.tech_it_easy.controller.models.ScreenType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public class TelevisionRequestDto {

    @NotBlank(message = "Type cannot be blank")
    public String type;

    @NotEmpty
    public String brand;

    @NotBlank(message = "Name cannot be blank")
    public String name;

    @Min(0)
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

    @Enumerated(EnumType.STRING)
    public ScreenType screenType;

    @Enumerated(EnumType.STRING)
    public ScreenQuality screenQuality;
}