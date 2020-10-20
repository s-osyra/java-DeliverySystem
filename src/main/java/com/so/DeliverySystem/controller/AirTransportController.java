package com.so.DeliverySystem.controller;

import com.so.DeliverySystem.model.AirTransport;
import com.so.DeliverySystem.repository.AirTransportRepo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class AirTransportController {
    @Autowired
    AirTransportRepo airTransportRepo;
    @ApiOperation(value="Create new air transport.", notes = "Provide information about air transport.")
    @PostMapping(value = "transport/add/air")
    public AirTransport postAir(@RequestBody AirTransport plane) {

        airTransportRepo.save(plane);
        return plane;
    }
    @ApiOperation(value="Return information about air transport.", notes = "Provide unique transport id.")
    @GetMapping(value = "transport/get/air/{id}")
    public Object readAir(@PathVariable("id") Long id) {
        try {
            AirTransport plane = airTransportRepo.findById(id).orElseThrow( () -> new IllegalArgumentException ("Invalid plane Id:" + id));
            return plane;
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    @ApiOperation(value="Delete air transport.", notes = "Provide unique transport id.")
    @DeleteMapping(value = "transport/delete/air/{id}")
    public Object deleteAir(@PathVariable("id") Long id) {
        try {
            AirTransport plane = airTransportRepo.findById(id).orElseThrow( () -> new IllegalArgumentException ("Invalid plane Id:" + id));
            airTransportRepo.delete(plane);
            return "Air transport with id=" + id + " has been removed.";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    @ApiOperation(value="Update information about air transport.", notes = "Provide unique transport id and new transport information.")
    @PutMapping(value = "transport/patch/air/{id}")
    public Object patchAir(@RequestBody AirTransport body, @PathVariable("id") Long id ) {

        try {
            AirTransport plane = airTransportRepo.findById(id).orElseThrow( () -> new IllegalArgumentException ("Invalid plane Id:" + id));
            body.setId(id);
            airTransportRepo.save(body);
            return body;
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    @ApiOperation(value="Return information about all air transports.")
    @GetMapping (value = "transport/getall/air")
    public List<AirTransport> getAllAir () {
        return (airTransportRepo.findAll());
    }
}
