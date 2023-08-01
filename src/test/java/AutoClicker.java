import java.awt.*;
import java.awt.event.InputEvent;

public class AutoClicker {

    private int[] x = {2361, 1791, 2209};
    private int[] y = {1150, 736, 1049};
    private Robot robot;
    private int timeout = 10; // 等待超时时间，单位为秒
    private int threshold = 30; // RGB 阈值

    public AutoClicker() {
        try {
            this.robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

//    public void initXY() {
//        for (int i = 0; i < 3; i++) {
//            System.out.println("请点击第" + (i + 1) + "处位置");
//            try {
//                Thread.sleep(3000); // 等待 1 秒钟
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            java.awt.Point p = java.awt.MouseInfo.getPointerInfo().getLocation();
//            this.x[i] = p.x;
//            this.y[i] = p.y;
//            System.out.println("X: " + this.x[i] + ", Y: " + this.y[i]);
//        }
//    }

//    public void initXY() {
//        try {
//            Robot robot = new Robot();
//            for (int i = 0; i < 3; i++) {
//                System.out.println("请点击第" + (i + 1) + "处位置");
//                robot.delay(1000); // 等待1秒
//                robot.mouseMove(x[i], y[i]);
//                robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//                robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//                robot.delay(500); // 暂停0.5秒，避免操作过快
//            }
//        } catch (AWTException e) {
//            e.printStackTrace();
//        }
//    }
    public void click(int x, int y) {
        this.robot.mouseMove(x, y);
        this.robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        this.robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }

    public void auto() {
        try {
            Thread.sleep(1000); // 等待 1 秒钟
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        click(this.x[0], this.y[0]);
        try {
            Thread.sleep(1000); // 等待 1 秒钟
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Color color = this.robot.getPixelColor(this.x[1], this.y[1]);
        int sum1 = color.getRed() + color.getGreen() + color.getBlue();
        long start = System.currentTimeMillis();
        while (true) {
            color = this.robot.getPixelColor(this.x[1], this.y[1]);
            int sum2 = color.getRed() + color.getGreen() + color.getBlue();
            if (sum1 - sum2 > this.threshold) {
                click(this.x[2], this.y[2]);
                try {
                    Thread.sleep(1000); // 等待 1 秒钟
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                click(this.x[2], this.y[2]);
                break;
            }
            long end = System.currentTimeMillis();
            if (end - start > this.timeout * 1000) {
                click(this.x[0], this.y[0]);
                System.out.println("retry");
                break;
            }
        }
        auto();
    }

    public void test(){
        int[] x = {1404, 1760};
        int[] y = {815, 792};
        for (int i = 0; i < 2; i++) {
            try {
                click(x[i],y[i]);
                Thread.sleep(3000);
                click(x[i],y[i]);
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        test();
    }

    public void click(){
        try {
            click(1015,906);
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        click();
    }


    public static void main(String[] args) {
        AutoClicker clicker = new AutoClicker();
        clicker.click();
    }
}
