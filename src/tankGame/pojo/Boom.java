package tankGame.pojo;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * 坦克死亡的爆炸效果
 * 
 * @author tjc
 *
 */
public class Boom extends Model {

	// 定义爆炸图片
	Image image1 = null;
	Image image2 = null;
	Image image3 = null;
	Image image4 = null;
	Image image5 = null;
	Image image6 = null;
	Image image7 = null;
	Image image8 = null;

	private static final int DEFAULT_LIFE = 8;

	public Boom(int x, int y) throws IOException {
		// 初始化图片,toolkit加载图片需要时间 ，爆炸时候都还没加载图片
		image1 = ImageIO.read(new File("src/blast1.gif"));
		image2 = ImageIO.read(new File("src/blast2.gif"));
		image3 = ImageIO.read(new File("src/blast3.gif"));
		image4 = ImageIO.read(new File("src/blast4.gif"));
		image5 = ImageIO.read(new File("src/blast5.gif"));
		image6 = ImageIO.read(new File("src/blast6.gif"));
		image7 = ImageIO.read(new File("src/blast7.gif"));
		image8 = ImageIO.read(new File("src/blast8.gif"));

		setX(x);
		setY(y);
		setLife(DEFAULT_LIFE);
		setLive(true);
	}

	public void draw(Graphics g, ImageObserver i) {
		// 画出炸弹
		try {
			Thread.sleep(90);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		switch (life) {
		case 8:
			g.drawImage(image8, x, y, 30, 30, i);
			break;
		case 7:
			g.drawImage(image7, x, y, 30, 30, i);
			break;
		case 6:
			g.drawImage(image6, x, y, 30, 30, i);
			break;
		case 5:
			g.drawImage(image5, x, y, 30, 30, i);
			break;
		case 4:
			g.drawImage(image4, x, y, 30, 30, i);
			break;
		case 3:
			g.drawImage(image3, x, y, 30, 30, i);
			break;
		case 2:
			g.drawImage(image2, x, y, 30, 30, i);
			break;
		case 1:
			g.drawImage(image1, x, y, 30, 30, i);
			break;
		}
		// 生命值减少
		lifeDown();
	//	 System.out.println(life);

	}

	private void lifeDown() {
		if (life == 0){
			isLive = false;
			return;
		}else{
			life = life - 1;
		}
	}
}
