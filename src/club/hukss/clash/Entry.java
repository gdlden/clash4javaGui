package club.hukss.clash;

import club.hukss.clashController.ClashController;

import javax.swing.*;
import java.awt.*;

public class Entry {
    public static void main(String[] args) {

        ClashController clashService = new ClashController();




        Rectangle rectangle = getMaximumScreenBounds();


        JFrame windows1=new JFrame("ClashForJavaGUI");
        //        JFrame windows2=new JFrame("窗口2");
        Container container1=windows1.getContentPane();//获得这个窗口的内容面板
        container1.setBackground(Color.white);//设置背景颜色
        windows1.setBounds((rectangle.width-800)/2,(rectangle.height-600)/2,800,600);//设置位置大小
//        windows2.setBounds(260,100,188,108);
        windows1.setVisible(true);//可视性设置
        windows1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//设置按x后的操作.[这个只是关闭那个窗口]
//        windows2.setVisible(true);
//        windows2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置按x后的操作.[这个是关闭整个程序,将会关闭所有窗口]


    }

    public static Rectangle getMaximumScreenBounds() {
        int minx=0, miny=0, maxx=0, maxy=0;
        GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        for(GraphicsDevice device : environment.getScreenDevices()){
            Rectangle bounds = device.getDefaultConfiguration().getBounds();
            minx = Math.min(minx, bounds.x);
            miny = Math.min(miny, bounds.y);
            maxx = Math.max(maxx,  bounds.x+bounds.width);
            maxy = Math.max(maxy, bounds.y+bounds.height);
        }
        return new Rectangle(minx, miny, maxx-minx, maxy-miny);
    }

}
