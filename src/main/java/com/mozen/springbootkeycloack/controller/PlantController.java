package com.mozen.springbootkeycloack.controller;

import com.mozen.springbootkeycloack.model.Plant;
import com.mozen.springbootkeycloack.service.PlantService;
import com.sun.istack.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController()
@RequestMapping("/plant")
public class PlantController {

    private PlantService plantService;

    public PlantController(PlantService plantService) {
        this.plantService = plantService;
    }

    @GetMapping("/{plantId}")
    public Plant getPlant(@PathVariable @NotNull Long plantId) {

        log.info("Request for plant " + plantId + " received");

        return plantService.getPlant(plantId);
    }

    @DeleteMapping("/{plantId}")
    public void deletePlant(@PathVariable long plantId) {

        log.info("Delete plant request for plant " + plantId + " received");

        plantService.deletePlant(plantId);
    }
}
