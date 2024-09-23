/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author User
 */
public class AverageSensor implements Sensor{
    private ArrayList<Sensor> sensors;
    private List<Integer> readings;
    
    public AverageSensor(){
        this.sensors = new ArrayList<>();
        this.readings = new ArrayList<>();
    }
    
    public void addSensor(Sensor toAdd){
        this.sensors.add(toAdd);
    }
    
    public boolean isOn(){
        if(this.sensors.stream().anyMatch(sensor -> sensor.isOn())){
            return true;
        }
        
        return false;
    }
    
    public void setOn(){
        this.sensors.stream().forEach(sensor -> sensor.setOn());
    }
    
    public void setOff(){
        this.sensors.stream().forEach(sensor -> sensor.setOff());
    }
    
    public int read(){
        if (!this.isOn() || this.sensors.isEmpty()){
            throw new IllegalStateException("The sensor must be on or it should have at least one sensor added");
        }
        
        int average = this.sensors.stream()
                .mapToInt(Sensor::read)
                .sum() / this.sensors.size();
        
        this.readings.add(average);
        return average;
    }
    
    public List<Integer> readings(){
        return this.readings;
    }
}
