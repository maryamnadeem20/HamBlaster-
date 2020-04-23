package javagame;

import org.lwjgl.input.Mouse;
import java.awt.Font;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Lost extends BasicGameState{

	TrueTypeFont font;
	TrueTypeFont font2;
	public Lost(int State)
	{
		
	}
	public void init(GameContainer gc, StateBasedGame sbg)throws SlickException
	{
		Font awtFont = new Font("TimesRoman", Font.ITALIC | Font.BOLD, 26);
		font = new TrueTypeFont(awtFont, false);
	}
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)throws SlickException //method to draw object on the screen 
	{
		g.setFont(font);
		g.setColor(Color.pink);
		g.drawString("You Collided !!!" , 100, 50);
		g.drawString("PRESS M TO GO TO THE MAIN MENU ", 100, 150);
		g.drawString("PRESS E TO EXIT ", 100, 250);
	}
	public void update(GameContainer gc, StateBasedGame sbg, int delta)throws SlickException //updates or moves to make them animated
	{
		Input input = gc.getInput();
		if(input.isKeyDown(Input.KEY_M))
		{
			sbg.enterState(0);
		}
		if(input.isKeyDown(Input.KEY_E))
		{
			System.exit(0);
		}
	}
	public int getID()
	{
		return 2;
	}
}
