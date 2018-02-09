package tankGame.pojo;

import java.awt.Color;
import java.awt.Graphics;

public class Tank {
	int x = 0;
	int y = 0;
	boolean against;//1 我方 0 敌方
	Direct direct;//方向
	Color color;
	
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

	public void shoot(){
		
	}
	
	//这些长宽数据后面可以常量化
	public void draw(Graphics g){
		if(null != color)
		g.setColor(color);
		
		// 判断方向
		switch (direct) {
		// 向上
		case UP:
			// 左边的矩形
			g.fill3DRect(x, y, 5, 30, false);

			// 右边的矩形
			g.fill3DRect(x + 15, y, 5, 30, false);

			// 中间的矩形
			g.fill3DRect(x + 5, y + 5, 10, 20, false);
			// 圆形
			g.fillOval(x + 5, y + 10, 10, 10);
			// 线
			g.drawLine(x + 10, y - 5, x + 10, y + 15);
			break;
		// 向下
		case DOWN:
			g.fill3DRect(x, y, 5, 30, false);

			// 右边的矩形
			g.fill3DRect(x + 15, y, 5, 30, false);

			// 中间的矩形
			g.fill3DRect(x + 5, y + 5, 10, 20, false);
			// 圆形
			g.fillOval(x + 5, y + 10, 10, 10);
			// 线
			g.drawLine(x + 10, y + 15, x + 10, y + 35);
			break;
		// 向右
		case LEFT:
			// 上面的矩形
			g.fill3DRect(x - 5, y + 5, 30, 5, false);
			// 中间的矩形
			g.fill3DRect(x, y + 10, 20, 10, false);

			// 下面的矩形
			g.fill3DRect(x - 5, y + 20, 30, 5, false);
			// 圆形
			g.fillOval(x + 5, y + 10, 10, 10);
			// 线
			g.drawLine(x + 15, y + 13, x + 30, y + 13);
			break;
		// 向左
		case RIGHT:
			// 上面的矩形
			g.fill3DRect(x - 5, y + 5, 30, 5, false);
			// 中间的矩形
			g.fill3DRect(x, y + 10, 20, 10, false);
			// 下面的矩形
			g.fill3DRect(x - 5, y + 20, 30, 5, false);
			// 圆形
			g.fillOval(x + 5, y + 10, 10, 10);
			// 线
			g.drawLine(x + 10, y + 13, x - 10, y + 13);
			break;
		}
		
	}
	
}
