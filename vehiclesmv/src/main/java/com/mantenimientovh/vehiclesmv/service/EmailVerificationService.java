package com.mantenimientovh.vehiclesmv.service;

import org.springframework.stereotype.Service;

@Service
public class EmailVerificationService {
    //ProveedorEnvioMail proveedorEnvioMail
    //@Autowired
    // public EmailVerificationService(ProveedorEnvioMail proveedorEnvioMail)


    public void dispatchWelcomeEmailEvent(String email) {
        Exception ex;
        int tryCount = 0;
        do {
            try {
                ex = null;
                tryCount++;
                dispatchEmailEvent(email);
            } catch(Exception exception){
                ex = exception;
            }
        } while(ex != null || tryCount == 3);
    }

    private void dispatchEmailEvent(String email) {
        //proveedorEnvioMail
    }


}
