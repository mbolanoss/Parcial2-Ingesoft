/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author user
 */
@Entity
@Table(name = "historicosdatos")
public class HistoricoDatos implements Serializable {
    
    @ManyToOne
    private Sensor sensor;
    private double valorTomado;
    private String fecha;
    private String hora;
    private String procesamiento;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public HistoricoDatos() {
    }

    public HistoricoDatos(int id, Sensor sensor, double valorTomado, String fecha, String hora, String procesamiento) {
        this.id = id;
        this.sensor = sensor;
        this.valorTomado = valorTomado;
        this.fecha = fecha;
        this.hora = hora;
        this.procesamiento = procesamiento;
    }

    public String getProcesamiento() {
        return procesamiento;
    }

    public void setProcesamiento(String procesamiento) {
        this.procesamiento = procesamiento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public double getValorTomado() {
        return valorTomado;
    }

    public void setValorTomado(double valorTomado) {
        this.valorTomado = valorTomado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    
    
}
