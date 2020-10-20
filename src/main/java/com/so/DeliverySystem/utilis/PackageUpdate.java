package com.so.DeliverySystem.utilis;

import com.so.DeliverySystem.model.Package;
import com.so.DeliverySystem.repository.PackageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Set;

@Service
public class PackageUpdate {

    @Autowired
    PackageRepo packageRepo;

    public Package update (Package pack, Map<String, Object> data) {

        Set keys = data.keySet();

        if (keys.contains("currentLocalization")) {
            pack.setCurrentLocalization( (String) data.get("currentLocalization"));
        }

        if (keys.contains("dimensions")){
            pack.setDimensions((String) data.get("dimensions"));
        }

        if (keys.contains("mass")){
            pack.setMass((Integer) data.get("mass"));
        }
        if (keys.contains("shipDate")){
            String newDate = (String) data.get("shipDate");
            SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();

            try {
                date = format.parse(newDate);
            }
            catch (Exception e) {
            }

            pack.setShipDate(date);
        }

        if (keys.contains("internationalShipping")){
            pack.setInternationalShipping((boolean) data.get("internationalShipping"));
        }


        return pack;
    }



}
