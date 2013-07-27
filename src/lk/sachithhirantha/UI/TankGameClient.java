/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.sachithhirantha.UI;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

/**
 *
 * @author Hirantha
 */
public class TankGameClient extends BasicGame {
    
    TiledMap stoneMap;
    
    public TankGameClient()
    {
        super("Tank Game");
    }
    
    public static void main(String[] arguments)
    {
    	try {
			AppGameContainer app = new AppGameContainer(new TankGameClient());
			app.setDisplayMode(1280, 720, false);
			app.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
    }
    
    @Override
    public void init(GameContainer container) throws SlickException
    {
        
        stoneMap = new TiledMap("data/tiles/stones_20.tmx");
    }
 
    @Override
    public void update(GameContainer container, int delta) throws SlickException
    {
    }
    
    @Override
    public void render(GameContainer gc, org.newdawn.slick.Graphics grphcs) throws SlickException {
    	int pos = (720-20*32)/2;
        stoneMap.render(pos, pos);
    }
}
