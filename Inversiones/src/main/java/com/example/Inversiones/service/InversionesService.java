package com.example.Inversiones.service;

import com.example.Inversiones.entity.Inversiones;
import com.example.Inversiones.repository.InversionesRepository;
import net.bytebuddy.agent.builder.AgentBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InversionesService {
    @Autowired
    InversionesRepository inversionesRepository;

    public void addInversion(Inversiones inversiones){
        inversionesRepository.Inversiones(inversiones);
    }

    public List<Inversiones> getLista() {
        return null;
    }

    public Inversiones getInversion(String monto) {
        return null;
    }

}
