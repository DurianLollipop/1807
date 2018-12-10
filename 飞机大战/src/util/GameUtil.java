package util;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.print.DocFlavor.URL;

import util.GameUtil;

public class GameUtil {
	private GameUtil() {}//��������ý�������˽��
	
	
	//����һ
//	public static Image getImage(String path) {
//		return Toolkit.getDefaultToolkit().getImage(GameUtil.class.getClassLoader().getResource(path));
//	}
	
	//������
		public static Image getImage(String path) {
			java.net.URL u = GameUtil.class.getClassLoader().getResource(path);
			BufferedImage img = null;
			try {
				img = ImageIO.read(u);
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
			
			return img;
			
		}
	

//		public static Image getImage(String path) {
//			
//			BufferedImage img = null;
//			try {
//				java.net.URL u = GameUtil.class.getClassLoader().getResource(path);
//				img = javax.imageio.ImageIO.read(u);
//			} catch (IOException e) {
//				// TODO �Զ����ɵ� catch ��
//				e.printStackTrace();
//			}
//			
//			return img;
//			
//		}
}
