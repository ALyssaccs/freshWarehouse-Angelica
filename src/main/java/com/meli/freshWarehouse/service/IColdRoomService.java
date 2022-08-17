package com.meli.freshWarehouse.service;

import com.meli.freshWarehouse.model.ColdRoom;

import java.util.List;

public interface IColdRoomService {

    ColdRoom createColdRoom(ColdRoom coldRoom, Long sectionId);

    List<ColdRoom> listAll();

    ColdRoom getColdRoomById(Long id);

    ColdRoom updateColdRoom(ColdRoom coldRoom, Long sectionId);

    ColdRoom toggleActiveColdRoom(Long id, Boolean active);

    ColdRoom executeRevision(Long id);

    ColdRoom setTemperature(Long id, Double temperature);
}
