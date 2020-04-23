package javagame;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import java.awt.Font;

public class Play extends BasicGameState{
	
	Animation bucky, movingUp, movingDown, movingLeft, movingRight;
	Image worldMap;
	Image hamburger;
	Image pizza;
	Image drink;
	Image fries;
	Image candy;
	Image bunny;
	boolean quit=false; //for users to quit the game
	boolean hello=false;
	int [] duration={200, 200}; //animation will last for 0.2s
	int points=0;
	float buckyPositionX=0; //bucky's x coordinate
	float buckyPositionY=0; //bucky's y coordinate
	float shiftX = buckyPositionX + 320; //the window size is 640 and 320, so this brings bucky 
	float shiftY = buckyPositionY + 80; // in the middle and moves the map whereas it appears as if he's moving 
	boolean lost= false;
	public Music openingMenuMusic;
	TrueTypeFont font;
	TrueTypeFont font2;
	public Play( int State)
	{
		
	}
	public void init(GameContainer gc, StateBasedGame sbg)throws SlickException
	{
		Music openingMenuMusic = new Music("res/synthesizers_from_space_psr_280.ogg");
		openingMenuMusic.loop(1.0F, 1.1F);
		Font awtFont = new Font("TimesRoman", Font.BOLD, 16);
		font = new TrueTypeFont(awtFont, false);
		worldMap=new Image("res/world.png");
		hamburger = new Image("res/ham.png"); 
		pizza = new Image("res/pizza.png"); 
		bunny = new Image("res/bunny.png"); 
		drink = new Image("res/drink.png"); 
		fries = new Image("res/fries.png");
		candy = new Image("res/candy.png"); 
		 Image[] walkUp = {new Image("res/buckysBack.png"), new Image("res/buckysBack.png")}; //Animation for bucky moving up
		 Image[] walkDown = {new Image("res/buckysFront.png"), new Image("res/buckysFront.png")};
		 Image[] walkLeft = {new Image("res/buckysLeft.png"), new Image("res/buckysLeft.png")};
		 Image[] walkRight = {new Image("res/buckysRight.png"), new Image("res/buckysRight.png")};
 //animation takes 3 parameters: images, duration and auto update
		 movingUp = new Animation(walkUp, duration, false);
		 movingDown = new Animation(walkDown, duration, false);
		 movingLeft = new Animation(walkLeft, duration, false);
		 movingRight = new Animation(walkRight, duration, false);
		 bucky = movingDown; 
	}
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)throws SlickException //method to draw object on the screen 
	{
		g.setFont(font);
		worldMap.draw(buckyPositionX, buckyPositionY); //draws at 0,0
		hamburger.draw(buckyPositionX, buckyPositionY);
		pizza.draw(buckyPositionX+200, buckyPositionY+200);
		fries.draw(buckyPositionX+600, buckyPositionY+150);
		candy.draw(buckyPositionX+800, buckyPositionY+450);
		drink.draw(buckyPositionX+1000, buckyPositionY+700);
		bunny.draw(buckyPositionX+100, buckyPositionY+700);
		bucky.draw(shiftX, shiftY); //bucky at the center;
		g.drawString("Buckys x: "+buckyPositionX+"\nBuckys y: "+buckyPositionY, 400, 20);
		g.drawString("Points: "+points, 400, 40);
		
		
		if(points==1)
		{
			g.drawString("get the pizza!!", 250, 50);
		}
		if(points==2)
		{
			g.drawString("get the fries!!", 250, 50);
		}
		if(points==3)
		{
			g.drawString("get the candy!!", 250, 50);
		}
		if(points==4)
		{
			g.drawString("get the drink!!", 250, 50);
		}
		if(points==5)
		{
			g.drawString("GET BUNNY!!!", 250, 50);
		}
		
		
		if(quit==true)
		{
			g.drawString("Resume (R)", 250, 100);
			g.drawString("Main Menu (M)", 250, 150);
			g.drawString("Quit (Q)", 250, 200);
			if(quit==false)
			{
				g.clear();
			}
		}

	}
	public void update(GameContainer gc, StateBasedGame sbg, int delta)throws SlickException //updates or moves to make them animated
	{
		Input input = gc.getInput(); //all the info from the mouse and keyboard are stored in input
		if(input.isKeyDown(Input.KEY_UP ) && buckyPositionY < 90) 
		{
		    bucky = movingUp;
		    buckyPositionY += delta * .2f; //delta (in slick) is the number of milliseconds between calls to the update method
		}
		if(input.isKeyDown(Input.KEY_DOWN) && buckyPositionY >-700)
		{
			bucky = movingDown;
			buckyPositionY-=delta * .2f; //moves bucky down, delta (in slick) is the number of milliseconds between calls to the update method
		}
		if(input.isKeyDown(Input.KEY_LEFT) && buckyPositionX<318)
		{
			bucky = movingLeft;
			buckyPositionX+=delta * .2f; //moves bucky left, delta (in slick) is the number of milliseconds between calls to the update method
		}
		if(input.isKeyDown(Input.KEY_RIGHT) && buckyPositionX > -840)
		{
			bucky = movingRight;
			buckyPositionX-=delta * .2f; //moves bucky right, delta (in slick) is the number of milliseconds between calls to the update method
		}
		
		
		
		
		
		if((buckyPositionY < -18 && buckyPositionY >-151)&&(buckyPositionX <68 && buckyPositionX >-59)) 
		{
			lost=true;
		}
		//house
		if((buckyPositionY < -240 && buckyPositionY >-389)&&(buckyPositionX <-142 && buckyPositionX >-352)) 
		{
			lost=true;
		}
		if((buckyPositionY < -316 && buckyPositionY >-432)&&(buckyPositionX <265 && buckyPositionX >103)) 
		{
			lost=true;
		}
		if((buckyPositionY < -455 && buckyPositionY >-605)&&(buckyPositionX <13 && buckyPositionX >-160)) 
		{
			lost=true;
		}
		if((buckyPositionY < -38 && buckyPositionY >-206)&&(buckyPositionX <-337 && buckyPositionX >-516)) 
		{
			lost=true;
		}
		if((buckyPositionY < 18 && buckyPositionY >-137)&&(buckyPositionX <-600 && buckyPositionX >-760)) 
		{
			lost=true;
		}
		if((buckyPositionY < -270 && buckyPositionY >-422)&&(buckyPositionX <-580 && buckyPositionX >-720)) 
		{
			lost=true;
		}
		if((buckyPositionY < -460 && buckyPositionY >-600)&&(buckyPositionX <-400 && buckyPositionX >-576)) 
		{
			lost=true;
		}
		
		
		
		//hamburger
		if((buckyPositionY <100  && buckyPositionY >70)&&(buckyPositionX <320 && buckyPositionX >285)) 
		{
			hamburger.setAlpha(0); 
			points=1;
		}
		//pizza
		if(points==1)
		{
			if((buckyPositionY <-90  && buckyPositionY >-140)&&(buckyPositionX <137 && buckyPositionX >81)) 
			{
				pizza.setAlpha(0);
				points=2;
			}
		}
		//fries
		if(points==2)
		{
			if((buckyPositionY <-38  && buckyPositionY >-95)&&(buckyPositionX <-249 && buckyPositionX >-303)) 
			{
				fries.setAlpha(0);
				points=3;
			}
		}
		//candy
		if(points==3)
		{
			if((buckyPositionY <-328  && buckyPositionY >-394)&&(buckyPositionX <-460 && buckyPositionX >-510)) 
			{
				candy.setAlpha(0);
				points=4;
			}
		}
		//drink
		if(points==4)
		{
			if((buckyPositionY <-583  && buckyPositionY >-655)&&(buckyPositionX <-660 && buckyPositionX >-690)) 
			{
				drink.setAlpha(0);
				points=5;
			}
		}
		//bunny
		if(points==5)
		{
			if((buckyPositionY <-583  && buckyPositionY >-590)&&(buckyPositionX <247 && buckyPositionX >188)) 
			{
				hello=true;
				sbg.enterState(3);
			}
		}
		
		
		
		
		if(lost==true)
		{
			sbg.enterState(2);
			buckyPositionX=0;
			buckyPositionY=0;
			lost=false;
		}
		if(input.isKeyDown(Input.KEY_ESCAPE))
		{
			quit= true;
		}
		if(quit==true)
		{
			if(input.isKeyDown(Input.KEY_R))
			{
				quit=false;
			}
			if(input.isKeyDown(Input.KEY_M))
			{
				sbg.enterState(0);
			}
			if(input.isKeyDown(Input.KEY_Q))
			{
				System.exit(0);
			}
		}
	}
	public int getID()
	{
		return 1;
	}

}