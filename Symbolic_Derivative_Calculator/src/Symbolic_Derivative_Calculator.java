/*
 * Name: Alec Farfan
 * Date: 05/04/2015
 * Purpose: Project I Symbolic Derivative Calculator
 */

// Import libraries
import java.util.Scanner;

public class Symbolic_Derivative_Calculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Declare a scanner to recieve input from standard input
        Scanner in_scan = new Scanner(System.in);
        int choice;
        
        // Display and allow selection of menu choices for as long as the user
        // puts in a valid choice.
        do{
            // Display menu choices
            System.out.println("----------Symbolic Derivative Calculator----------");
            System.out.println("|                                                 |");
            System.out.println("|               0. exit                           |");
            System.out.println("|               1. Start                          |");
            System.out.println("|               2. Syntax Rules                   |");
            System.out.println("|                                                 |");
            System.out.println("|                                                 |");
            System.out.print("| ENTER: ");
            choice = in_scan.nextInt();
            
            // Execute the corresponding module
            switch(choice){
                
                case 0:       // Quit and exit the program
                    break;
                    
                case 1:       // Run the Symbolic Derivative Calculator
                    run();
                    break;
                 
                case 2:       // Show syntax instructions
                    instructions();
                    break;
                
                default:      //  Notify user has made an invalid choice 
                    System.out.println("Invalid Selection. Choose again");
            
            }
            
        }while(choice != 0);
        
    }
    
    /**
     * The main interface of the Symbolic Derivative Calculator. Allows the 
     * user to repeatedly compute derivatives until finished. Returns to the 
     * menu when finished
     */
    public static void run(){
        
        Scanner in_scan = new Scanner(System.in);
        String choice;
        do{
            System.out.println("----------Symbolic Derivative Calculator----------");
        
            String f;
            System.out.println("Define a function in a single variable x.");
            System.out.print("f(x) = ");
            f = in_scan.nextLine();        

            Parse_Tree test_tree = new Parse_Tree(f);
            System.out.println("f'(x) = " + test_tree.f_prime.f_prime);
            System.out.println("Enter y to differentiate another function or"
                               + " anything else to exit");
            choice = in_scan.nextLine();
        }while(choice.equals("y"));
        
    }
    
    /**
     * Shows the guidelines for formating functions for input. Returns to the
     * menu when finished
     */
    public static void instructions(){
        
        // Declare Scanner object to recieve input from standard input
        Scanner in_scan = new Scanner(System.in);
        int choice;
        
        do{
            // Display the syntax rules
            System.out.println("1. All arguments for functions must be enclosed"
                               + " in parentheses ie sin(x) x^(3) ln(x+1)");
            System.out.println("2.");
            
            
            // Allow user to exit when finished
            System.out.println("Input a 0 to return to the main menu");
            System.out.print("ENTER:");
            choice = in_scan.nextInt();
            
        }while(choice != 0);    
        
    }
    
}
