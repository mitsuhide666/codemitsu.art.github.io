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

public class ping_pong_2 extends PApplet {

int base=40;
int x,y,gameScore=0;
int changeX=-5;
int changeY=-5;
int gameOver=0;
int speed=100;
public void setup()
{
  
  x=(int)random(width);
  y=height-base;
}
public void draw()
{
  if(gameOver==0)
  {
  background(0); 
  text("SCORE:"+gameScore+"00",width/2,height/2);
  rect(mouseX,height-base,50,base);
  ellipse(x,y,10,10);
  x=x+changeX;
  y=y+changeY;
  if(x<0 | x>width)
  {
    changeX=-changeX;
  }
  if(y<0)
  {
    changeY=-changeY;
  }
  if(y>height-base)
  {
    //check whether it is falling inside the rectangle or not
    if(x>mouseX && x<mouseX+200)
    {
      changeY=-changeY; //bounce back
      gameScore++;
    }
    else
    {
      gameOverSplash();
    }
  }
  }
  else
  {
    background(255,0,0);
    text("YOU SUCK",width/2,height/2);
    text("Try it again YOu coward",width/2,height/2+20);
  }
}
public void gameOverSplash()
{
  gameOver=1;
}
public void mouseClicked()
{
  changeY=-changeY;
  gameScore=0;
  gameOver=0;
}
  public void settings() {  size(760, 640); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--present", "--window-color=#666666", "--hide-stop", "ping_pong_2" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
