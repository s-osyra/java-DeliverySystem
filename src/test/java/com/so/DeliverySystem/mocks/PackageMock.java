package com.so.DeliverySystem.mocks;

import com.so.DeliverySystem.model.Package;

import java.util.Date;


public class PackageMock {

    public Package newPackage () {
        Package pack = new Package();

        pack.setId(1L);
        pack.setInternationalShipping(false);
        pack.setShipDate(new Date(2020-10-5));
        pack.setMass(20);
        pack.setDimensions("20x20x20");
        pack.setCurrentLocalization("Zabrze-Poland");

        return pack;
    }
}
