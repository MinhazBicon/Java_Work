package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Pacman {

    private int x, y;
    private String imagePath;
    
    public Pacman(int x, int y, String imagePath) {
        
        this.x = x;
        this.y = y;
        this.imagePath = imagePath;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {

        this.y = y;
    }
    

    public String getImagePath() {

        return imagePath;
    }
    

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
    
    public void moveRight(){
    if(x < Board.WIDTH - 10){
        x = x + 30;
    }
    }

    public void moveLeft(){
        
        if(x>10) x = x - 30;
        
    }
    
    public void moveDown(){
        if(y < Board.WIDTH - 10) y = y + 30;
    }
    
public void moveUp(){
        
        if(y>10) y = y - 30;
        
    }


public void draw(Graphics g){
    
    ImageIcon icon = new ImageIcon(imagePath);
    
    Image image = icon.getImage();
    
    g.drawImage(image, x,y, null);
    
}
    
}