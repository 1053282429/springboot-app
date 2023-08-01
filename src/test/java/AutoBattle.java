import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class AutoBattle {
    public static void main(String[] args) throws Exception {
        String path = "D:\\ideaworkspace\\springboot-app\\src\\test\\java\\tess4j";
        // 截取屏幕图像
        Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        BufferedImage screenImg = new Robot().createScreenCapture(screenRect);

        // 保存截图到本地
        ImageIO.write(screenImg, "png", new File("screenshot.png"));

        // 图片识别
        ITesseract tesseract = new Tesseract();
        tesseract.setDatapath(path);
//        tesseract.setDatapath(LoadLibs.extractTessResources("tessdata").getAbsolutePath());
        tesseract.setLanguage("chi_sim");
        String text = tesseract.doOCR(screenImg);

        // 查找文字位置
        String[] words = text.split("\\s+");
        for (String word : words) {
            int index = text.indexOf(word);
            int x = index % screenImg.getWidth();
            int y = index / screenImg.getWidth();
            System.out.printf("The position of the word '%s' is: (%d, %d)\n", word, x, y);
        }
    }
}