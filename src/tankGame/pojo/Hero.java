package tankGame.pojo;

import java.awt.Color;

//英雄
public class Hero extends Tank {

	private static final boolean DEFAULT_AGAINST = false;
	private static final Color DEFAULT_COLOR = Color.yellow;
	private static final int DEFAULT_SPEED = 3;

	public Hero(int x, int y, Direct direct){
		
		this.x = x;
		this.y = y;
		this.direct = direct;
		this.against = DEFAULT_AGAINST;
		this.color = DEFAULT_COLOR;
		this.speed = DEFAULT_SPEED;
		this.isLive = true;
	}


}
