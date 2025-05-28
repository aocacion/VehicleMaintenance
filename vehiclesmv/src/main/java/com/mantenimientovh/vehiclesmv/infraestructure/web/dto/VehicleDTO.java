package com.mantenimientovh.vehiclesmv.infraestructure.web.dto;

public record VehicleDTO(
        Long ownerId,
        String brand,
        String model,
        Integer year,
        String plateNumber,
        String vin,
        String color,
        String engineType,
        Integer mileage
) {}
