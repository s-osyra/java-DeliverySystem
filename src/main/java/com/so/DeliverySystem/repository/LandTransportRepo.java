package com.so.DeliverySystem.repository;

import com.so.DeliverySystem.model.LandTransport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LandTransportRepo extends JpaRepository<LandTransport, Long> {
}
