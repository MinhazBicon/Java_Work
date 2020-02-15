package game;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        
    	JOptionPane.showMessageDialog(null, "Delve as far as you can into THE CATACOMBS. \nUse the arrow keys to make it down to the next floor. \nAvoid the ghosts as best you can, as a single hit will kill you, but remember that they cannot hurt you if you stand still.");

    	
        JFrame window = new JFrame();
        window.setTitle("THE CATACOMBS");
        window.setSize(600,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        
        
        Board board = new Board();
        
        
        
        window.add(board);
        window.setVisible(true);
        board.setFocusable(true);
        
        
        
        
        //JOptionPane.showMessageDialog(null, "GAME OVER");
        //window.dispose();
    }

}