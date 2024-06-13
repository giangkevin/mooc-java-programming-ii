
import java.util.ArrayList;
import java.util.Collections;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class Hand implements Comparable<Hand>{
    private ArrayList<Card> cards;
    
    public Hand(){
        this.cards = new ArrayList<>();
    }
    
    public void add(Card card){
        this.cards.add(card);
    }
    
    public void print(){
        this.cards.stream().forEach(c -> System.out.println(c));
    }
    
    public void sort(){
        Collections.sort(cards);
    }
    
    public int compareTo(Hand another){
        int sum = this.cards.stream()
                .mapToInt(card ->  card.getValue())
                .sum();
        
        int sumAnother = another.cards.stream()
                .mapToInt(card -> card.getValue())
                .sum();
        
        
        return sum - sumAnother; 

    }
    
    public void sortBySuit(){
        BySuitInValueOrder sortBySuitOrder = new BySuitInValueOrder();
        Collections.sort(cards, sortBySuitOrder);
    }
}
