package plane;

import java.awt.Graphics;
import java.awt.Image;

import util.GameUtil;

/**��ը��
 * @author 15914
 *
 */
public class Explode {
	double x;
	double y;
	static Image[] imgs = new Image[8];//��̬����ͨ����̬������ʼ��������
	static {
		for(int i=0;i<=8;i++) {
			imgs[i] = GameUtil.getImage("boom/e" + (i+1) + ".png");
			imgs[i].getWidth(null);//���������ص����⣬������һ��������ͼƬ����ʵ���ؽ���
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
