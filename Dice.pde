int squareSize = 50;    //square size
int circleSize = 6;     //dot size

ArrayList<Die> dices;

void setup()
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

void draw()
{
    drawDice(); 
    textSize(20);
    fill(0);
    text("Total Dots: " + total_dots, 170, 400);
}

int total_dots = 0;
void drawDice()
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

void mousePressed()
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

    void reroll()
    {
        numDots = (int)(Math.random()*6+1);
        println(numDots);
    }

    void drawEllipse(float x, float y)
    {
        ellipse(xLocation + x, yLocation + y, circleSize, circleSize);
    }

    void show()
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
            drawEllipse(16.67, 16.67);
            drawEllipse(33.33, 33.33);    
        }
        
        else if (numDots == 3)
        {
            drawEllipse(16.67, 16.67);
            drawEllipse(33.33, 33.33);
            drawEllipse(25, 25);
        }    

        else if (numDots == 4)
        {
            drawEllipse(16.67, 16.67);
            drawEllipse(16.67, 33.33);
            drawEllipse(33.33, 16.67);
            drawEllipse(33.33, 33.33);
        }    

        else if (numDots == 5)
        {
            drawEllipse(16.67, 16.67);
            drawEllipse(16.67, 33.33);
            drawEllipse(33.33, 16.67);
            drawEllipse(33.33, 33.33);
            drawEllipse(25, 25);
        }    

        else if (numDots == 6)
        {
            drawEllipse(16.67, 16.67);
            drawEllipse(16.67, 24.5);
            drawEllipse(16.67, 33.33);
            drawEllipse(33.33, 16.67);
            drawEllipse(33.33, 24.5);
            drawEllipse(33.33, 33.33);
        }  
    } 

    int getNumDots()
    {
        return numDots;
    }
}


