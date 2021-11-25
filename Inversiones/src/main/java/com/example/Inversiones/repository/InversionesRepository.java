package com.example.Inversiones.repository;

import com.example.Inversiones.entity.Inversiones;
import com.example.Inversiones.entity.Tasa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;

@Repository
public class InversionesRepository {
    @Autowired
    InversionesRepositoryDAO inversionesRepositoryDAO;

    public void Inversiones(Inversiones inversiones){
        inversionesRepositoryDAO.save(inversiones);
    }


}
