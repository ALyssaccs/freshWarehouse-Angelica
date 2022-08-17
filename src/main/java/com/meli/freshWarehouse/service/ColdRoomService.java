package com.meli.freshWarehouse.service;

import com.meli.freshWarehouse.exception.ColdRoomNotFoundException;
import com.meli.freshWarehouse.model.ColdRoom;
import com.meli.freshWarehouse.model.Section;
import com.meli.freshWarehouse.repository.ColdRoomRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ColdRoomService implements IColdRoomService {

    private final ColdRoomRepo coldRoomRepo;

    private final SectionService sectionService;

    public ColdRoomService(ColdRoomRepo coldRoomRepo, SectionService sectionService) {
        this.coldRoomRepo = coldRoomRepo;
        this.sectionService = sectionService;
    }

    @Override
    public ColdRoom createColdRoom(ColdRoom coldRoom, Long sectionId) {
        Section section = sectionService.getById(sectionId);
        coldRoom.setSection(section);
        return coldRoomRepo.save(coldRoom);
    }

    @Override
    public List<ColdRoom> listAll() {
        return coldRoomRepo.findAll();
    }

    @Override
    public ColdRoom getColdRoomById(Long id) {
        return coldRoomRepo.findById(id).orElseThrow(() -> new ColdRoomNotFoundException("Couldn't find a Cold Room by specified ID."));
    }

    @Override
    public ColdRoom updateColdRoom(ColdRoom coldRoom, Long sectionId) {
        Section section = sectionService.getById(sectionId);
        coldRoom.setSection(section);
        return coldRoomRepo.save(coldRoom);
    }

    public ColdRoom toggleActiveColdRoom(Long id, Boolean active) {
        ColdRoom coldRoom = getColdRoomById(id);
        coldRoom.setActive(active);
        return coldRoomRepo.save(coldRoom);
    }

    public ColdRoom executeRevision(Long id) {
        ColdRoom coldRoom = getColdRoomById(id);
        coldRoom.setLastRevision(LocalDate.now());
        return coldRoomRepo.save(coldRoom);
    }

    @Override
    public ColdRoom setTemperature(Long id, Double temperature) {
        ColdRoom coldRoom = getColdRoomById(id);
        coldRoom.setExpectedTemperature(temperature);
        return coldRoomRepo.save(coldRoom);
    }

}
