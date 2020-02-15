package game;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Board extends JPanel implements KeyListener{

    
    public final static int LENGTH = 600, WIDTH = 600;
    
    int speed = 3;
    
    int score = 0;
    
    Pacman pacman;
    
    Exit exit;
    
    Ghost[] ghost = new Ghost[12];
    
    int boardCheck = 3;
    
    public Board(){
        
        pacman = new Pacman(30,30, "images//pacman.png");
        
        if(boardCheck==3)exit = new Exit(540,540, "images//exit.png");
        
        if(boardCheck==2)exit = new Exit(60,60, "images//exit.png");
        
        if(boardCheck==4)exit = new Exit(540,540, "images//exit.png");
        
       
        
        
        
        for(int i = 0; i < ghost.length; i++){

            ghost[i] = new Ghost((int)(Math.random() * 500), (int)(Math.random() * 500), "images//ghost.png" );
            
            
           
            
            GhostMover gm = new GhostMover(this,ghost[i], speed);
            gm.start();
        }
        
        super.addKeyListener(this);
    
    }
    
    public void paint(Graphics g){
    
    	 ImageIcon background = new ImageIcon("images//board.png");
         
         Image back_img = background.getImage();
         g.drawImage(back_img, 0,0, null);
         
         pacman.draw(g);
         
         exit.draw(g);
         
         for(int i = 0; i<ghost.length; i++) {ghost[i].draw(g);}
         
         
         
         brickBuilder(boardCheck, g);
         
         //for(int i = 0; i<brick.length; i++) {brick[i].draw(g);}
         
    	
    	if(this.checkExit() == true){
    		
    		if(boardCheck==2){
    			
    		
    		background = new ImageIcon("images//board2.png");
            
            back_img = background.getImage();
            g.drawImage(back_img, 0,0, null);
            
            pacman.draw(g);
            
            //pacman = new Pacman(270, 270, "images//pacman.png");
            
            exit.draw(g);
            
            score++;
            
            brickBuilder(boardCheck, g);
            
            
            
            //for(int i = 0; i<ghost.length; i++) {ghost[i].draw(g);}
            
            //for(int i = 0; i<brick.length; i++) {brick[i].draw(g);}
            
            speed++;
            
            boardCheck = 4;
    		
            pacman = new Pacman(60,60, "images//pacman.png");
            
            exit = new Exit(540, 570, "images//exit.png");
            for(int i = 0; i < ghost.length; i++){
            GhostMover gm = new GhostMover(this,ghost[i], speed);
            gm.start();
            }
    	}
            
    		else if(boardCheck==3){
                
            	background = new ImageIcon("images//board.png");
                
                back_img = background.getImage();
                g.drawImage(back_img, 0,0, null);
                
                pacman.draw(g);
                
                //pacman = new Pacman(270, 270, "images//pacman.png");
                
                exit.draw(g);
                
                score++;
                
                brickBuilder(boardCheck, g);
                
                exit = new Exit(60, 60, "images//exit.png");
                
                //for(int i = 0; i<ghost.length; i++) {ghost[i].draw(g);}
                
                //for(int i = 0; i<brick.length; i++) {brick[i].draw(g);}
                
                speed++;
                
                boardCheck = 2;
        		
                pacman = new Pacman(510,480, "images//pacman.png");
                
                for(int i = 0; i < ghost.length; i++){
                GhostMover gm = new GhostMover(this,ghost[i], speed);
                gm.start();
                }
        	}
            
    		else  if(boardCheck==4){
    			
        		
        		background = new ImageIcon("images//board.png");
                
                back_img = background.getImage();
                g.drawImage(back_img, 0,0, null);
                
                score++;
                
                pacman.draw(g);
                
                //pacman = new Pacman(270, 270, "images//pacman.png");
                
                exit.draw(g);
                
                
                
                brickBuilder(boardCheck, g);
                
                //pacman = new Pacman(30,30, "images//pacman.png");
                
                pacman = new Pacman(30,30, "images//pacman.png");
                
                exit = new Exit(540,540, "images//exit.png");
                
                //for(int i = 0; i<ghost.length; i++) {ghost[i].draw(g);}
                
                //for(int i = 0; i<brick.length; i++) {brick[i].draw(g);}
                
                speed++;
                
                boardCheck = 3;
        		
                for(int i = 0; i < ghost.length; i++){
                GhostMover gm = new GhostMover(this,ghost[i], speed);
                gm.start();
                }
        	}
    	}
    	else{
    	
       
    	}
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        if(e.getKeyCode() == e.VK_UP) {pacman.moveUp();eatGhost();
        
        if(checkBrickCollision()==true) {pacman.moveDown();  pacman.moveDown();} }
        
        // VK stands for Virtual Key
        
        else if(e.getKeyCode() == e.VK_DOWN) {pacman.moveDown();eatGhost();
        
        if(checkBrickCollision()==true){ pacman.moveUp(); pacman.moveUp();}
        
        }
        
        else if(e.getKeyCode() == e.VK_LEFT) {pacman.moveLeft();eatGhost();
        
        if(checkBrickCollision()==true) {pacman.moveRight(); pacman.moveRight();}
        
        }
        
        else if(e.getKeyCode() == e.VK_RIGHT) {pacman.moveRight();eatGhost();
        
        if(checkBrickCollision()==true) {pacman.moveLeft(); pacman.moveLeft();}}
            
        eatGhost();
        super.repaint();
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }
    
    public void eatGhost(){
        
        Rectangle pacmanRect = new Rectangle(pacman.getX(), pacman.getY(), 24, 10);
        
    
        for(int i = 0; i< ghost.length; i++){
            
            Rectangle ghostRect = new Rectangle(ghost[i].getX(), ghost[i].getY(), 20, 20);
            
            if(pacmanRect.intersects(ghostRect) == true) {  
            	
            	GameSound.eatGhostSound();
            	GameSound.gameOverSound();
            	
            	JOptionPane.showMessageDialog(null, "Game Over! Try Again! Your meagre score was: " +score);
                System.exit(0);}
        
        }
        
        
        }
    
    @SuppressWarnings("resource")
	public boolean checkBrickCollision(){
        
        Rectangle pacmanRect = new Rectangle(pacman.getX(), pacman.getY(), 24, 20);
        
        
        
        File f = new File("boards//board" + boardCheck + ".txt"); 
		
     	Scanner inputFromFile;
            
     	try {
			inputFromFile = new Scanner(f);
		
			 while(inputFromFile.hasNextLine()){
				 
				 int x =  Integer.parseInt(inputFromFile.nextLine());
 				
 				int y = Integer.parseInt(inputFromFile.nextLine());
				 
				 Rectangle brickRect= new Rectangle(x, y,30,30 );
			 
				 
		            if(pacmanRect.intersects(brickRect) == true) {
		            
		            	GameSound.smashBricksSound();
		            	
		            	return true;
		        
		        }
			 }
		 
		 
	
		}
		 
		 catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
             
           
        
        return false;
    }
    
public boolean checkExit(){
        
        Rectangle pacmanRect = new Rectangle(pacman.getX(), pacman.getY(), 24, 20);
        
            Rectangle exitRect = new Rectangle(exit.getX(), exit.getY(), 30, 30);
            
            if(pacmanRect.intersects(exitRect) == true) {
            
            	
            	GameSound.exitLevelSound();
            	
            	
            	return true;
            
            }
        
        
        
        return false;
    }
        
    public boolean isGameOver(){
        
       
            
      if(pacman.getX()!= -30 && pacman.getY()!= - 30) return false;
            
        
        
        
        return true;
    }
    
    public static int randInt(int min, int max) {

       
        Random rand = new Random();

       
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }
    
    public void brickBuilder(int boardCheck, Graphics g){
    	
    	
    	        
    		File f = new File("boards//board" + boardCheck + ".txt"); 
    		
         	Scanner inputFromFile;
         	
			try {
				inputFromFile = new Scanner(f);
			
    		
    		 
    		
    			 while(inputFromFile.hasNextLine()){
    				 
    				int x =  Integer.parseInt(inputFromFile.nextLine());
    				
    				int y = Integer.parseInt(inputFromFile.nextLine());
    				 
    				Brick brick = new Brick(x, y, "images//brick" + boardCheck +".png" );
    			 
    				brick.draw(g);
    			 
    			 
    		 }
			}
    		 
    		 catch (Exception e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 			}
    			 
    	      
        
    }}