
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class Herd implements Movable{
    private List<Movable> list;
    
    public Herd(){
        this.list = new ArrayList<>();
    }
    
    public String toString(){
        String string = "";
        for(Movable movable : this.list){
            string = string + movable.toString() + "\n";
        }
        return string;
    }
    
    public void addToHerd(Movable movable){
        this.list.add(movable);
    }
    
    public void move(int dx, int dy){
        for(Movable movable : this.list){
            movable.move(dx, dy);
        }
    }    
}
