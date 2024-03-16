
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class Abbreviations {
    private HashMap<String, String> abbreviations;
    
    public Abbreviations(){
        this.abbreviations = new HashMap<>();
    }
    
    public void addAbbreviation(String abbreviation, String explantion){
        this.abbreviations.put(abbreviation, explantion);
    }
    
    public boolean hasAbbreviation(String abbreviation){
        if(this.abbreviations.containsKey(abbreviation)){
            return true;
        }
        return false;
    }
    
    public String findExplanationFor(String abbreviation){
        if(!this.abbreviations.containsKey(abbreviation)){
            return null;
        }
        return this.abbreviations.get(abbreviation);
    }
}
