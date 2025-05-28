package com.mantenimientovh.vehiclesmv.infraestructure.repositories;

import com.mantenimientovh.vehiclesmv.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface UserRepository extends JpaRepository<User, String> {
    @Query("select from USER u when u.email = :email")
    boolean existsByEmail(@Param("email") String email);

}
