package com.so.DeliverySystem.controller;


import com.so.DeliverySystem.model.LandTransport;
import com.so.DeliverySystem.repository.LandTransportRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LandTransportController {

    @Autowired
    LandTransportRepo landTransportRepo;

    @PostMapping(value = "transport/add/land")
    public LandTransport postLand(@RequestBody LandTransport truck) {

        landTransportRepo.save(truck);
        return truck;
    }

    @GetMapping(value = "transport/get/land/{id}")
    public Object readLand(@PathVariable("id") Long id) {
        try {
            LandTransport truck = landTransportRepo.findById(id).orElseThrow( () -> new IllegalArgumentException ("Invalid truck Id:" + id));
            return truck;
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @DeleteMapping(value = "transport/delete/land/{id}")
    public Object deleteLand(@PathVariable("id") Long id) {
        try {
            LandTransport truck = landTransportRepo.findById(id).orElseThrow( () -> new IllegalArgumentException ("Invalid truck Id:" + id));
            landTransportRepo.delete(truck);
            return "Land transport id=" + id + " has been removed.";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @PutMapping(value = "transport/patch/land/{id}")
    public Object patchLand(@RequestBody LandTransport body, @PathVariable("id") Long id ) {

        try {
            LandTransport truck = landTransportRepo.findById(id).orElseThrow( () -> new IllegalArgumentException ("Invalid truck Id:" + id));
            body.setId(id);
            landTransportRepo.save(body);
            return body;
        } catch (Exception e) {
            return e.getMessage();
        }
    }


    @GetMapping (value = "transport/getall/land")
    public List<LandTransport> getAllLand () {
        return (landTransportRepo.findAll());
    }




}
