/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package synchronization.ViewModel;

import synchronization.ViewModel.GameObject;
import synchronization.View.Game;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import synchronization.ViewModel.Handler;

/**
 *
 * @author Satria Ramadhani and Modified by Muhammad Rayhan Nur
 */
public class Controller extends KeyAdapter implements KeyListener
{
    /**
     * Attribute declaration.
     */
    
    private Game game;
    private Handler handler;
    private char direction; // to store the player's current direction (so the score can only be increase if the player change the direction)
    
    /**
     * Constructor.
     */
    
    // Default constructor.
    public Controller()
    {
        this.game = new Game();
        this.handler = new Handler();
    }
    
    // Constructor with controller data.
    public Controller(Game game, Handler handler)
    {
        this.game = game;
        this.handler = handler;
    }
    
    /**
     * Getter and Setter.
     */

    /* Controller's game. */
    
    public Game getGame()
    {
        return game;
    }

    public void setGame(Game game)
    {
        this.game = game;
    }

    /* Controller's handler. */
    
    public Handler getHandler()
    {
        return handler;
    }

    public void setHandler(Handler handler)
    {
        this.handler = handler;
    }
    
    /**
     * Public methods.
     */
    
    // Override trait when key is pressed.
    @Override
    public synchronized void keyPressed(KeyEvent e)
    {
        System.out.println("Pressed: ");

        // Get key code (what key that pressed?).
        int key = e.getKeyCode();
        if(game.isRunning())
        {
            // Searching for player object.
            int i = 0; boolean found = false;
            while((found == false) && (i < handler.count()))
            {
                if(handler.get(i).getType().equals("Player"))
                {
                    found = true;
                }
                else
                {
                    i++;
                }
            }
            
            // Searching for snack object.
            int j = 0; boolean foundSnack = false;
            while((foundSnack == false) && (j < handler.count()))
            {
                if(handler.get(j).getType().equals("Snack"))
                {
                    foundSnack = true;
                }
                else
                {
                    j++;
                }
            }
            
            // Set the object and do the handling.
            GameObject temp = handler.get(i);
            GameObject tempSnack = handler.get(j);

            if((key == KeyEvent.VK_W) || (key == KeyEvent.VK_UP))
            {
                // Move up.
                temp.setVelY(-5);
                if (direction != 'U') {
                    game.setScore(+1);
                    direction = 'U';
                }
            }
            if((key == KeyEvent.VK_A) || (key == KeyEvent.VK_LEFT))
            {
                // Move left.
                temp.setVelX(-5);
                if (direction != 'L') {
                    game.setScore(+1);
                    direction = 'L';
                }
            }
            if((key == KeyEvent.VK_S) || (key == KeyEvent.VK_DOWN))
            {
                // Move down.
                temp.setVelY(+5);
                if (direction != 'D') {
                    game.setScore(+1);
                    direction = 'D';
                }
            }
            if((key == KeyEvent.VK_D) || (key == KeyEvent.VK_RIGHT))
            {
                // Move right.
                temp.setVelX(+5);
                if (direction != 'R') {
                    game.setScore(+1);
                    direction = 'R';
                }
            }
            System.out.println("Player -> X: " + temp.x + " | Y: " + temp.y);
            System.out.println("Snack -> X: " + tempSnack.x + " | Y: " + tempSnack.y);
                    
            // Set Eating Range (if the Player is around 25 close to the Snack, Player can eat and the score increase by 5)  
            if ((temp.getX()+25 >= tempSnack.getX() && temp.getX() <= tempSnack.getX()+25) && (temp.getY()+25 >= tempSnack.getY() && temp.getY() <= tempSnack.getY()+25))  {
                game.setScore(+5);
                tempSnack.setX(handler.getRandomInt());
                tempSnack.setY(handler.getRandomInt());
            }
        }
    }
    
    // Override trait when key is released from being pressed.
    @Override
    public synchronized void keyReleased(KeyEvent e)
    {
        System.out.println("Released");
        // Get key code (what key that released?).
        int key = e.getKeyCode();
        if(game.isRunning())
        {
            // Searching for player object.
            int i = 0; boolean found = false;
            while((found == false) && (i < handler.count()))
            {
                if(handler.get(i).getType() == "Player")
                {
                    found = true;
                }
                else
                {
                    i++;
                }
            }
            
            // Searching for snack object.
            int j = 0; boolean foundSnack = false;
            while((foundSnack == false) && (j < handler.count()))
            {
                if(handler.get(j).getType().equals("Snack"))
                {
                    foundSnack = true;
                }
                else
                {
                    j++;
                }
            }
            
            // Set the object and do the handling.
            GameObject temp = handler.get(i);          
            GameObject tempSnack = handler.get(j);
            
            if(key == KeyEvent.VK_SPACE)
            {
                // Close the game.
                game.setRunning(false);
                game.close();
            }
            if((key == KeyEvent.VK_W) || (key == KeyEvent.VK_UP))
            {
                // Stop from being moved up.
                temp.setVelY(0);
            }
            if((key == KeyEvent.VK_A) || (key == KeyEvent.VK_LEFT))
            {
                // Stop from being moved left.
                temp.setVelX(0);
            }
            if((key == KeyEvent.VK_S) || (key == KeyEvent.VK_DOWN))
            {
                // Stop from being moved down.
                temp.setVelY(0);
            }
            if((key == KeyEvent.VK_D) || (key == KeyEvent.VK_RIGHT))
            {
                // Stop from being moved right.
                temp.setVelX(0);
            }
            
            if((temp.getX()+30 >= tempSnack.getX() && temp.getX() <= tempSnack.getX()+30) && (temp.getY()+30 >= tempSnack.getY() && temp.getY() <= tempSnack.getY()+30))  {
                game.setScore(+5);
                tempSnack.setX(handler.getRandomInt());
                tempSnack.setY(handler.getRandomInt());
            }
        }
    }
}
