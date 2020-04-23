package javagame;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import java.awt.Font;

public class Game extends StateBasedGame{
	
	public static final String gamename= "Ham Blaster 1.0";
	public static final int menu=0;
	public static final int play=1;
	public static final int lost=2;
	public static final int won=3;
	
	public Game(String gamename)
	{
		super(gamename);
		this.addState(new Menu(menu));
		this.addState(new Play(play));
		this.addState(new Lost(lost));
		this.addState(new Won(won));
	}
	public void initStatesList(GameContainer gc) throws SlickException //necessary to override 
	{
		this.getState(menu).init(gc, this);
		this.getState(play).init(gc, this);
		this.getState(lost).init(gc, this);
		this.getState(won).init(gc, this);
		this.enterState(menu);  //which state to enter first 
	}

	public static void main(String[] args) {
	
		AppGameContainer appgc;
		try
		{
			appgc = new AppGameContainer(new Game(gamename)); //the window we are creating has the game with the name, gamename 
			appgc.setDisplayMode(640, 360, false); //set window size and false full screen
			appgc.start(); //creates the window 
		}
		catch(SlickException e)
		{
			e.printStackTrace();
		}

	}

}
