package javagame;
import java.awt.Font;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import java.awt.Font;

public class Menu extends BasicGameState{
	
	Image playNow;
	Image exitGame;
	public String mouse="";
	public Music openingMenuMusic;
	TrueTypeFont font;
	TrueTypeFont font2;
	
	public Menu( int State)
	{
		
	}
	public void init(GameContainer gc, StateBasedGame sbg)throws SlickException
	{
		Font awtFont = new Font("TimesRoman", Font.ITALIC | Font.BOLD, 24);
		font = new TrueTypeFont(awtFont, false);
		Music openingMenuMusic = new Music("res/cosmic_dreams.ogg");
		openingMenuMusic.loop(1.0F, 1.1F);
		playNow = new Image("res/playNow.png");
		exitGame = new Image("res/exitGame.png");
	}
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)throws SlickException //method to draw object on the screen 
	{
		g.setFont(font);
		g.setColor(Color.white);
		g.drawString("WELCOME TO BUCKY LAND!!", 100, 50);
		g.drawImage(playNow,100, 100); //one way 
		exitGame.draw(100, 200); //another way to draw image
		g.drawString(mouse, 200, 250);
		
	}
	public void update(GameContainer gc, StateBasedGame sbg, int delta)throws SlickException //updates or moves to make them animated
	{
		int posX = Mouse.getX();
		int posY = Mouse.getY();
		mouse="x: "+posX+" y: "+posY;
		if((posX>100 && posX<311) && (posY>209 && posY<260)) //check if the mouse is in the play now button
		{
			if(Mouse.isButtonDown(0))
			{
				sbg.enterState(1); //enter play state
			}
		}
		if((posX>100 && posX<311) && (posY>109 && posY<160)) //check if the mouse is in the exit now button
		{
			if(Mouse.isButtonDown(0))
			{
				System.exit(0); //0 so that it exits without crashing
			}
		}
	}
	public int getID()
	{
		return 0;
	}

}