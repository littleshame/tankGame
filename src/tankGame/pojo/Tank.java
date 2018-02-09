package tankGame.pojo;

import java.awt.Color;
import java.awt.Graphics;

public class Tank {
	int x = 0;
	int y = 0;
	boolean against;//1 �ҷ� 0 �з�
	Direct direct;//����
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
	
	//��Щ�������ݺ�����Գ�����
	public void draw(Graphics g){
		if(null != color)
		g.setColor(color);
		
		// �жϷ���
		switch (direct) {
		// ����
		case UP:
			// ��ߵľ���
			g.fill3DRect(x, y, 5, 30, false);

			// �ұߵľ���
			g.fill3DRect(x + 15, y, 5, 30, false);

			// �м�ľ���
			g.fill3DRect(x + 5, y + 5, 10, 20, false);
			// Բ��
			g.fillOval(x + 5, y + 10, 10, 10);
			// ��
			g.drawLine(x + 10, y - 5, x + 10, y + 15);
			break;
		// ����
		case DOWN:
			g.fill3DRect(x, y, 5, 30, false);

			// �ұߵľ���
			g.fill3DRect(x + 15, y, 5, 30, false);

			// �м�ľ���
			g.fill3DRect(x + 5, y + 5, 10, 20, false);
			// Բ��
			g.fillOval(x + 5, y + 10, 10, 10);
			// ��
			g.drawLine(x + 10, y + 15, x + 10, y + 35);
			break;
		// ����
		case LEFT:
			// ����ľ���
			g.fill3DRect(x - 5, y + 5, 30, 5, false);
			// �м�ľ���
			g.fill3DRect(x, y + 10, 20, 10, false);

			// ����ľ���
			g.fill3DRect(x - 5, y + 20, 30, 5, false);
			// Բ��
			g.fillOval(x + 5, y + 10, 10, 10);
			// ��
			g.drawLine(x + 15, y + 13, x + 30, y + 13);
			break;
		// ����
		case RIGHT:
			// ����ľ���
			g.fill3DRect(x - 5, y + 5, 30, 5, false);
			// �м�ľ���
			g.fill3DRect(x, y + 10, 20, 10, false);
			// ����ľ���
			g.fill3DRect(x - 5, y + 20, 30, 5, false);
			// Բ��
			g.fillOval(x + 5, y + 10, 10, 10);
			// ��
			g.drawLine(x + 10, y + 13, x - 10, y + 13);
			break;
		}
		
	}
	
}
