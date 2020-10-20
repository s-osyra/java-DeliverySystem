package com.so.DeliverySystem.buisnessTests.controller;

import com.so.DeliverySystem.controller.PackageController;
import com.so.DeliverySystem.mocks.PackageMock;
import com.so.DeliverySystem.model.Package;
import com.so.DeliverySystem.repository.PackageRepo;
import com.so.DeliverySystem.utilis.PackageUpdate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@DisplayName("When runing PackageContollerTest")
public class PackageControllerTest {
    @Mock
    PackageRepo packageRepo;
    @Mock
    PackageUpdate packageUpdate;
    PackageMock packageMock = new PackageMock();
    Package pack = packageMock.newPackage();
    Optional<Package> optionalPackage = Optional.of(pack);
    @InjectMocks
    PackageController packageController;
    @BeforeEach
    void init () {
        MockitoAnnotations.initMocks(this);
    }
   @Test
   @DisplayName("getPackage should find package")
   void getPackageTest () {
    when ( packageRepo.findById( anyLong() ) ).thenReturn(optionalPackage);
    Package getPack = (Package) packageController.getPackage(1L);
    assertNotNull(getPack);
   }
    @Test
    @DisplayName("updatePackage should update package")
    void updatePackageTest () {
        Map <String, Object> updateValues = new LinkedHashMap<>();
        int newMass = 1999;
        Package updatedPack = pack;
        updatedPack.setMass(newMass);
        when ( packageRepo.findById( anyLong() ) ).thenReturn(optionalPackage);
        when ( packageRepo.save(any(Package.class)) ).thenReturn(pack);
        when ( packageUpdate.update(any(Package.class),anyMap() ) ).thenReturn(updatedPack);
        Package patchPack = (Package) packageController.patchPackage(updateValues, 1L);
        assertEquals(patchPack.getMass(), updatedPack.getMass());
    }
}
