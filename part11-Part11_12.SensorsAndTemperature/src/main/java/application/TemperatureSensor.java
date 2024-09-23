/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.Random;

/**
 *
 * @author User
 */
public class TemperatureSensor implements Sensor{
    private boolean status;
    
    public TemperatureSensor(){
        this.status = false;
    }
    
    public boolean isOn(){
        if(this.status){
            return true;
        }else{
            return false;
        }
    }
    
    public void setOn(){
        this.status = true;
    }
    
    public void setOff(){
        this.status = false;
    }
    
    public int read(){
        int randomNumber = 0;
        if(!status){
            throw new IllegalStateException();
        }else if(status){
            randomNumber = new Random().nextInt(61) - 30;
        }
        
        return randomNumber;
    }
}
