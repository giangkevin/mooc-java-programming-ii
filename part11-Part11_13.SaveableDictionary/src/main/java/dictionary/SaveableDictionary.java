/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;


/**
 *
 * @author User
 */
public class SaveableDictionary {
    private HashMap<String, String> dictionary;
    private String file;
    
    public SaveableDictionary(){
        this.dictionary = new HashMap<>();
    }
    
    public SaveableDictionary(String file){
        this.dictionary = new HashMap<>();
        this.file = file;
    }
    
    public boolean load(){
        try{
            Files.lines(Paths.get(this.file))
                    .map(row -> row.split(":"))
                    .forEach(parts -> {
                        this.dictionary.put(parts[0], parts[1]);
                        this.dictionary.put(parts[1], parts[0]);
                    });
            return true;
        }catch(IOException e){
            e.printStackTrace();
        }
        
        
        return false;
    }
    
    public void add(String word, String translation){
        this.dictionary.putIfAbsent(word, translation);
        this.dictionary.putIfAbsent(translation, word);
    }
    
    public String translate(String word){
        return this.dictionary.getOrDefault(word, null);
    }
    
    public void delete(String word){
        this.dictionary.remove(translate(word));
        this.dictionary.remove(word);
    }
    
    public boolean save(){
        try(PrintWriter writer = new PrintWriter(new FileWriter(this.file))){
            ArrayList<String> alreadyAdded = new ArrayList<>();
            this.dictionary.keySet().stream()
                    .forEach(line -> {
                        if (alreadyAdded.contains(line)){
                            return;
                        }
                        alreadyAdded.add(line);
                        alreadyAdded.add(this.dictionary.get(line));
                        writer.println(line + ":" + this.dictionary.get(line));
                    });
            writer.close();
            return true;
        }catch(IOException e){
            return false;
        }
        

    }
}
