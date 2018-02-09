package tangkGame.test;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import tankGame.pojo.Direct;
import tankGame.pojo.Enemy;
import tankGame.pojo.Hero;
import tankGame.pojo.Tank;

public class GameBox extends JFrame {

	private static final int DEFAULT_WIDTH = 400;
	private static final int DEFAULT_HEIGHT = 300;

	public GameBox() {
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MapPanel map = new MapPanel();
		add(map);
		setVisible(true);
	}

}

//地图制造
class MapPanel extends JPanel {

	Hero hero = null;
	int enSize = 3;
	List<Enemy> enemys = new ArrayList<>();

	public MapPanel() {
		hero = new Hero(200, 200, Direct.UP);

		//制造敌人
		for (int i = 0; i < enSize; i++) {
			Enemy et = new Enemy((i + 1) * 50, 100, Direct.DOWN);

			enemys.add(et);

		}
	}

	@Override
	public void paint(Graphics g) {
		super.paintComponent(g);
		g.fillRect(0, 0, 400, 300);

		if (null != hero)
			drawTank(hero, g);

		for (int i = 0; i < enemys.size(); i++) {
			drawTank(enemys.get(i),g);
		}
	}

	//画坦克
	private void drawTank(Tank tank, Graphics g) {
		tank.draw(g);
	}

}
