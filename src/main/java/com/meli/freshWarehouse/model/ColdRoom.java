package com.meli.freshWarehouse.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ColdRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double currentTemperature;

    @Column(nullable = false)
    private Double expectedTemperature;

    @Column(nullable = false)
    private Double roomVolume;

    @Column(nullable = false)
    private LocalDate acquisitionDate;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private Boolean active;

    @Column(nullable = false)
    private LocalDate lastRevision;

    @OneToOne
    private Section section;

//    public ColdRoom(Double currentTemperature, Double expectedTemperature, Double roomVolume, LocalDate acquisitionDate, String model, Boolean active, LocalDate lastRevision) {
//        this.currentTemperature = currentTemperature;
//        this.expectedTemperature = expectedTemperature;
//        this.roomVolume = roomVolume;
//        this.acquisitionDate = acquisitionDate;
//        this.model = model;
//        this.active = active != null && active;
//        this.lastRevision = lastRevision == null? acquisitionDate : lastRevision;
//    }

//    public ColdRoom(Double currentTemperature, Double expectedTemperature, Double roomVolume, LocalDate acquisitionDate, String model, Boolean active, LocalDate lastRevision, Section section) {
//        this.currentTemperature = currentTemperature;
//        this.expectedTemperature = expectedTemperature;
//        this.roomVolume = roomVolume;
//        this.acquisitionDate = acquisitionDate;
//        this.model = model;
//        this.active = active != null && active;
//        this.lastRevision = lastRevision == null? acquisitionDate : lastRevision;
//        this.section = section;
//    }

}