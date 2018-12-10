package util;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.print.DocFlavor.URL;

import util.GameUtil;

public class GameUtil {
	private GameUtil() {}//工具类最好将构造器私有
	
	
	//方法一
//	public static Image getImage(String path) {
//		return Toolkit.getDefaultToolkit().getImage(GameUtil.class.getClassLoader().getResource(path));
//	}
	
	//方法二
		public static Image getImage(String path) {
			java.net.URL u = GameUtil.class.getClassLoader().getResource(path);
			BufferedImage img = null;
			try {
				img = ImageIO.read(u);
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
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
//				// TODO 自动生成的 catch 块
//				e.printStackTrace();
//			}
//			
//			return img;
//			
//		}
}
