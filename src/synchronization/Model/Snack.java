/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package synchronization.Model;

import synchronization.ViewModel.GameObject;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Muhammad Rayhan Nur
 */
public class Snack extends GameObject
{
    /**
     * Constructor.
     */
    
    // Default constructor.
    public Snack()
    {
        super(0, 0, "Snack");
        super.setHeight(30);
    }
    
    // Constructor with snack position.
    public Snack(int x, int y)
    {
        super(x, y, "Snack");
        super.setHeight(30);
    }
    
    /**
     * Override interface.
     */
    
    @Override
    public void render(Graphics object)
    {
        // Set snack shape and color.
        object.setColor(Color.decode("#FF0101"));
        object.fillOval(x, y, 30, 30);
    }
    
    public void loop() {
        
    }
    
}
