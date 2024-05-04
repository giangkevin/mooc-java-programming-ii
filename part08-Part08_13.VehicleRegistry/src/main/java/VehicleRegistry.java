
import java.util.ArrayList;
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
public class VehicleRegistry {
    private HashMap<LicensePlate, String> vH;
    
    public VehicleRegistry(){
        this.vH = new HashMap<>();
    }
    
    public boolean add(LicensePlate licensePlate, String owner){
        if(!this.vH.containsKey(licensePlate)){
            this.vH.put(licensePlate, owner);
            return true;
        }
        return false;
    }
    
    public String get(LicensePlate licensePlate){
        return this.vH.getOrDefault(licensePlate, null);
    }
    
    public boolean remove(LicensePlate licensePlate){
        if(this.vH.containsKey(licensePlate)){
            this.vH.remove(licensePlate);
            return true;
        }
        return false;
    }
    
    public void printLicensePlates(){
        for(LicensePlate lP : this.vH.keySet()){
            System.out.println(lP);
        }
    }
    
    public void printOwners(){
        ArrayList<String> owners = new ArrayList<>();
        
        for(String owner : this.vH.values()){
            if(owners.contains(owner)){
                continue;
            }
            owners.add(owner);
            System.out.println(owner);
        }
        
    }
}
