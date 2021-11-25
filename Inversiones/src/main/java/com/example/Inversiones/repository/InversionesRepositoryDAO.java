package com.example.Inversiones.repository;

import com.example.Inversiones.entity.Inversiones;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface InversionesRepositoryDAO extends CrudRepository<Inversiones, Integer> {

    List<Inversiones> findByIdUsuario(Integer idUsuario);


}

