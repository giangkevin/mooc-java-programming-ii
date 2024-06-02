/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class Student extends Person{
    private int credits;
    
    public Student(String fullName, String adress){
        super(fullName, adress);
        this.credits = 0;
    }
    public int credits(){
        return this.credits;
    }
    public void study(){
        this.credits += 1;
    }
    
    public String toString(){
        return super.toString() + "\n  Study credits " + this.credits();
    }
}
