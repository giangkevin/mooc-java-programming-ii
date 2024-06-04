/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class ProductWarehouseWithHistory extends ProductWarehouse{
    private ChangeHistory changeHistory;
    
    public ProductWarehouseWithHistory(String productName, double capacity, double initialBalance){
        super(productName, capacity);
        this.changeHistory = new ChangeHistory();
        addToWarehouse(initialBalance);
    }
    
    public String history(){
        return this.changeHistory.toString();
    }
    
    public void addToWarehouse(double amount){
        super.addToWarehouse(amount);
        this.changeHistory.add(this.getBalance());
    }
    
    public double takeFromWarehouse(double amount){
        double balance = super.takeFromWarehouse(amount);
        this.changeHistory.add(this.getBalance());
        return balance;
    }
    
    public void printAnalysis(){
        System.out.println("Product: " + super.getName() + 
                "\nHistory: " + this.changeHistory.toString() +
                "\nLargest amount of product: " + this.changeHistory.maxValue() +
                "\nSmallest amount of product: " + this.changeHistory.minValue() + 
                "\nAverage: " + this.changeHistory.average()); 
    }
}
