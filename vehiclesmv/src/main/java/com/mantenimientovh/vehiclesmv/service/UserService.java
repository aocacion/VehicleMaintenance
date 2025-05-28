package com.mantenimientovh.vehiclesmv.service;

import com.mantenimientovh.vehiclesmv.infraestructure.persistence.entities.UserEntity;
import com.mantenimientovh.vehiclesmv.infraestructure.persistence.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repo;
    private final EmailVerificationService emailService;
    //BeanReglasValidacion reglas

    public UserService(UserRepository repo, EmailVerificationService emailService) {
        this.repo = repo;
        this.emailService = emailService;
    }

    @Transactional
    public String save(UserEntity u) {
        if (u == null) throw new RuntimeException("bad request");

        this.verifyEmail(u.getEmail());
        //reglas.validaciones();
        if (u.getCountry().equals("AR")) {
            if (u.getAge() < 18) throw new RuntimeException("too young for AR");
            if (!u.getDocumentType().equals("DNI")) throw new RuntimeException("bad doc type AR");
        } else if (u.getCountry().equals("CL")) {
            if (u.getAge() < 14) throw new RuntimeException("too young for CL");
            if (!u.getDocumentType().equals("RUN")) throw new RuntimeException("bad doc type CL");
        } else {
            throw new RuntimeException("doc type not supported");
        }

        if (u.getStatus() == null || !u.getStatus().equals("VERIFIED")) {
            throw new RuntimeException("doc not verified");
        }

        repo.save(u);



        return "User saved successfully";
    }

    public void createUser(UserEntity user) {
        save(user);
        emailService.dispatchWelcomeEmailEvent(user.getEmail());
    }


    public boolean verifyEmail(String mail){
        //Adiconar validacion formato de mail
        if (mail == null || mail.trim().isEmpty() ) {
            throw new RuntimeException("Mal formato de mail");
        }

        if (repo.existsByEmail(mail)) {
            throw new RuntimeException("Email ya existe");
        }
        return true;
    }
}