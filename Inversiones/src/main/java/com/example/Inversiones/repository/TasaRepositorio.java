package com.example.Inversiones.repository;

import com.example.Inversiones.entity.Tasa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@PropertySource("tasa.properties")
public class TasaRepositorio {
    @Autowired
    TasaRepositorioDAO tasaRepositorioDAO;

    @Value("${inversion.tasaMinima}")
    private double tasaMinima;
    @Value("${inversion.tasaMedia}")
    private double tasaMedia;
    @Value("${inversion.tasaMaxima}")
    private double tasaMaxima;

    private boolean primeraVez = true;
    public boolean crearTasas(){
        try{
            if(primeraVez) {
                tasaRepositorioDAO.save(new Tasa(tasaMinima));
                tasaRepositorioDAO.save(new Tasa(tasaMedia));
                tasaRepositorioDAO.save(new Tasa(tasaMaxima));
                primeraVez = false;
                return true;
            }
            return false;
        }catch (Exception e){
            System.out.println("Ocurrio un error al crear tasas: " + e.toString());
            return false;
        }
    }

    public List<Tasa> encontrarTodasLasTasas(){
        return (List<Tasa>) tasaRepositorioDAO.findAll();
    }
}
