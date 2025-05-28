package com.mantenimientovh.vehiclesmv.infraestructure.persistence.repositories;

import com.mantenimientovh.vehiclesmv.infraestructure.persistence.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface UserRepository extends JpaRepository<UserEntity, String> {
    @Query("select from USER u when u.email = :email")
    boolean existsByEmail(@Param("email") String email);

}
