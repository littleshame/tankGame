package tankGame.pojo;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Tank extends Model {

	boolean against;// 敌对状态

	List<Bullet> bullets = new ArrayList<Bullet>();

	// 发射子弹
	public Bullet launchBullet() {
		Bullet b = null;

		switch (direct) {
		case UP:
			b = new Bullet(x + 8, y - 5, this.direct, against);
			// 把子弹加入到子弹集
			bullets.add(b);
			break;
		case DOWN:
			b = new Bullet(x + 8, y + 35, this.direct, against);
			bullets.add(b);
			break;
		case RIGHT:
			b = new Bullet(x + 30, y + 12, this.direct, against);
			bullets.add(b);
			break;
		case LEFT:
			b = new Bullet(x - 10, y + 13, this.direct, against);
			bullets.add(b);
			break;
		}
		Thread go = new Thread(b);
		go.start();
		return b;
	}

	// 坦克渲染
	public void draw(Graphics g) {
		if (null != color)
			g.setColor(color);

		switch (direct) {
		case UP:
			g.fill3DRect(x, y, 5, 30, false);

			g.fill3DRect(x + 15, y, 5, 30, false);

			g.fill3DRect(x + 5, y + 5, 10, 20, false);
			g.fillOval(x + 5, y + 10, 10, 10);
			g.drawLine(x + 10, y - 5, x + 10, y + 15);
			break;
		case DOWN:
			g.fill3DRect(x, y, 5, 30, false);

			g.fill3DRect(x + 15, y, 5, 30, false);

			g.fill3DRect(x + 5, y + 5, 10, 20, false);
			g.fillOval(x + 5, y + 10, 10, 10);
			g.drawLine(x + 10, y + 15, x + 10, y + 35);
			break;
		case RIGHT:
			g.fill3DRect(x - 5, y + 5, 30, 5, false);
			g.fill3DRect(x, y + 10, 20, 10, false);

			g.fill3DRect(x - 5, y + 20, 30, 5, false);
			g.fillOval(x + 5, y + 10, 10, 10);
			g.drawLine(x + 15, y + 13, x + 30, y + 13);
			break;
		case LEFT:
			g.fill3DRect(x - 5, y + 5, 30, 5, false);
			g.fill3DRect(x, y + 10, 20, 10, false);
			g.fill3DRect(x - 5, y + 20, 30, 5, false);
			g.fillOval(x + 5, y + 10, 10, 10);
			g.drawLine(x + 10, y + 13, x - 10, y + 13);
			break;
		}

	}

	public void move(Direct direct) {
		switch(direct){
		case UP:
			this.direct = direct;
			setY(y - speed);
			break; 
		case DOWN:
			this.direct = direct;
			setY(y + speed);
			break;
		case LEFT:
			this.direct = direct;
			setX(x - speed);
			break;
		case RIGHT:
			this.direct = direct;
			setX(x + speed);
			break;
		}
		//System.out.println("tank--x:"+x+" y:"+y+" direct:"+direct+" speed:"+speed);
	}

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

	public boolean isAgainst() {
		return against;
	}

	public void setAgainst(boolean against) {
		this.against = against;
	}

	public Direct getDirect() {
		return direct;
	}

	public void setDirect(Direct direct) {
		this.direct = direct;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public List<Bullet> getBullets() {
		return bullets;
	}

	public void setBullets(List<Bullet> bullets) {
		this.bullets = bullets;
	}
}
