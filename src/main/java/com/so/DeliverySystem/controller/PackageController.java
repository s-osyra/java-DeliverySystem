package com.so.DeliverySystem.controller;


import com.so.DeliverySystem.model.AirTransport;
import com.so.DeliverySystem.model.LandTransport;
import com.so.DeliverySystem.model.Package;
import com.so.DeliverySystem.repository.AirTransportRepo;
import com.so.DeliverySystem.repository.LandTransportRepo;
import com.so.DeliverySystem.repository.PackageRepo;
import com.so.DeliverySystem.utilis.PackageUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class PackageController {

    @Autowired
    PackageRepo packageRepo;
    @Autowired
    PackageUpdate packageUpdate;
    @Autowired
    LandTransportRepo landTransportRepo;
    @Autowired
    AirTransportRepo airTransportRepo;

    @PostMapping (value ="package/new")
    public Package newPackage (@RequestBody Package newPackage) {
        packageRepo.save(newPackage);
        return newPackage;
    }
    @PutMapping (value = "package/update/{id}")
    public Object patchPackage (@RequestBody Map<String, Object> aPackage,  @PathVariable("id") long id) {
        try {
            Package pack = packageRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid package Id:" + id));
            pack = packageUpdate.update(pack, aPackage);
            packageRepo.save(pack);
            return pack;
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    @GetMapping (value = "package/get/{id}")
    public Object getPackage (@PathVariable("id") long id) {
        try {
            Package pack = packageRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid package Id:" + id));
            return pack;
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    @PutMapping(value = "package/transport/add/{packid}+{transportid}")
    public Object addTransporPack ( @PathVariable("packid") long idPack, @PathVariable("transportid") Long idTransport )  {

        Package pack = packageRepo.findById(idPack).orElseThrow(() -> new IllegalArgumentException("Invalid package Id:" + idPack));

        Optional<AirTransport> isPlane = airTransportRepo.findById(idTransport);
        Optional<LandTransport> isTruck = landTransportRepo.findById(idTransport);
        List transportList = pack.getTransportId();

        try {
            if (isPlane.isPresent()) {
                AirTransport plane = isPlane.get();
                transportList.add(plane);
            } else if (isTruck.isPresent()) {
                LandTransport truck = isTruck.get();
                transportList.add(truck);
            } else {
                throw new IllegalArgumentException("Invalid package Id:" + idPack);
            }
            packageRepo.save(pack);
            return pack;
        } catch (IllegalArgumentException e) {
            return e;
        } catch (Exception e) {
            String error = e.getCause().getCause().getMessage();
            Map<String, String> err = new HashMap<>();
            err.put("error", error);
            return err ;
        }

    }


    @DeleteMapping(value = "package/transport/remove/{packid}+{transportid}")
    public Object removeTransporPack ( @PathVariable("packid") long idPack, @PathVariable("transportid") Long idTransport )  {

        Package pack = packageRepo.findById(idPack).orElseThrow(() -> new IllegalArgumentException("Invalid package Id:" + idPack));

        Optional<AirTransport> isPlane = airTransportRepo.findById(idTransport);
        Optional<LandTransport> isTruck = landTransportRepo.findById(idTransport);
        List transportList = pack.getTransportId();

        try {
            if (isPlane.isPresent()) {
                AirTransport plane = isPlane.get();
                transportList.remove(plane);
            } else if (isTruck.isPresent()) {
                LandTransport truck = isTruck.get();
                transportList.remove(truck);
            } else {
                throw new IllegalArgumentException("Invalid package Id:" + idPack);
            }
            packageRepo.save(pack);
            return pack;
        } catch (IllegalArgumentException e) {
            return e;
        } catch (Exception e) {
            String error = e.getCause().getCause().getMessage();
            Map<String, String> err = new HashMap<>();
            err.put("error", error);
            return err ;
        }

    }


    @GetMapping (value = "package/getall")
    public List<Package> allPackage () {

        List<Package> allPackages = packageRepo.findAll();

        System.out.println(allPackages);
        return allPackages;

    }



    @DeleteMapping (value = "package/delete/{id}")
    public Object deletePackage ( @PathVariable("id") long id) {
        try {
            Package pack = packageRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid package Id:" + id));
            packageRepo.delete(pack);
            return "Package id=" + id + " has been removed.";
        } catch (Exception e) {
            return e.getMessage();
        }

    }





    @GetMapping (value = "test/{id}")
    @ResponseBody
    public void info (@RequestBody Map<String,Object> aPackage, @PathVariable("id") long id) {
            Package pack = packageRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid package Id:" + id));

    }


}
