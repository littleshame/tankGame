package tangkGame.test;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import tankGame.pojo.Boom;
import tankGame.pojo.Direct;
import tankGame.pojo.Enemy;
import tankGame.pojo.Hero;
import tankGame.pojo.Bullet;
import tankGame.pojo.Tank;

public class GameBox extends JFrame {

	public static final int DEFAULT_WIDTH = 400;
	public static final int DEFAULT_HEIGHT = 300;

	MapPanel map;

	public GameBox() {
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		map = new MapPanel();
		Thread t = new Thread(map);
		t.start();
		add(map);
		addKeyListener(map);
		setVisible(true);
	}

}

// 地图制造
class MapPanel extends JPanel implements KeyListener, Runnable {

	Hero hero = null;
	int enSize = 3;

	List<Tank> tanks = new ArrayList<>();
	List<Bullet> bullets = new ArrayList<>();
	List<Boom> booms = new ArrayList<>();

	public MapPanel() {
		hero = new Hero(200, 200, Direct.UP);
		tanks.add(hero);
		// 制造敌人
		for (int i = 0; i < enSize; i++) {
			Enemy et = new Enemy((i + 1) * 50, 100, Direct.DOWN);
			tanks.add(et);
		}
	}

	@Override
	public void run() {
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		while (true) {

			this.repaint();
		}
	}

	/**
	 * 绘制地图
	 */
	@Override
	public void paint(Graphics g) {
		super.paintComponent(g);
		g.fillRect(0, 0, 400, 300);

		if (null != hero) {
			drawTank(hero, g);
		}

		// 画出全部坦克
		for (int i = 0; i < tanks.size(); i++) {
			Tank tank = tanks.get(i);
			drawTank(tank, g);
			if(tank.isLive() == false){
				tanks.remove(tank);
			}
		}
		//监控 击中坦克爆炸
		allHitDeal(tanks, bullets);
		
		// 绘制 英雄的 子弹
		List<Bullet> bs = hero.getBullets();
		if (null != bs) {
			// iterator 里不能使用list.remove
			Iterator<Bullet> it = bs.iterator();
			while (it.hasNext()) {
				Bullet b = it.next();
				if (b.isLive() == true) {
					drawBullet(b, g);
				} else {
					it.remove();
				}
			}
			// 画出炸弹
			for (int i = 0; i < booms.size(); i++) {
				System.out.println("总共有"+booms.size()+"个炸弹");
				Boom boom = booms.get(i);
				drawBoom(booms.get(i), g, this);
				if (boom.getLife() == 0) {
					booms.remove(boom);
				}
			}
		}
	}

	// 击中坦克处理函数
	public void hitDeal(Bullet b, Tank t) {
		if (t.isLive() == true && b.isLive() == true && HitTank(b, t)) {
			b.setLive(false);
			t.setLive(false);
			
			try {
				booms.add(new Boom(t.getX(), t.getY()));
			} catch (IOException e) {
				System.out.println("爆炸效果加载失败~");
				e.printStackTrace();
			}
		}
	}

	public void allHitDeal(List<Tank> ts, List<Bullet> bs) {

		for (Bullet b : bs) {
			for (Tank t : ts) {
				hitDeal(b, t);
			}
		}
	}

	// 是否击中坦克函数
	private boolean HitTank(Bullet b, Tank t) {
		// 判断方向
		switch (t.getDirect()) {
		case UP:
		case DOWN:
			if (b.getX() > t.getX() - 5 && b.getX() < t.getX() + 15
					&& b.getY() > t.getY() + 5 && b.getY() < t.getY() + 25) {
				// System.out.println("击中坦克");
				return true;
			}
			break;
		case LEFT:
		case RIGHT:
			if (b.getX() > t.getX() && b.getX() < t.getX() + 30
					&& b.getY() > t.getY() && b.getY() < t.getY() + 30) {
				// System.out.println("击中坦克");
				return true;
			}
			break;
		}

		return false;
	}

	// 按钮动作监控
	@Override
	public void keyPressed(KeyEvent e) {
		// 按j发射子弹
		if (e.getKeyChar() == 'j') {
			System.out.println("发射");

			if (hero.getBullets().size() < 5) {
				Bullet b = hero.launchBullet();
				bullets.add(b);
			}
		}

		// 按上下左右坦克移动
		if (e.getKeyCode() == KeyEvent.VK_W) {
			hero.move(Direct.UP);
		}
		if (e.getKeyCode() == KeyEvent.VK_S) {
			hero.move(Direct.DOWN);
		}
		if (e.getKeyCode() == KeyEvent.VK_A) {
			hero.move(Direct.LEFT);
		}
		if (e.getKeyCode() == KeyEvent.VK_D) {
			hero.move(Direct.RIGHT);
		}
		this.repaint();
	}

	// 绘制坦克
	private void drawTank(Tank tank, Graphics g) {
		tank.draw(g);
	}

	private void drawBullet(Bullet bullet, Graphics g) {
		bullet.draw(g);
	}

	private void drawBoom(Boom boom, Graphics g, ImageObserver i) {
		boom.draw(g, i);
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

}
