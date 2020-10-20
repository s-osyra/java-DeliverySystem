package com.so.DeliverySystem.repository;
import com.so.DeliverySystem.model.ModeOfTransportation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ModeOfTransportRepo extends JpaRepository <ModeOfTransportation, Integer> {
}
