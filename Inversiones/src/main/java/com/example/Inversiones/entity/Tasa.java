package com.example.Inversiones.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import javax.persistence.*;

@Entity
@Table(name = "tasas")
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Tasa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private double tasa;

    public Tasa(double tasa){
        this.tasa = tasa;
    }
}
