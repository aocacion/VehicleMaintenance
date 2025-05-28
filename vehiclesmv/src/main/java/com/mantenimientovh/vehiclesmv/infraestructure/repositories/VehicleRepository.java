package com.mantenimientovh.vehiclesmv.infraestructure.repositories;

import com.mantenimientovh.vehiclesmv.domain.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    // Métodos básicos ya incluidos en JpaRepository:
    // save(), findById(), findAll(), deleteById(), count(), etc.

    // Buscar vehículos por ownerId
    List<Vehicle> findByOwnerId(Long ownerId);

    // Buscar vehículos por marca
    List<Vehicle> findByBrand(String brand);

    // Buscar vehículos por marca y modelo
    List<Vehicle> findByBrandAndModel(String brand, String model);

    // Buscar vehículos por año mayor o igual
    List<Vehicle> findByYearGreaterThanEqual(Integer year);

    // Buscar vehículo por número de placa
    Vehicle findByPlateNumber(String plateNumber);

    // Buscar vehículo por VIN
    Vehicle findByVin(String vin);

    // Contar vehículos por tipo de motor
    Long countByEngineType(String engineType);

    // Buscar vehículos por color (ignorando mayúsculas/minúsculas)
    List<Vehicle> findByColorIgnoreCase(String color);
}

