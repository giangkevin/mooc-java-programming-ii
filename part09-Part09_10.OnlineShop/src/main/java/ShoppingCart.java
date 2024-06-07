
import java.util.HashMap;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class ShoppingCart {
    private Map<String, Item> map;
    
    public ShoppingCart(){
        this.map = new HashMap<>();
    }
    
    public void add(String product, int price){
        this.map.putIfAbsent(product, new Item(product, 0, price));
        this.map.get(product).increaseQuantity();
    }
    
    public int price(){
        int total = 0;
            
        for (Item items : this.map.values()){
            total += items.price();
        }
        
        return total;
    }
    
    public void print(){
        for(String items : this.map.keySet()){
            System.out.println(this.map.get(items));
        }
    }
}
