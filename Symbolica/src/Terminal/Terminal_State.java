package Terminal;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alec
 */
public class Terminal_State {
    
    private int cursor_position;
    
    public Terminal_State(){
        
        cursor_position = 72;
        
    }
    
    public void set_cursor_position(int cursor_position){
        
        this.cursor_position = cursor_position;
        
    }
    
    public int get_cursor_position(){
        
        return cursor_position;
        
    }
    
}
