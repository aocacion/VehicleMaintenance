package com.mantenimientovh.vehiclesmv.application;

import com.mantenimientovh.vehiclesmv.domain.model.Vehicle;
import com.mantenimientovh.vehiclesmv.infraestructure.persistence.entities.VehicleEntity;
import com.mantenimientovh.vehiclesmv.infraestructure.persistence.repositories.VehicleRepository;
import com.mantenimientovh.vehiclesmv.infraestructure.web.mapper.VehicleMapper;
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
    public VehicleEntity registerVehicle(Vehicle vehicle) {
        return vehicleRepository.save(VehicleMapper.modelToEntity(vehicle));
    }

    // Obtener todos los vehículos
    @Transactional(readOnly = true)
    public List<VehicleEntity> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    // Obtener vehículo por ID
    @Transactional(readOnly = true)
    public VehicleEntity getVehicleById(Long id) {
        return vehicleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehículo no encontrado con ID: " + id));
    }

    // Actualizar vehículo
    public VehicleEntity updateVehicle(Long id, VehicleEntity vehicleEntityDetails) {
        VehicleEntity vehicleEntity = getVehicleById(id);

        if (vehicleEntityDetails.getBrand() != null) {
            vehicleEntity.setBrand(vehicleEntityDetails.getBrand());
        }

        if (vehicleEntityDetails.getModel() != null) {
            vehicleEntity.setModel(vehicleEntityDetails.getModel());
        }

        // Actualizar otros campos según necesidad...

        return vehicleRepository.save(vehicleEntity);
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
    public List<VehicleEntity> getVehiclesByOwner(Long ownerId) {
        return vehicleRepository.findByOwnerId(ownerId);
    }
}
