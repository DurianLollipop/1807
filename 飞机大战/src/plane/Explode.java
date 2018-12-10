package plane;

import java.awt.Graphics;
import java.awt.Image;

import util.GameUtil;

/**爆炸类
 * @author 15914
 *
 */
public class Explode {
	double x;
	double y;
	static Image[] imgs = new Image[8];//静态属性通过静态代码库初始化，如下
	static {
		for(int i=0;i<=8;i++) {
			imgs[i] = GameUtil.getImage("boom/e" + (i+1) + ".png");
			imgs[i].getWidth(null);//避免懒加载的问题，随便调用一个方法，图片才真实加载进来
		}
	}
	
	int count;
	
	public void draw(Graphics g) {
		if(count <=7) {
		g.drawImage(imgs[count], (int)x, (int)y, null);
		count++;	
		}	
	}
	
	public Explode(double x,double y) {
		this.x = x;
		this.y = y;
	}
	
//	public Explode() {
//	}
//	
}
