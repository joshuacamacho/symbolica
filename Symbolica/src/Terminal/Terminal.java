/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Terminal;

// Import
import java.util.Scanner;

import Calculus.Differential.*;
import Calculus.Integral.*;

import java.util.HashMap;

/**
 *
 * @author Alec
 */
public class Terminal {
    
    boolean alive;
    HashMap<String,String> functions;
    
    public Terminal(){
        
        print();
        functions = new HashMap();
        alive = true;
        
    }
    
    public void set_alive(boolean value){
        
        alive = value;
        
    }
    
    public boolean get_alive(){
        
        return alive;
        
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
                clear();
                break;
                
            case "exit":
                 set_alive(false);
                 break;

        }
        
        return null;
        
    }
 
    public void define(String input){
        String name = clean(get_name(input));
        String function = clean(get_function(input));
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
    
    public void clear(){
        
        System.out.println("\n \n \n \n \n \n \n \n \n \n \n \n \n");
        print();
        System.out.println("\n \n \n \n \n \n \n \n \n \n \n \n \n");
        
    }
    
    public void print(){
        
       System.out.println("------------------Symbolica Terminal------------------");
        
    }
    
}
