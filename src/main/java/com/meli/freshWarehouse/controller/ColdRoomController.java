package com.meli.freshWarehouse.controller;

import com.meli.freshWarehouse.dto.coldRoom.ColdRoomRequestDTO;
import com.meli.freshWarehouse.model.ColdRoom;
import com.meli.freshWarehouse.service.ColdRoomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/fresh-products/coldRoom")
public class ColdRoomController {

    private final ColdRoomService coldRoomService;

    public ColdRoomController(ColdRoomService coldRoomService){
        this.coldRoomService = coldRoomService;
    }

    @PostMapping
    public ResponseEntity<ColdRoom> saveColdRoom(@RequestBody @Valid ColdRoomRequestDTO coldRoomRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(coldRoomService.createColdRoom(coldRoomRequestDTO.toModel(), coldRoomRequestDTO.getSectionId()));
    }

    @GetMapping
    public ResponseEntity<List<ColdRoom>> listAllColdRoom() {
        return ResponseEntity.status(HttpStatus.OK).body(coldRoomService.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ColdRoom> getColdRoomById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(coldRoomService.getColdRoomById(id));
    }

    @PutMapping
    public ResponseEntity<ColdRoom> updateColdRoom(@RequestBody @Valid ColdRoomRequestDTO coldRoomRequestDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(coldRoomService.updateColdRoom(coldRoomRequestDTO.toModel(), coldRoomRequestDTO.getSectionId()));
    }

    @PatchMapping("/toggleActive/{id}")
    public ResponseEntity<ColdRoom> toggleActiveColdRoom(@PathVariable Long id, @RequestParam Boolean active) {
        return ResponseEntity.status(HttpStatus.OK).body(coldRoomService.toggleActiveColdRoom(id, active));
    }

    @PatchMapping("/executeRevision/{id}")
    public ResponseEntity<ColdRoom> executeRevision(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(coldRoomService.executeRevision(id));
    }

    @PatchMapping("/setTemperature/{id}")
    public ResponseEntity<ColdRoom> setTemperature(@PathVariable Long id, Double temperature) {
        return ResponseEntity.status(HttpStatus.OK).body(coldRoomService.setTemperature(id, temperature));
    }

}
