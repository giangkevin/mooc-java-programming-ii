
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
public class BoxWithMaxWeight extends Box{
    private int capacity;
    private ArrayList<Item> items;
    
    public BoxWithMaxWeight(int capacity){
        this.capacity = capacity;
        this.items = new ArrayList<>();
    }
    
    public void add(Item item){
        if (item.getWeight() + totalWeight() <= this.capacity){
            this.items.add(item);
        }
    }
    
    public boolean isInBox(Item item){
        return this.items.contains(item);
    }
    
    public int totalWeight(){
        int total = 0;
        
        for (Item items : this.items){
            total += items.getWeight();
        }
       
        return total;
    }
}
