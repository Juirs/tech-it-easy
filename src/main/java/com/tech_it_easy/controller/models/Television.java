package com.tech_it_easy.controller.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "televisions")
public class Television {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String brand;
    private String name;
    private Double price;
    private Double availableSize;
    private int refreshRate;
    private Boolean isSmartTv;
    private Boolean hasWiFi;
    private Boolean hasVoiceControl;
    private Boolean hasHDR;
    private Boolean hasBluetooth;
    private Boolean hasAmbiLight;
    private int originalStock;
    private int sold;

    @JsonManagedReference
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "remote_controller_id")
    private RemoteController remoteController;

    private LocalDate soldDate;
    private LocalDate stockDate;

    @Enumerated(EnumType.STRING)
    private ScreenType screenType;

    @Enumerated(EnumType.STRING)
    private ScreenQuality screenQuality;

    public Television() {}

    public Television(String type, String brand, String name, Double price, Double availableSize, int refreshRate,
                      Boolean isSmartTv, Boolean hasWiFi, Boolean hasVoiceControl, Boolean hasHDR,
                      Boolean hasBluetooth, Boolean hasAmbiLight, int originalStock, int sold,
                      ScreenType screenType, ScreenQuality screenQuality, RemoteController remoteController) {
        this.type = type;
        this.brand = brand;
        this.name = name;
        this.price = price;
        this.availableSize = availableSize;
        this.refreshRate = refreshRate;
        this.isSmartTv = isSmartTv;
        this.hasWiFi = hasWiFi;
        this.hasVoiceControl = hasVoiceControl;
        this.hasHDR = hasHDR;
        this.hasBluetooth = hasBluetooth;
        this.hasAmbiLight = hasAmbiLight;
        this.originalStock = originalStock;
        this.sold = sold;
        this.soldDate = soldDate;
        this.stockDate = stockDate;
        this.screenType = screenType;
        this.screenQuality = screenQuality;
        this.remoteController = remoteController;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getAvailableSize() {
        return availableSize;
    }

    public void setAvailableSize(Double availableSize) {
        this.availableSize = availableSize;
    }

    public int getRefreshRate() {
        return refreshRate;
    }

    public void setRefreshRate(int refreshRate) {
        this.refreshRate = refreshRate;
    }

    public Boolean getIsSmartTv() {
        return isSmartTv;
    }

    public void setSmartTv(Boolean smartTv) {
        isSmartTv = smartTv;
    }

    public Boolean getHasWiFi() {
        return hasWiFi;
    }

    public void setHasWiFi(Boolean hasWiFi) {
        this.hasWiFi = hasWiFi;
    }

    public Boolean getHasVoiceControl() {
        return hasVoiceControl;
    }

    public void setHasVoiceControl(Boolean hasVoiceControl) {
        this.hasVoiceControl = hasVoiceControl;
    }

    public Boolean getHasHDR() {
        return hasHDR;
    }

    public void setHasHDR(Boolean hasHDR) {
        this.hasHDR = hasHDR;
    }

    public Boolean getHasBluetooth() {
        return hasBluetooth;
    }

    public void setHasBluetooth(Boolean hasBluetooth) {
        this.hasBluetooth = hasBluetooth;
    }

    public Boolean getHasAmbiLight() {
        return hasAmbiLight;
    }

    public void setHasAmbiLight(Boolean hasAmbiLight) {
        this.hasAmbiLight = hasAmbiLight;
    }

    public int getOriginalStock() {
        return originalStock;
    }

    public void setOriginalStock(int originalStock) {
        this.originalStock = originalStock;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }

    public LocalDate getSoldDate() {
        return soldDate;
    }

    public void setSoldDate(LocalDate soldDate) {
        this.soldDate = soldDate;
    }

    public LocalDate getStockDate() {
        return stockDate;
    }

    public void setStockDate(LocalDate stockDate) {
        this.stockDate = stockDate;
    }

    public ScreenType getScreenType() {
        return screenType;
    }

    public void setScreenType(ScreenType screenType) {
        this.screenType = screenType;
    }

    public ScreenQuality getScreenQuality() {
        return screenQuality;
    }

    public void setScreenQuality(ScreenQuality screenQuality) {
        this.screenQuality = screenQuality;
    }

    public RemoteController getRemoteController() {
        return remoteController;
    }

    public void setRemoteController(RemoteController remoteController) {
        this.remoteController = remoteController;
    }
}
