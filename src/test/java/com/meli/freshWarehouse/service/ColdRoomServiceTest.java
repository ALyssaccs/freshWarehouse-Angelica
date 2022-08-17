package com.meli.freshWarehouse.service;

import com.meli.freshWarehouse.model.ColdRoom;
import com.meli.freshWarehouse.model.Section;
import com.meli.freshWarehouse.model.Warehouse;
import com.meli.freshWarehouse.repository.ColdRoomRepo;
import com.meli.freshWarehouse.repository.ISectionRepo;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class ColdRoomServiceTest {

    @InjectMocks
    private ColdRoomService coldRoomService;

    @Mock
    private SectionService sectionService;

    @Mock
    private ColdRoomRepo coldRoomRepo;

    private static Warehouse warehouse = Warehouse.builder()
            .id(1L)
            .address("TestAdress")
            .city("Testcity")
            .state("TestState")
            .country("TestCountry")
            .number(12)
            .build();

    private static Section section = Section.builder()
            .id(1L)
            .name("Section A")
            .availableSpace(100)
            .warehouse(warehouse)
            .build();
    private static ColdRoom coldRoom = ColdRoom.builder()
            .id(1L)
            .currentTemperature(20D)
            .expectedTemperature(18D)
            .roomVolume(300D)
            .acquisitionDate(LocalDate.of(2021,
                    04,
                    12))
            .model("Test Model")
            .active(true)
            .lastRevision(LocalDate.of(2022
                    , 06
                    , 15))
            .section(section)
            .build();

    @Test
    void createColdRoomTest() {
        BDDMockito.when(coldRoomRepo.save(ArgumentMatchers.any(ColdRoom.class)))
                .thenReturn(coldRoom);
        BDDMockito.when(sectionService.getById(ArgumentMatchers.anyLong()))
                .thenReturn(section);

        ColdRoom sentColdRoom = coldRoomService.createColdRoom(coldRoom, 1L);
        assertEquals(sentColdRoom, coldRoom);
        verify(coldRoomRepo).save(coldRoom);
        verify(sectionService).getById(1L);
    }

    @Test
    void listAllTest() {
        List<ColdRoom> coldRoomList = new ArrayList<>();
        coldRoomList.add(coldRoom);
        BDDMockito.when(coldRoomRepo.findAll())
                .thenReturn(coldRoomList);

        List<ColdRoom> coldRoomServiceList = coldRoomService.listAll();

        assertEquals(coldRoomList, coldRoomServiceList);
        verify(coldRoomRepo).findAll();
    }

    @Test
    void getColdRoomByIdTest() {
        BDDMockito.when(coldRoomRepo.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.ofNullable(coldRoom));

        ColdRoom savedColdRoom = coldRoomService.getColdRoomById(1L);

        assertEquals(savedColdRoom, coldRoom);
        verify(coldRoomRepo).findById(1L);
    }

    @Test
    void updateColdRoomTest() {
        BDDMockito.when(coldRoomRepo.save(ArgumentMatchers.any(ColdRoom.class)))
                .thenReturn(coldRoom);
        BDDMockito.when(sectionService.getById(ArgumentMatchers.anyLong()))
                .thenReturn(section);

        ColdRoom sentColdRoom = coldRoomService.updateColdRoom(coldRoom, 1L);
        assertEquals(sentColdRoom, coldRoom);
        verify(coldRoomRepo).save(coldRoom);
        verify(sectionService).getById(1L);
    }

    @Test
    void toggleActiveColdRoomTest() {
        ColdRoom patchedColdRoom = ColdRoom.builder()
                .id(1L)
                .currentTemperature(20D)
                .expectedTemperature(18D)
                .roomVolume(300D)
                .acquisitionDate(LocalDate.of(2021,
                        04,
                        12))
                .model("Test Model")
                .active(false)
                .lastRevision(LocalDate.of(2022
                        , 06
                        , 15))
                .section(section)
                .build();

        BDDMockito.when(coldRoomRepo.save(ArgumentMatchers.any(ColdRoom.class)))
                .thenReturn(patchedColdRoom);
        BDDMockito.when(coldRoomRepo.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.ofNullable(coldRoom));

        ArgumentCaptor<ColdRoom> captor = ArgumentCaptor.forClass(ColdRoom.class);

        ColdRoom testColdRoom = coldRoomService.toggleActiveColdRoom(1L, false);
        assertEquals(testColdRoom, patchedColdRoom);
        verify(coldRoomRepo).save(captor.capture());
        assertEquals(false, captor.getValue().getActive());
        verify(coldRoomRepo).findById(1L);
    }

    @Test
    void executeRevisionTest() {
        ColdRoom patchedColdRoom = ColdRoom.builder()
                .id(1L)
                .currentTemperature(20D)
                .expectedTemperature(18D)
                .roomVolume(300D)
                .acquisitionDate(LocalDate.of(2021,
                        04,
                        12))
                .model("Test Model")
                .active(true)
                .lastRevision(LocalDate.now())
                .section(section)
                .build();

        BDDMockito.when(coldRoomRepo.save(ArgumentMatchers.any(ColdRoom.class)))
                .thenReturn(patchedColdRoom);
        BDDMockito.when(coldRoomRepo.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.ofNullable(coldRoom));

        ArgumentCaptor<ColdRoom> captor = ArgumentCaptor.forClass(ColdRoom.class);

        ColdRoom testColdRoom = coldRoomService.executeRevision(1L);
        assertEquals(testColdRoom, patchedColdRoom);
        verify(coldRoomRepo).save(captor.capture());
        assertEquals(LocalDate.now(), captor.getValue().getLastRevision());
        verify(coldRoomRepo).findById(1L);
    }

    @Test
    void setTemperatureTest() {
        ColdRoom patchedColdRoom = ColdRoom.builder()
                .id(1L)
                .currentTemperature(20D)
                .expectedTemperature(10D)
                .roomVolume(300D)
                .acquisitionDate(LocalDate.of(2021,
                        04,
                        12))
                .model("Test Model")
                .active(true)
                .lastRevision(LocalDate.of(2022
                        , 06
                        , 15))
                .section(section)
                .build();

        BDDMockito.when(coldRoomRepo.save(ArgumentMatchers.any(ColdRoom.class)))
                .thenReturn(patchedColdRoom);
        BDDMockito.when(coldRoomRepo.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.ofNullable(coldRoom));

        ArgumentCaptor<ColdRoom> captor = ArgumentCaptor.forClass(ColdRoom.class);

        ColdRoom testColdRoom = coldRoomService.setTemperature(1L, 10D);
        assertEquals(testColdRoom, patchedColdRoom);
        verify(coldRoomRepo).save(captor.capture());
        assertEquals(10, captor.getValue().getExpectedTemperature());
        verify(coldRoomRepo).findById(1L);
    }

}
