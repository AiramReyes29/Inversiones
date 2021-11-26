package com.example.Inversiones.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;


@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "Inversiones")
public class Inversiones {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer idUsuario;
    private Integer idCuenta;
    private Double monto;
    private Integer plazoDias;
    private int cuentaDebito;
    private Double tasa;

    public Inversiones() {
    }

    public Inversiones(Integer id, Integer idUsuario, Integer idCuenta, Double monto, Integer plazoDias, int cuentaDebito, Double tasa) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.idCuenta = idCuenta;
        this.monto = monto;
        this.plazoDias = plazoDias;
        this.cuentaDebito = cuentaDebito;
        this.tasa = tasa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Integer idCuenta) {
        this.idCuenta = idCuenta;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public Integer getPlazoDias() {
        return plazoDias;
    }

    public void setPlazoDias(Integer plazoDias) {
        this.plazoDias = plazoDias;
    }

    public int getCuentaDebito() {
        return cuentaDebito;
    }

    public void setCuentaDebito(int cuentaDebito) {
        this.cuentaDebito = cuentaDebito;
    }

    public Double getTasa() {
        return tasa;
    }

    public void setTasa(Double tasa) {
        this.tasa = tasa;
    }
}