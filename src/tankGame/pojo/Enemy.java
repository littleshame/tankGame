package tankGame.pojo;

import java.awt.Color;

public class Enemy extends Tank {

	private static final boolean DEFAULT_AGAINST = true;
	private static final Color DEFAULT_COLOR = Color.CYAN;
	
	public Enemy(int x, int y, Direct direct){
		this.x = x;
		this.y = y;
		this.direct = direct;
		this.against = DEFAULT_AGAINST;
		this.color = DEFAULT_COLOR;
		
	}
}
