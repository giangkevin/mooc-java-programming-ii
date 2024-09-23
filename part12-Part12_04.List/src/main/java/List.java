/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class List<Type>{
    private Type[] values;
    private int firstFreeIndex;
    
    public List(){
        this.values = (Type[]) new Object[10];
        this.firstFreeIndex = 0;
    }
    
    private void grow(){
        int newSize = this.firstFreeIndex + this.firstFreeIndex / 2;
        Type[] newValues = (Type[]) new Object[newSize];
        for(int i = 0; i < this.values.length; i++){
            this.values[i] = newValues[i];
        }
        this.values = newValues;
    }
    
    public void add(Type value){
        if (this.firstFreeIndex == this.values.length) {
            grow();
        }
        this.values[firstFreeIndex] = value;
        this.firstFreeIndex++;
    }
    
    public boolean contains(Type value){
        return indexOfValue(value) >= 0;
    }
    
    public int indexOfValue(Type value){
        for(int i = 0; i < this.firstFreeIndex; i++){
            if(this.values[i].equals(value)){
                return i;
            }
        }
        return -1;
    }
    
    private void moveToTheLeft(int fromIndex){
        for(int i = 0; i < this.firstFreeIndex - 1; i++){
            this.values[i] = this.values[i+1];
        }
    }
    
    public void remove(Type value){
        int indexOfValue = indexOfValue(value);
        
        if(indexOfValue < 0){
            return;
        }
        
        moveToTheLeft(indexOfValue);
        this.firstFreeIndex--;
    }
    
    public Type value(int index){
        if(index < 0 || index > this.firstFreeIndex){
            throw new ArrayIndexOutOfBoundsException("Index " + index + "outside of [0, " + this.firstFreeIndex + "]");
        }
        return this.values[index];
    }
    
    public int size(){
        return this.firstFreeIndex;
    }
}
