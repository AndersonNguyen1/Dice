import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class andersonDice extends PApplet {

int squareSize = 50;    //square size
int circleSize = 6;     //dot size

ArrayList<Die> dices;

public void setup()
{
    dices = new ArrayList<Die>();
    size(500,500);
    noLoop();
    for (int xCube = 0; xCube < 451; xCube+=squareSize)
    {
        for (int yCube = 0; yCube < 451; yCube+=squareSize)
        {
            dices.add(new Die(xCube, yCube));
        }    
    }  
}

public void draw()
{
    drawDice(); 
    textSize(20);
    fill(0);
    text("Total Dots: " + total_dots, 170, 400);
}

int total_dots = 0;
public void drawDice()
{
    total_dots = 0;
    background(0);
    for(int i = 0; i < dices.size(); i++)
    {
        dices.get(i).reroll();
        total_dots = total_dots + dices.get(i).getNumDots();
        dices.get(i).show();
    }
}

public void mousePressed()
{
    redraw();
}

class Die 
{
    int numDots;
    int xLocation;
    int yLocation;

    Die(int x, int y)
    {
        numDots = (int)(Math.random()*6+1);
        xLocation = x;
        yLocation = y;
    }

    public void reroll()
    {
        numDots = (int)(Math.random()*6+1);
        println(numDots);
    }

    public void drawEllipse(float x, float y)
    {
        ellipse(xLocation + x, yLocation + y, circleSize, circleSize);
    }

    public void show()
    {

        fill((int)(Math.random()*256), (int)(Math.random()*256), (int)(Math.random()*256));
        rect(xLocation, yLocation, 50, 50);
        fill(0);

        if (numDots == 1)
        {
            drawEllipse(25, 25);
        }    

        else if (numDots == 2)
        {
            drawEllipse(16.67f, 16.67f);
            drawEllipse(33.33f, 33.33f);    
        }
        
        else if (numDots == 3)
        {
            drawEllipse(16.67f, 16.67f);
            drawEllipse(33.33f, 33.33f);
            drawEllipse(25, 25);
        }    

        else if (numDots == 4)
        {
            drawEllipse(16.67f, 16.67f);
            drawEllipse(16.67f, 33.33f);
            drawEllipse(33.33f, 16.67f);
            drawEllipse(33.33f, 33.33f);
        }    

        else if (numDots == 5)
        {
            drawEllipse(16.67f, 16.67f);
            drawEllipse(16.67f, 33.33f);
            drawEllipse(33.33f, 16.67f);
            drawEllipse(33.33f, 33.33f);
            drawEllipse(25, 25);
        }    

        else if (numDots == 6)
        {
            drawEllipse(16.67f, 16.67f);
            drawEllipse(16.67f, 24.5f);
            drawEllipse(16.67f, 33.33f);
            drawEllipse(33.33f, 16.67f);
            drawEllipse(33.33f, 24.5f);
            drawEllipse(33.33f, 33.33f);
        }  
    } 

    public int getNumDots()
    {
        return numDots;
    }
}


  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "andersonDice" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
