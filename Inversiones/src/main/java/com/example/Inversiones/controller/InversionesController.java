package com.example.Inversiones.controller;

import com.example.Inversiones.entity.Inversiones;
import com.example.Inversiones.repository.InversionesRepository;
import com.example.Inversiones.repository.InversionesRepositoryDAO;
import com.example.Inversiones.service.InversionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apiInversiones")
public class InversionesController {
    private Integer idUsuario;
    private List<Inversiones> cuentaCliente;
    private  Integer idCuenta;

    @Autowired
    private InversionesService inversionesService;
    @Autowired
    private InversionesRepository inversionesRepository;
    @Autowired
    private InversionesRepositoryDAO inversionesRepositoryDAO;

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

    //@GetMapping("/listarInversiones")
    //public ResponseEntity<Inversiones> listarPrestamos() throws noInversion{
      //  idUsuario = inversionesService.obtenerId();
        //Optional<Inversiones> optionalPrestamo = inversionesService.getListaInversion(idUsuario);
        //if(optionalPrestamo.isEmpty()){
         //   throw new noInversion();
      //  }
        //return ResponseEntity.ok(optionalPrestamo.get());
    //}

    @GetMapping("/cuentaByIdUsuario/{idUsuario}")
    public List<Inversiones> cuentaByIdUsuario(@PathVariable("idUsuario")Integer idUsuario) throws noCuenta {
        cuentaCliente=inversionesRepositoryDAO.findByIdUsuario(idUsuario);
        if (cuentaCliente.isEmpty()){
            throw new noCuenta();
        }
        return inversionesRepositoryDAO.findByIdUsuario(idUsuario);
    }

    @PostMapping("/crear")
    public ResponseEntity<String> crearNuevaCuenta(@RequestBody Inversiones inversiones) {
        if (inversionesService.crearNuevaInversion(inversiones)) {
            return new ResponseEntity<>("Transaccion Finalizada", HttpStatus.OK);
        }
        return new ResponseEntity<>("Transaccion Fallida", HttpStatus.BAD_REQUEST);
    }



}
