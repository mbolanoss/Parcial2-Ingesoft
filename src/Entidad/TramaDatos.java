/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author user
 */
public class TramaDatos {
    private int idSensor;
    private double valorTomado;
    private Date fecha;
    private Calendar hora;

    public TramaDatos(int idSensor, double valorTomado, Date fecha, Calendar hora) {
        this.idSensor = idSensor;
        this.valorTomado = valorTomado;
        this.fecha = fecha;
        this.hora = hora;
    }

    public Calendar getHora() {
        return hora;
    }

    public void setHora(Calendar hora) {
        this.hora = hora;
    }

    public int getIdSensor() {
        return idSensor;
    }

    public void setIdSensor(int idSensor) {
        this.idSensor = idSensor;
    }

    public double getValorTomado() {
        return valorTomado;
    }

    public void setValorTomado(double valorTomado) {
        this.valorTomado = valorTomado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
}
