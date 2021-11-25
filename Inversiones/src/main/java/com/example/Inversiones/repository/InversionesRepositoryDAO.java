package com.example.Inversiones.repository;

import com.example.Inversiones.entity.Inversiones;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface InversionesRepositoryDAO extends CrudRepository<Inversiones, Integer> {
    //Optional<Inversiones> findByIdUsuario(Integer idUsuario);
    @Query(value = "select i from inversiones i where i.idUsuario = :idUsuario")
    Optional<Inversiones> findByIdUsuario(Integer idUsuario);
}

