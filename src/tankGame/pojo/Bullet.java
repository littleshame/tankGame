package tankGame.pojo;

import java.awt.Color;
import java.awt.Graphics;

import tangkGame.test.GameBox;

public class Bullet extends Model implements Runnable {

	public static final Color DEFAULT_COLOR = Color.white;
	public static final int DEFAULT_SPEED = 1;

	boolean against;
	int speed;

	public Bullet(int x, int y, Direct direct, boolean against) {
		super();
		this.x = x;
		this.y = y;
		this.direct = direct;
		this.color = DEFAULT_COLOR;
		this.against = against;
		this.speed = DEFAULT_SPEED;
		this.isLive = true;
	}

	@Override
	public void run() {
		while(isLive){
			move();			
		}
	}

	private void move() {
		//不睡眠瞬间move会运行太快
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		
		// 子弹跑出地图外就死惹
		if (x < 0 || x > GameBox.DEFAULT_WIDTH || y < 0 || y > GameBox.DEFAULT_HEIGHT) {
			isLive = false;
		}
			// 子弹朝着方向运动
			switch (direct) {
			case UP:
				y = y - speed;
				break;
			case DOWN:
				y = y + speed;
				break;
			case RIGHT:
				x = x + speed;
				break;
			case LEFT:
				x = x - speed;
				break;
			}
		//	System.out.println("子弹x坐标:" + x + "," + "y坐标:" + y +","+isLive());
	}

	public void draw(Graphics g) {

		g.setColor(Color.white);
		g.fillOval(x, y, 3, 3);
	}

}
