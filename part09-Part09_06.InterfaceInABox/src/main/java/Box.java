
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
public class Box implements Packable{
    private ArrayList<Packable> packable;
    private double maximumWeight;
    
    public Box(double maximumWeight){
        this.packable = new ArrayList<>();
        this.maximumWeight = maximumWeight;
    }
    
    public void add(Packable packable){
        if(packable.weight() + weight() <= this.maximumWeight){
            this.packable.add(packable);
        }
    }
    
    public double weight(){
        double weight = 0 ;
        
        for(int i = 0; i < this.packable.size(); i++){
            weight += this.packable.get(i).weight();
        }
        
        return weight;
    }
    
    public String toString(){
        return "Box: " + this.packable.size() + " items, total weight " + weight() + " kg";
    }
}
