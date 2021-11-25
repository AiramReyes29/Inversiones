package com.example.Inversiones.repository;

import com.example.Inversiones.controller.noCuenta;
import com.example.Inversiones.entity.Cuenta;
import com.example.Inversiones.entity.Inversiones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Repository
public class InversionesRepository {
    @Autowired
    InversionesRepositoryDAO inversionesRepositoryDAO;

    public boolean Inversiones(Inversiones inversiones){
        try {
            inversionesRepositoryDAO.save(inversiones);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public List<Inversiones> inversionesList(){
        return(List<Inversiones>) inversionesRepositoryDAO.findAll();
    }

    public Integer obtenerIdCuenta(List<Cuenta> cuentaCliente, double saldo) {
        for (int x = 0; x < cuentaCliente.size(); x++){
            if(cuentaCliente.get(x).getSaldo() == saldo){
                return cuentaCliente.get(x).getIdCuenta();
            }
            return null;
        }
        return null;
    }

    //public Optional<Inversiones> getListaInversion(Integer idUsuario) {
      //  return inversionesRepositoryDAO.findByIdUsuario(idUsuario);
    //}

    private RestTemplate restTemplate = new RestTemplate();


    public boolean crearNuevaInversion(Inversiones inversiones) {
        try {
            Integer inventarioId = restTemplate.getForObject("http://localhost:8081/usuarios/enviarid", Integer.class);
            inversiones.setIdUsuario(inventarioId);
            inversionesRepositoryDAO.save(inversiones);
            return true;
        }catch (Exception e){
            System.out.println(e.toString());
           return false;
        }
    }
}
