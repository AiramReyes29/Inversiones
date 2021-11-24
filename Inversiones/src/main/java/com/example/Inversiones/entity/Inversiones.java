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
    private int monto;
    private int plazodias;
    private int cuentadebito;
    private int Tasa;

    public Inversiones(){
    }

    public Inversiones(int monto, int plazodias, int cuentadebito, int tasa){
        this.cuentadebito = cuentadebito;
        this.monto = monto;
        this.Tasa = tasa;
        this.plazodias = plazodias;
    }

    public int getCuentadebito() {
        return cuentadebito;
    }

    public int getMonto() {
        return monto;
    }

    public int getPlazodias() {
        return plazodias;
    }

    public int getTasa() {
        return Tasa;
    }

    public void setCuentadebito(int cuentadebito) {
        this.cuentadebito = cuentadebito;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public void setPlazodias(int plazodias) {
        this.plazodias = plazodias;
    }

    public void setTasa(int tasa) {
        Tasa = tasa;
    }
}
