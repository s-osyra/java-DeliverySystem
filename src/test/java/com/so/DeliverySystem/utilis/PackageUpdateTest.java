package com.so.DeliverySystem.utilis;
import com.so.DeliverySystem.mocks.PackageMock;
import com.so.DeliverySystem.model.Package;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import java.util.LinkedHashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("When runing utilis")
public class PackageUpdateTest {

    @BeforeEach
    void init () {
       packageMock = new PackageMock();
       packageUpdate = new PackageUpdate();
       pack = packageMock.newPackage();
       updateValues = new LinkedHashMap<>();
    }

    PackageMock packageMock;
    PackageUpdate packageUpdate;
    Package pack;
    Map<String, Object> updateValues;

    @Nested
    @DisplayName("PackgaeUpdate update method")
    class updateTest  {
        @Test
        @DisplayName("should update mass value.")
        void massUpdateTest () {
            int newMass = 1999;
            updateValues.put("mass", newMass);
            Package afterUpdate = packageUpdate.update(pack,updateValues);
            assertEquals(afterUpdate.getMass(),newMass);
        }
        @Test
        @DisplayName("should update currentLocalization value.")
        void currentLocalizationUpdateTest () {
            String newCurrentLocalization = "Gliwice-Poland";
            updateValues.put("currentLocalization", newCurrentLocalization);
            Package afterUpdate = packageUpdate.update(pack,updateValues);
            assertEquals(afterUpdate.getCurrentLocalization(),newCurrentLocalization);
        }
        @Test
        @DisplayName("should update dimensions value.")
        void dimensionsUpdateTest () {
            String newDimensions = "3x3x3";
            updateValues.put("dimensions", newDimensions);
            Package afterUpdate = packageUpdate.update(pack,updateValues);
            assertEquals(afterUpdate.getDimensions(),newDimensions);
        }
        @Test
        @DisplayName("should update shipDate value.")
        void shipDateUpdateTest () {
            String newShipDate = "2020-01-01";
            updateValues.put("shipDate", newShipDate);
            Package afterUpdate = packageUpdate.update(pack,updateValues);
            assertEquals(afterUpdate.getShipDate(), java.sql.Date.valueOf(newShipDate));
        }
    }
}
