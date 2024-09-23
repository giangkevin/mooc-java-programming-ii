
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
public class Hideout<T> {
    private T hide;
    

    
    public void putIntoHideout(T toHide){
        this.hide = toHide;
    }
    
    public T takeFromHideout(){
        T t = this.hide;
        this.hide = null;
        return t;
    }
    
    public boolean isInHideout(){
        return this.hide != null;
    }
}
