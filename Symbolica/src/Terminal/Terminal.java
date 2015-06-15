/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Terminal;

// Import
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import Calculus.Differential.*;
import Calculus.Integral.*;
import Linear_Algebra.*;
import java.util.HashMap;
import java.util.ArrayList;

/**
 *
 * @author Alec
 */
public class Terminal {
    
    private boolean alive;
    private HashMap<String,String> functions;
    private HashMap<String,String> vector_functions;
    private HashMap<String,String> matrices;
    ArrayList<String> history;
    private int history_index;
    
    public Terminal(){
        
        functions = new HashMap();
        history = new ArrayList();
        history_index = 0;
        alive = true;
        
    }
    
    public void set_alive(boolean value){
        
        alive = value;
        
    }
    
    public boolean get_alive(){
        
        return alive;
        
    }
    
    public void set_history_index(int history_index){
        
        this.history_index = history_index;
        
    }
    
    public int get_history_index(){
        
        return history_index;
        
    }
    
    public String get_history_item(int offset){
        
        if(history.size()-1 - offset >=0 && !history.isEmpty()){
            return history.get((history.size()-1) - offset);
        }
        else{
                return "$";
        }
        
    }
    
    public String input(String input){
        
        String command = get_command(input);
        
        switch(command){

            case "define":
                define(input);
                break;
            
            case "differentiate": 
                 return differentiate(input);

            case "integrate":
                 return integrate(input);
                    
            case "print":
                return ("    " + functions.toString());
             
            case "clear":
                return clear();
                
            case "exit":
                 set_alive(false);
                 break;
                
            default:
                return "    Invalid command";

        }
        
        return null;
        
    }
 
    public void define(String input){
        
        String name = clean(get_name(input));
        String function = clean(get_function(input));
        if(function.charAt(0) == '['){
            make_matrix(function);
        }
            
        if(function.charAt(0) == '<')
            System.out.println("Vector Function");
        functions.put(name,function);
        
    }
    
    public String differentiate(String input){
        
        String name = get_name(input);
        if(functions.containsKey(name)){
            Parse_Tree derivative = new Parse_Tree(functions.get(name));
            return ("    " + derivative.f_prime.f_prime);
        }
        
        return null;
        
    }
    
    public String integrate(String input){
        
        String name = get_name(input);
        
        if(functions.containsKey(name)){
            Integral integral = new Integral();
            integral.eval(functions.get(name));
            return ("    " + integral.get_antiderivative());
        }
        
        return null;
        
    }
    
    public String get_command(String input_line){
        
        String command = "";
        for(int i = 0; i < input_line.length() && input_line.charAt(i) != ' ';i++){
            command += input_line.charAt(i);
        }
        
        return command;
        
    }
    
    public String get_name(String input_line){
        
        String token = "";
        int index = 0;
        
        while(input_line.charAt(index) != ' '){
            index ++;
        }
        for(int j = index + 1; j < input_line.length() && 
                                  input_line.charAt(j) != ' '; j++){
            token += input_line.charAt(j);
        }
        
        return token;
        
    }
    
    public String get_function(String input_line){
        
        String function = "";
        int count = 0;
        
        while(input_line.charAt(count) != '='){
            count++;
        }
        for(int i = count + 1; i < input_line.length() ; i++){
            function += input_line.charAt(i);
        }
        
        return function;
        
    }
    
    public Matrix make_matrix(String input_line){
        
        Matrix a;
        int rows = 0;
        int columns = 0;
        Queue<String> entries = new LinkedList<>();
        String entry = "";
        
        // Determine the number of columns in the matrix
        input_line = input_line.substring(1,input_line.length()-1);
        for(int i = 0; input_line.charAt(i) != ';'; i++){
            if(input_line.charAt(i) == ',')
                columns++;
        }
        columns++;
        
        // Determine the number of rows and the entries in each slot
        for(int i = 0; i < input_line.length(); i++){
            if(input_line.charAt(i) == ';')
                rows++;
            if(input_line.charAt(i) != ',' && input_line.charAt(i) != ';'){
                entry += input_line.charAt(i);
            }
            else{
                entries.add(clean(entry));
                entry = "";
            }
        }
        
        // Create and fill a new matrix
        a = new Matrix(rows,columns);
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                String element = entries.remove();
                a.set_element(Float.parseFloat(element),i,j);
            }
        }
        
        a.print();
        
        return a;
        
    }
    
    public boolean end_session(){
        
        return get_alive() == false;
        
    }
    
    public String clean(String original){
        
        String modified = "";
        int start = 0;
        int end = original.length()-1;
        
        while(original.charAt(start) == ' '){
            start++;
        }
        while(original.charAt(end) == ' '){
            end--;
        }
        
        for(int i = start; i <= end; i++){
            modified += original.charAt(i);
        }
        
        return modified;
        
    }
    
    public String clear(){
        
        return "clear";
        
    }
    
    public void print(){
        
       System.out.println("------------------Symbolica Terminal------------------");
        
    }
    
}
