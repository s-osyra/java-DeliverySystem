package com.so.DeliverySystem.controller;

import com.so.DeliverySystem.model.LandTransport;
import com.so.DeliverySystem.repository.LandTransportRepo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class LandTransportController {
    @Autowired
    LandTransportRepo landTransportRepo;
    @ApiOperation(value="Create new land transport.", notes = "Provide unique information about transport")
    @PostMapping(value = "transport/add/land")
    public LandTransport postLand(@RequestBody LandTransport truck) {

        landTransportRepo.save(truck);
        return truck;
    }
    @ApiOperation(value="Return information about land transport.", notes = "Provide unique transport id.")
    @GetMapping(value = "transport/get/land/{id}")
    public Object readLand(@PathVariable("id") Long id) {
        try {
            LandTransport truck = landTransportRepo.findById(id).orElseThrow( () -> new IllegalArgumentException ("Invalid truck Id:" + id));
            return truck;
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    @ApiOperation(value="Delete land transport.", notes = "Provide unique transport id.")
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
    @ApiOperation(value="Update information about land transport.", notes = "Provide unique transport id and new transport information.")
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
    @ApiOperation(value="Return information about all land transports.")
    @GetMapping (value = "transport/getall/land")
    public List<LandTransport> getAllLand () {
        return (landTransportRepo.findAll());
    }
}
