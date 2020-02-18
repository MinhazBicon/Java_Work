import javax.swing.SwingUtilities; 
  
public class Hangman implements Runnable { 
  
    public void run() { 
        new HangmanFrame(new HangmanModel()); 
    } 
      
    public static void main(String[] args) { 
        SwingUtilities.invokeLater(new Hangman()); 
    } 
  
} 