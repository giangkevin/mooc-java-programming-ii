
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
public class OneItemBox extends Box{
    private Item item;
    
    public OneItemBox(){
    }
    
    public void add (Item item){
        if (this.item != null){
            return;
        }
        
        this.item = item;
    }
    
    public boolean isInBox(Item item){
        return this.item != null && this.item.equals(item);
    }
}
