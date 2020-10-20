package com.so.DeliverySystem.repository;
import com.so.DeliverySystem.model.Package;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PackageRepo extends JpaRepository <Package, Long > {

}
