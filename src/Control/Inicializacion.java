/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DAO.HistoricoDatosDAO;
import DAO.SensorDAO;
import DAO.TipoSensorDAO;
import Entidad.HistoricoDatos;
import Entidad.Sensor;
import Entidad.TipoSensor;

/**
 *
 * @author user
 */
public class Inicializacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        TipoSensor tipo = new TipoSensor("Microfono", 0, 1, false, 2, "MIC",0);
        Sensor sensor = new Sensor("Habitación", tipo, 0);
        //HistoricoDatos historicoDatos = new HistoricoDatos(0, sensor, 2, "24/11/2020", "16:24:30", "Normal");
        
        TipoSensorDAO tipoDAO = new TipoSensorDAO();
        SensorDAO sensorDAO = new SensorDAO();
        
        
        tipoDAO.crear(tipo);
        sensorDAO.crear(sensor);
        
    }
    
}
