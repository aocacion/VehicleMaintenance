package com.mantenimientovh.vehiclesmv.application;

import com.mantenimientovh.vehiclesmv.domain.entities.Vehicle;
import com.mantenimientovh.vehiclesmv.infraestructure.repositories.VehicleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    // Registrar un nuevo vehículo
    public Vehicle registerVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    // Obtener todos los vehículos
    @Transactional(readOnly = true)
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    // Obtener vehículo por ID
    @Transactional(readOnly = true)
    public Vehicle getVehicleById(Long id) {
        return vehicleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehículo no encontrado con ID: " + id));
    }

    // Actualizar vehículo
    public Vehicle updateVehicle(Long id, Vehicle vehicleDetails) {
        Vehicle vehicle = getVehicleById(id);

        if (vehicleDetails.getBrand() != null) {
            vehicle.setBrand(vehicleDetails.getBrand());
        }

        if (vehicleDetails.getModel() != null) {
            vehicle.setModel(vehicleDetails.getModel());
        }

        // Actualizar otros campos según necesidad...

        return vehicleRepository.save(vehicle);
    }

    // Eliminar vehículo
    public void deleteVehicle(Long id) {
        if (!vehicleRepository.existsById(id)) {
            throw new RuntimeException("Vehículo no encontrado con ID: " + id);
        }
        vehicleRepository.deleteById(id);
    }

    // Métodos adicionales
    @Transactional(readOnly = true)
    public List<Vehicle> getVehiclesByOwner(Long ownerId) {
        return vehicleRepository.findByOwnerId(ownerId);
    }
}
