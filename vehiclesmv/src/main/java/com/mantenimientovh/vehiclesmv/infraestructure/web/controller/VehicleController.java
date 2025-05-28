package com.mantenimientovh.vehiclesmv.infraestructure.web.controller;

import com.mantenimientovh.vehiclesmv.application.VehicleService;
import com.mantenimientovh.vehiclesmv.infraestructure.persistence.entities.VehicleEntity;
import com.mantenimientovh.vehiclesmv.infraestructure.web.dto.VehicleDTO;
import com.mantenimientovh.vehiclesmv.infraestructure.web.mapper.VehicleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }


    @PostMapping
    public ResponseEntity<VehicleEntity> registerVehicle(@RequestBody VehicleDTO vehicleDTO) {
        VehicleEntity savedVehicleEntity = vehicleService.registerVehicle(VehicleMapper.dtoToModel(vehicleDTO));

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedVehicleEntity.getId())
                .toUri();

        return ResponseEntity.created(location).body(savedVehicleEntity);
    }

    @GetMapping
    public ResponseEntity<List<VehicleEntity>> getAllVehicles() {
        return ResponseEntity.ok(vehicleService.getAllVehicles());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleEntity> getVehicleById(@PathVariable Long id) {
        return ResponseEntity.ok(vehicleService.getVehicleById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VehicleEntity> updateVehicle(
            @PathVariable Long id,
            @RequestBody VehicleEntity vehicleEntityDetails) {
        return ResponseEntity.ok(vehicleService.updateVehicle(id, vehicleEntityDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable Long id) {
        vehicleService.deleteVehicle(id);
        return ResponseEntity.noContent().build();
    }

    // Endpoints adicionales
    @GetMapping("/owner/{ownerId}")
    public ResponseEntity<List<VehicleEntity>> getVehiclesByOwner(@PathVariable Long ownerId) {
        return ResponseEntity.ok(vehicleService.getVehiclesByOwner(ownerId));
    }

}
