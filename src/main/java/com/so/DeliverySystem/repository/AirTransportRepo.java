package com.so.DeliverySystem.repository;

import com.so.DeliverySystem.model.AirTransport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirTransportRepo extends JpaRepository<AirTransport, Long> {
}
