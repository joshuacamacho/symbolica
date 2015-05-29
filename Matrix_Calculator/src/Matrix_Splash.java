/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// Import libraries
import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Matrix_Splash extends JPanel{
    
    LoginUI screen = new LoginUI();
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        this.setBackground(Color.BLACK);
        
        g.setFont(new Font("Cambria Math",Font.ITALIC,88));
        g.setColor(new Color(255,255,255));
        g.drawString("Matrix Calculator", 210, 70);
        Color a = new Color(255,255,255);
        g.setColor(a);
        g.fillRect(300,123,23,375);
        g.fillRect(700,123,23,375);
        
        g.fillRect(300,120,125,25);
        g.fillRect(300,495,125,25);
        g.fillRect(598,120,125,25);
        g.fillRect(598,495,125,25);
        
        g.fillRect(386,155,20,100);
        g.fillRect(500,270,20,100);
        g.fillRect(615,385,20,100);
        
        g.fillRect(580,155,20,100);
        g.fillRect(580,235,70,20);
        g.fillRect(650,155,20,100);
        g.fillRect(600,155,70,20);
        
        g.fillRect(580,270,20,100);
        g.fillRect(580,270,70,20);
        g.fillRect(650,270,20,100);
        g.fillRect(600,350,70,20);
        
        g.fillRect(465,155,20,100);
        g.fillRect(465,235,70,20);
        g.fillRect(535,155,20,100);
        g.fillRect(465,155,70,20);
        
        g.fillRect(350,270,20,100);
        g.fillRect(350,350,70,20);
        g.fillRect(420,270,20,100);
        g.fillRect(350,270,70,20);
        
        g.fillRect(350,385,20,100);
        g.fillRect(350,385,70,20);
        g.fillRect(420,385,20,100);
        g.fillRect(350,465,70,20);
        
        g.fillRect(465,385,20,100);
        g.fillRect(465,385,70,20);
        g.fillRect(535,385,20,100);
        g.fillRect(465,465,70,20);
        
        KeyListener listener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {
            }
            @Override
            public void keyPressed(KeyEvent ke) {
                int key = ke.getKeyCode();
                if (key == KeyEvent.VK_ENTER) {
                    screen.setVisible(true);
                    
                } 
                else if(key == KeyEvent.VK_ESCAPE)
                    System.exit(0);
            }
            @Override
                public void keyReleased(KeyEvent ke) {
                }
            };
         
            addKeyListener(listener);
            setFocusable(true);
            requestFocusInWindow();
    }
    
}
