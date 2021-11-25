package com.example.Inversiones.controller;

import com.example.Inversiones.entity.Cuenta;
import com.example.Inversiones.entity.Inversiones;
import com.example.Inversiones.repository.InversionesRepository;
import com.example.Inversiones.service.InversionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/apiInversiones")
public class InversionesController {


    private Integer idUsuario;
    private List<Cuenta> cuentaCliente;
    private  Integer idCuenta;


    @Autowired

    private InversionesService inversionesService;

    @Autowired

    private InversionesRepository inversionesRepository;

    @GetMapping("/idusuario")
    public Integer getUsuarioPorId(){
        idUsuario = inversionesService.obtenerId();
        return idUsuario;
    }

    @PostMapping("/{inversion}")
    public ResponseEntity<Inversiones> addInversion(@RequestBody Inversiones inversiones) {
        System.out.println("Finalizada");
        inversionesService.addInversion(inversiones);
        return ResponseEntity.ok(inversiones);
    }

    @GetMapping("/inversiones")
    public Inversiones getStudentByName(@PathVariable("nombrevariable") String monto) {
        return inversionesService.getInversion(monto);
    }

    @GetMapping("/verInversiones")
    public List<Inversiones> verCuentas(){return inversionesRepository.inversionesList();}

    @GetMapping("/listarInversiones")
    public ResponseEntity<Inversiones> listarPrestamos() throws noInversion{
        idUsuario = inversionesService.obtenerId();
        Optional<Inversiones> optionalPrestamo = inversionesService.getListaInversion(idUsuario);
        if(optionalPrestamo.isEmpty()){
            throw new noInversion();
        }
        return ResponseEntity.ok(optionalPrestamo.get());
    }



}
