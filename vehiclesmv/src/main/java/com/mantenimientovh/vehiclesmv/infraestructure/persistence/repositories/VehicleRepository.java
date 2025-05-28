package com.mantenimientovh.vehiclesmv.infraestructure.persistence.repositories;

import com.mantenimientovh.vehiclesmv.infraestructure.persistence.entities.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<VehicleEntity, Long> {

    // Métodos básicos ya incluidos en JpaRepository:
    // save(), findById(), findAll(), deleteById(), count(), etc.

    // Buscar vehículos por ownerId
    List<VehicleEntity> findByOwnerId(Long ownerId);

    // Buscar vehículos por marca
    List<VehicleEntity> findByBrand(String brand);

    // Buscar vehículos por marca y modelo
    List<VehicleEntity> findByBrandAndModel(String brand, String model);

    // Buscar vehículos por año mayor o igual
    List<VehicleEntity> findByYearGreaterThanEqual(Integer year);

    // Buscar vehículo por número de placa
    VehicleEntity findByPlateNumber(String plateNumber);

    // Buscar vehículo por VIN
    VehicleEntity findByVin(String vin);

    // Contar vehículos por tipo de motor
    Long countByEngineType(String engineType);

    // Buscar vehículos por color (ignorando mayúsculas/minúsculas)
    List<VehicleEntity> findByColorIgnoreCase(String color);
}

