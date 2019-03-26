/*
参考URL
https://www.geekjob.jp/java-primer/2/
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

// メインクラス
public class Painter extends JFrame {

    public static void main (String[] args) {
        Painter frame = new Painter("さとPainter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // お絵かきエリア作成
        Canvas canvas = new Canvas();

        frame.add(canvas);

    }

    Painter (String title) {
        setTitle(title);

    }
}

