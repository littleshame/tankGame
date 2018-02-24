package tankGame.pojo;

import java.awt.Color;

public abstract class Model {

	int x;
	int y;
	Direct direct;
	boolean against;
	Color color;
	int life;
	int speed;
	boolean isLive;
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public Direct getDirect() {
		return direct;
	}
	public void setDirect(Direct direct) {
		this.direct = direct;
	}
	public boolean isAgainst() {
		return against;
	}
	public void setAgainst(boolean against) {
		this.against = against;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public int getLife() {
		return life;
	}
	public void setLife(int life) {
		this.life = life;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public boolean isLive() {
		return isLive;
	}
	public void setLive(boolean isLive) {
		this.isLive = isLive;
	}
	
}
