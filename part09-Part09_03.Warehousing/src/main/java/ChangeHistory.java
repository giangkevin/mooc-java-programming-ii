
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class ChangeHistory {
    private ArrayList<Double> productsWarehouse;
    
    public ChangeHistory(){
        this.productsWarehouse = new ArrayList<>();
    }
    
    public void add(double status){
        this.productsWarehouse.add(status);
    }
    
    public void clear(){
        this.productsWarehouse.clear();
    }
    
    public double maxValue(){
        double returnValue = this.productsWarehouse.get(0);
        
        if(this.productsWarehouse.isEmpty()){
            return 0.0;
        }else{
            for(double value : this.productsWarehouse){
                if(returnValue < value){
                    returnValue = value;
                }
            }
        }
        
        return returnValue;
    }
    
    public double minValue(){
        double returnValue = this.productsWarehouse.get(0);
        
        if(this.productsWarehouse.isEmpty()){
            return 0.0;
        }else{
            for(int i = 0; i < this.productsWarehouse.size(); i++){
                if(returnValue > this.productsWarehouse.get(i)){
                    returnValue = this.productsWarehouse.get(i);
                }
            }
        }
        return returnValue;
    }
    
    public double average(){
        double total = 0.0;
        
        if(!this.productsWarehouse.isEmpty()){
            int i = 0;
            while(i < this.productsWarehouse.size()){
                total += this.productsWarehouse.get(i);
                i++;
            }
            return total / this.productsWarehouse.size();
        }else{
            return 0.0;
        }
    }
    
    
    public String toString(){
        return productsWarehouse.toString();
    }
}
