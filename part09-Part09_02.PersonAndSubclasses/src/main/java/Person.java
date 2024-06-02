/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class Person {
    private String fullName;
    private String adress;
    
    public Person(String fullName, String adress){
        this.fullName = fullName;
        this.adress = adress;
    }
    
    public String toString(){
        return this.fullName + "\n  " + this.adress;
    }
}
