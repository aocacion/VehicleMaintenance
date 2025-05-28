package com.mantenimientovh.vehiclesmv.infraestructure.web.mapper;

import com.mantenimientovh.vehiclesmv.domain.model.Vehicle;
import com.mantenimientovh.vehiclesmv.infraestructure.persistence.entities.VehicleEntity;
import com.mantenimientovh.vehiclesmv.infraestructure.web.dto.VehicleDTO;

public class VehicleMapper {
    public static VehicleDTO modelToDto(Vehicle vehicle) {
        return new VehicleDTO(
                vehicle.getOwnerId(),
                vehicle.getBrand(),
                vehicle.getModel(),
                vehicle.getYear(),
                vehicle.getPlateNumber(),
                vehicle.getVin(),
                vehicle.getColor(),
                vehicle.getEngineType(),
                vehicle.getMileage()
        );
    }

    public static Vehicle dtoToModel(VehicleDTO dto) {
        Vehicle vehicle = new Vehicle();
        vehicle.setOwnerId(dto.ownerId());
        vehicle.setBrand(dto.brand());
        vehicle.setModel(dto.model());
        vehicle.setYear(dto.year());
        vehicle.setPlateNumber(dto.plateNumber());
        vehicle.setVin(dto.vin());
        vehicle.setColor(dto.color());
        vehicle.setEngineType(dto.engineType());
        vehicle.setMileage(dto.mileage());
        return vehicle;
    }

    public static VehicleEntity modelToEntity(Vehicle vehicle) {
        return new VehicleEntity(
                vehicle.getOwnerId(),
                vehicle.getBrand(),
                vehicle.getModel(),
                vehicle.getYear(),
                vehicle.getPlateNumber(),
                vehicle.getVin(),
                vehicle.getColor(),
                vehicle.getEngineType(),
                vehicle.getMileage()
        );
    }

    public static Vehicle entityToModel(VehicleEntity entity) {
        Vehicle vehicle = new Vehicle();
        vehicle.setOwnerId(entity.getOwnerId());
        vehicle.setBrand(entity.getBrand());
        vehicle.setModel(entity.getModel());
        vehicle.setYear(entity.getYear());
        vehicle.setPlateNumber(entity.getPlateNumber());
        vehicle.setVin(entity.getVin());
        vehicle.setColor(entity.getColor());
        vehicle.setEngineType(entity.getEngineType());
        vehicle.setMileage(entity.getMileage());
        return vehicle;
    }
}