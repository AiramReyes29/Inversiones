package com.example.Inversiones.controller;

import com.example.Inversiones.entity.Inversiones;
import com.example.Inversiones.service.InversionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class InversionesController {
    @Autowired

    private InversionesService inversionesService;

    @PostMapping
    public ResponseEntity<Inversiones> addStudent(@RequestBody Inversiones inversiones) {
        System.out.println("Se hizo la solicitud");
        inversionesService.addInversion(inversiones);
        return ResponseEntity.ok(inversiones);
    }

    @GetMapping("/{pornombre}/{monto}")
    public Inversiones getStudentByName(@PathVariable("nombrevariable") String monto) {
        return inversionesService.getInversion(monto);
    }
}
