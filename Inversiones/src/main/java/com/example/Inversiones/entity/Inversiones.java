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
    private Integer plazodias;
    private int cuentadebito;
    private Double Tasa;

    public Inversiones(){
    }

    public Inversiones(Integer id, Integer idUsuario, Integer idCuenta, Double monto, Integer plazodias, int cuentadebito, Double tasa){
        this.id = id;
        this.idCuenta = idCuenta;
        this.idUsuario = idUsuario;
        this.cuentadebito = cuentadebito;
        this.monto = monto;
        this.Tasa = tasa;
        this.plazodias = plazodias;
    }

    public int getCuentadebito() {
        return cuentadebito;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Integer idCuenta) {
        this.idCuenta = idCuenta;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public void setPlazodias(Integer plazodias) {
        this.plazodias = plazodias;
    }

    public void setTasa(Double tasa) {
        Tasa = tasa;
    }

    public Double getMonto() {
        return monto;
    }

    public int getPlazodias() {
        return plazodias;
    }


    public void setCuentadebito(int cuentadebito) {
        this.cuentadebito = cuentadebito;
    }


    public void setPlazodias(int plazodias) {
        this.plazodias = plazodias;
    }

    public Double getTasa() {
        return Tasa;
    }
}
