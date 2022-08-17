package com.meli.freshWarehouse.repository;

import com.meli.freshWarehouse.model.ColdRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColdRoomRepo extends JpaRepository<ColdRoom, Long> {
}
