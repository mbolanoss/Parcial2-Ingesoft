/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author user
 */
@Entity
@Table(name = "tiposensores")
public class TipoSensor implements Serializable {
    
    private String nombre;
    private double minimoPermitido;
    private double maximoPermitido;
    private boolean promedio;
    private int numeroHoras;
    private String tipo;
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public TipoSensor() {
    }

    public TipoSensor(String nombre, double minimoPermitido, double maximoPermitido, boolean promedio, int numeroHoras, String tipo, int id) {
        this.nombre = nombre;
        this.minimoPermitido = minimoPermitido;
        this.maximoPermitido = maximoPermitido;
        this.promedio = promedio;
        this.numeroHoras = numeroHoras;
        this.tipo = tipo;
        this.id = id;
    }

  
    

    

    public int getNumeroHoras() {
        return numeroHoras;
    }

    public void setNumeroHoras(int numeroHoras) {
        this.numeroHoras = numeroHoras;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getMinimoPermitido() {
        return minimoPermitido;
    }

    public void setMinimoPermitido(double minimoPermitido) {
        this.minimoPermitido = minimoPermitido;
    }

    public double getMaximoPermitido() {
        return maximoPermitido;
    }

    public void setMaximoPermitido(double maximoPermitido) {
        this.maximoPermitido = maximoPermitido;
    }

    public boolean isPromedio() {
        return promedio;
    }

    public void setPromedio(boolean promedio) {
        this.promedio = promedio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
