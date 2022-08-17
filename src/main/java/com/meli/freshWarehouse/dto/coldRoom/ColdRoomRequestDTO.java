package com.meli.freshWarehouse.dto.coldRoom;
import com.meli.freshWarehouse.model.ColdRoom;
import lombok.Getter;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
public class ColdRoomRequestDTO {


    private Long sectionId;

    @NotNull(message = "Current Temperature cannot be null")
    private Double currentTemperature;

    @NotNull(message = "Expected temperature cannot be null")
    private Double expectedTemperature;

    @NotNull(message = "Room Volume cannot be null")
    private Double roomVolume;

    @NotBlank(message = "Model cannot be blank")
    private String model;

    @NotNull(message = "Acquisition Date cannot be null")
    private LocalDate acquisitionDate;

    private LocalDate lastRevision;

    private Boolean active;

    public ColdRoom toModel() {
        return ColdRoom.builder()
                .currentTemperature(this.currentTemperature)
                .expectedTemperature(this.expectedTemperature)
                .roomVolume(this.roomVolume)
                .acquisitionDate(this.acquisitionDate)
                .model(this.model)
                .active(this.active)
                .lastRevision(this.lastRevision)
                .build();
    }

}

