package game;

import java.util.Random;

public class GhostMover extends Thread{


        Board board;
        Ghost ghost;
        int speed;

        public GhostMover(Board board,Ghost ghost, int speed){

                this.board = board;
                this.ghost = ghost;
                this.speed = speed;

        }





        public void run(){

                while(board.isGameOver() == false){
                		
                	
                		
                        if(ghost.getY() < 560&&ghost.getX()<590){
                                ghost.setY(ghost.getY() + speed);
                               
                                try {
									Thread.sleep(1);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
                                ghost.setX(randInt(ghost.getX()-5,ghost.getX()+5));
                                //ghost.setX(ghost.getX() + 1);
                        }
                        else
                        	ghost.setY(0);
                        	
                        		//ghost.setX(0);


                        try {
                                Thread.sleep(10);
                        } catch (Exception e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                        }

                   board.repaint();

                }





        }

        public static int randInt(int min, int max) {

            
            Random rand = new Random();

           
            int randomNum = rand.nextInt((max - min) + 1) + min;

            return randomNum;
        }

}
