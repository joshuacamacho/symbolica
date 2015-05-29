/*
 * Name: Alec Farfan
 * Date: 05/15/2015
 * Purpose: Parse Tree Class
 */

// Import libraries
import Tree_Package.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class Parse_Tree extends Binary_Tree<Token>{

    public HashSet<String> elementaries;
    public Derivative f_prime;
    
    public Parse_Tree(String f){
        super(new Token());
        f_prime = new Derivative();
        elementaries = fill_elementaries();
        f_prime.f_prime = fill_tree(f);
        
    }
    
    public HashSet fill_elementaries(){
        
        HashSet<String> elementarie = new HashSet();
        elementarie.add("sin");
        elementarie.add("cos");
        elementarie.add("tan");
        elementarie.add("csc");
        elementarie.add("sec");
        elementarie.add("cot");
        elementarie.add("arcsin");
        elementarie.add("arccos");
        elementarie.add("arctan");
        elementarie.add("ln");
        elementarie.add("log");
        elementarie.add("^");
        
        return elementarie;
        
    }
    
    /**
     * Recursively parses the string passed into the parameter f until the form
     * of the string f is in one of the two base cases
     * @param f
     * @return 
     */
    public String fill_tree(String f){
        
        // Parse the function f(x) and create the Token object for current node
        Token this_node = parse(f);
        
        // Base Case 1: f is a single variable or constant
        if(this_node.get_operand_1() == null&&this_node.get_operator() == null){
            this.set_tree(new Token(f),null,null);
            if(this_node.get_operand_2().equals("x")){
                f_prime.f_prime = f_prime.derive("single","x","x");
            }
            else if(is_constant(this_node.get_operand_2())){
                f_prime.f_prime = f_prime.derive("constant","x","x");
            }
            
        }
        
        // Base Case 2: f is a known function
        else if(this_node.get_operand_1() == null &&
            elementaries.contains(this_node.get_operator())){
            this.set_tree(new Token(f),null,null);
            f_prime.f_prime = f_prime.derive(this_node.get_operator(),
                          f_prime.get_argument(this_node.get_operand_2()), "x");
        }
        
        // Recursive Case: f is a sum, difference, product or quotient of functions
        else if(!(this_node.get_operand_1() == null && this_node.get_operator() == null)){
            
            Parse_Tree left_sub = new Parse_Tree(this_node.get_operand_1());
            Parse_Tree right_sub = new Parse_Tree(this_node.get_operand_2());
            this.set_tree(new Token(f),left_sub,right_sub);
            
            switch(this_node.get_operator()){
                case "+":
                    f_prime.f_prime = enclose(f_prime.sum(left_sub.f_prime.f_prime,
                                      right_sub.f_prime.f_prime));
                    break;
                case "-":
                    f_prime.f_prime = enclose(f_prime.difference(
                           left_sub.f_prime.f_prime,right_sub.f_prime.f_prime));
                    break;
                case "*":
                    f_prime.f_prime = enclose(f_prime.product(
                                      left_sub.f_prime.f_prime,
                                      left_sub.get_root_data().get_original(),
                                      right_sub.f_prime.f_prime,
                                      right_sub.get_root_data().get_original()));
                    break;
                case "/":
                    f_prime.f_prime = enclose(f_prime.quotient(
                                      left_sub.get_root_data().get_original(),
                                      left_sub.f_prime.f_prime,
                                      right_sub.get_root_data().get_original(),
                                      right_sub.f_prime.f_prime));
                    
                    break;
            }
            
        }
        
        //f_prime.f_prime = simplify(f_prime.f_prime);
        //f_prime.f_prime = clean(f_prime.f_prime);
        return f_prime.f_prime;
    
    }
    /**
     * Takes a string of a function and finds the innermost operator or function
     * and creates an array of size 3 with the left and right operand as well as 
     * the binary operator or a function with its argument and a null element.
     * @param f String representing a mathematical function
     * @return Array containing operands and operator or an argument and function
     */
    public Token parse(String f){
        
        f = clean(f);
        Token parsed_string;
        
        parsed_string = arithmetic_operator(f);
        if(parsed_string == null){
            parsed_string = single_operand(f);
            if(parsed_string == null){
                parsed_string = single_function(f);
            }  
        }
        
        return parsed_string;
    
    }
    
    /**
     * 
     * @param f
     * @return 
     */
    public String clean(String f){
        
        String cleaned_string = f;
        
        if(f != null){
            HashMap<Integer,Integer> parentheses = get_parentheses(f);
            while(cleaned_string.charAt(0) == '(' && parentheses.size() > 0 &&
              cleaned_string.charAt(cleaned_string.length()-1) == ')'){
                if(parentheses.get(0) == cleaned_string.length()-1){
                    cleaned_string = cleaned_string.substring(1,
                                 cleaned_string.length()-1);
                }
                else{
                    break;
                }
            }
            while(cleaned_string.charAt(0) == ' '){
                cleaned_string = cleaned_string.substring(1,
                                 cleaned_string.length());
            }
            while(cleaned_string.charAt(cleaned_string.length()-1) == ' '){
                cleaned_string = cleaned_string.substring(0,
                                 cleaned_string.length()-1);
            }
        }
        
        return cleaned_string;
        
    }
    
    /**
     * 
     * @param f
     * @return 
     */
    public String simplify(String f){
        
        if(f.length() > 1){
             for(int i = 0; i < f.length() ; i++ ){
                if(f.charAt(i) == '0'){
                    int index = i+1;
                    while(!(f.charAt(index)==')' || f.charAt(index)=='+' ||
                                                  f.charAt(index)=='-') ||
                                                  is_constant("" + f.charAt(index))){
                        index++;
                    }
                    String a = f.substring(0,i);
                    String b = f.substring(index+1,f.length());
                    f = a + b;
                }
                if(f.length() > i + 1){
                    if(f.charAt(i) == '1' && f.charAt(i+1) == '('){
                    int index = i+1;
//                    while(f.charAt(index) != ')'){
//                        index++;
//                    }
                    String a = f.substring(0,i);
                    String b = f.substring(i + 1,f.length());
                    f = a + b;
                    }
                } 
            }   
        }
         
        return f;
        
    }
    
    /**
     * Finds all ordered pairs representing the indeces of an opening parentheses
     * and its corresponding closing parentheses.
     * @param f The string representing the function f(x)
     * @return A HashMap<Integer,Integer> of the indeces of parentheses pairs
     */
    public HashMap get_parentheses(String f){
        
        HashMap<Integer,Integer> parentheses = new HashMap();
        
        if(f != null && num_parentheses(f) % 2 == 0){
            for(int i=0;i<f.length()-1;i++){
                if(f.charAt(i)=='('){
                    int j = i + 1;
                    int count = 1;
                    while(count!=0){
                        if(f.charAt(j)=='('){
                            count++;
                        }
                        if(f.charAt(j)==')'){
                            count--;
                        }
                        j++;
                    }
                    parentheses.put(i,j-1);
                }
            }
        }
        
        return parentheses;
        
    }
    
    /**
     * 
     * @param f
     * @return 
     */
    public static int num_parentheses(String f){
        
        int count = 0;
        for(int i=0;i<f.length();i++){
            if(f.charAt(i) == '(' || f.charAt(i) == ')')
                count++;
        }
        
        return count;
        
    }
    
    /**
     * 
     * @param f
     * @return 
     */
    public Token arithmetic_operator(String f){
        f = clean(f);
        Token parsed_string = new Token();
        HashMap<Integer,Integer> parentheses = get_parentheses(f);
        
        if(f.contains("+") || f.contains("-")|| f.contains("/")){
            for(int i=0;i<f.length();i++){
                boolean check = true;
                for(Map.Entry<Integer,Integer> entry : parentheses.entrySet()){
                    if(i>entry.getKey()&&i<entry.getValue()){
                        check = false;
                    }
                }
                if(check){
                    if(f.charAt(i) == '+'){
                        parsed_string.set_operand_1(f.substring(0,i));
                        parsed_string.set_operand_2(f.substring(i+1,f.length()));
                        parsed_string.set_operator("+");
                        return parsed_string;
                    }
                    if(f.charAt(i) == '-'){
                        parsed_string.set_operand_1(f.substring(0,i));
                        parsed_string.set_operand_2(f.substring(i+1,f.length()));
                        parsed_string.set_operator("-");
                        return parsed_string;
                    }
                    if(f.charAt(i) == '/'){
                        parsed_string.set_operand_1(f.substring(0,i));
                        parsed_string.set_operand_2(f.substring(i+1,f.length()));
                        parsed_string.set_operator("/");
                        return parsed_string;
                    }
                }

            }    
        }
        if(f.length()>1){
            if(Character.isDigit(f.charAt(0))&&f.charAt(1)!='^' ||
               (f.charAt(0) == 'x' && f.charAt(1) == '^')){
                int i = 0;
                while(Character.isDigit(f.charAt(i))){
                    i++;
                }
                parsed_string.set_operand_1(f.substring(0,i));
                parsed_string.set_operand_2(f.substring(i,f.length()));
                parsed_string.set_operator("*");
            
                return parsed_string;
            }
        }
          
        for(int i=0;i<f.length()-1;i++){
            if(f.charAt(i)==')' && f.charAt(i+1)=='(' ||
               f.charAt(i) == ')' && f.charAt(i+1) != ')'){
                parsed_string.set_operand_1(f.substring(0,i+1));
                parsed_string.set_operand_2(f.substring(i+1,f.length()));
                parsed_string.set_operator("*");
                return parsed_string;    
            }
        }
        
        return null;
        
    }
    
    /**
     * Checks to see if a given function has been reduced to a single term.
     * The single term may be either a constant or an isolated variable. If the
     * function is a single term, a new Token object is created and returned.
     * @param f The function f(x)
     * @return  A new Token object with operand_1 and operator set to null, and
     *          operand_2 set to the string f
     */
    public Token single_operand(String f){
       
        // Create new Token object to potentially be passed back
        Token parsed_string = new Token();  
        
        // Assume the function is a constant, If a non-digit is found then we
        // can conclude our supposition was false, and the function is not const
        boolean is_constant = true;
        for(int i=0;i<f.length();i++){
            if(!Character.isDigit(f.charAt(i))){
                is_constant = false;
            }
        }
        
        // If the function is constant or a single variable, set the Token
        // object's data members to the proper values and return it
        if(is_constant || f.equals("x")){
            parsed_string.set_operand_1(null);
            parsed_string.set_operand_2(f);
            parsed_string.set_operator(null);
            return parsed_string;
        }  
    
        // If function is not constant nor is it a single variable, return null
        return null;
 
    }
    
    /**
     * Checks to see if a given function is an elementary function that has been
     * isolated. If so a new Token is created with operand_1 set to null,
     * operand_2 set to the String f, and operator set to the given function
     * with no arguments
     * @param f The function f(x) to examine
     * @return A new Token object if a single function, null otherwise
     */
    public Token single_function(String f){
        
        // Declare a new Token object and a string to hold the substrings of f
        Token parsed_string = new Token();
        String sub_function = "";
        
        // Run through the string while creating substrings and checking them
        // against the HashSet of elementary functions
        for(int i=0;i<f.length();i++){
            sub_function += f.charAt(i); // Concatinate character to substring
            
            if(elementaries.contains(sub_function)){ // Check substring against
                parsed_string.set_operand_1(null);   // the hash table
                int j = i+2;
                
                while(f.charAt(j) != ')'){
                    j++;
                }
                
                parsed_string.set_operand_2(f); // If found set the data members
                parsed_string.set_operator(sub_function); // of the Token object
                return parsed_string;                     // and return it.
            }
            
        }
            
        // If the function is not a known base function return null
        return null;
        
    }
    
    /**
     * Determines whether a given function is a constant function
     * @param f The function f(x)
     * @return True if the function is constant, false otherwise
     */
    public boolean is_constant(String f){
        
        // Check to see if there are any non-digits in the string, if so the 
        // function is not constant
        for(int i = 0;i < f.length(); i++){
            if(!Character.isDigit(f.charAt(i))){
                return false;
            }
        }
        
        return true;
        
    }
    
    /**
     * Encloses a given function in a set of parentheses
     * @param f The function f(x)
     * @return  The original string with parentheses added to the beginning and
     *          to the end.
     */
    public String enclose(String f){
        
        return "(" + f + ")";
        
    }
    
    /**
     * Prints the nodes of the tree in the order determined by the iterator 
     * passed into the parameter order. The iterator my contain a traversal
     * in preorder, postorder, inorder, or level order
     * @param order 
     */
    @Override
    public void print(Iterator<Token> order){
        
        Iterator<Token> pointer = order;
        while(pointer.hasNext()){
            Token output = pointer.next();
            System.out.println(output.get_original());
        }
        
    }
    
}
