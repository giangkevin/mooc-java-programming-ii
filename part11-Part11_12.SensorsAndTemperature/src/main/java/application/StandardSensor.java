/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

/**
 *
 * @author User
 */
public class StandardSensor implements Sensor{
    private int temperature;
    
    public StandardSensor(int temperature){
        this.temperature = temperature;
    }
    
    public void setOn(){
        
    }
    
    public void setOff(){
        
    }
    
    public boolean isOn(){
        return true;
    }
    
    public int read(){
        return this.temperature;
    }
}
