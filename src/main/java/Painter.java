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

// キャンバスを作成、描写するクラス
// ペンや消しゴムでクラス分けた方がよさげ
// 抽象クラスにしてしまう？
class Canvas extends JPanel implements MouseListener, MouseMotionListener {
    protected int x = -100;   // マウス座標x、将来的にクラス分けるかもなのでprotected
    protected int y = -100;   // マウス座標y、将来的にクラス分けるかもなのでprotected

    public Canvas () {
        addMouseListener(this);         // MouseListener追加
        addMouseMotionListener(this);   // MouseMotionListener追加

        setSize(800, 600);

    }

    @Override
    public void paintComponent (Graphics g) {
        g.setColor(Color.RED);
//        g.drawOval(100, 100, 50, 50);
        g.fillOval(x-5, y-5, 10, 10);
    }

    @Override
    public void mouseClicked(MouseEvent e) {    // 描写
        x = e.getX();   // クリック座標x
        y = e.getY();   // クリック座標y

        System.out.println("[CLICKED]" + x + "," + y);

        repaint();  // 描写する
    }

    @Override
    public void mousePressed(MouseEvent e) {    // MouseListener
    }

    @Override
    public void mouseReleased(MouseEvent e) {   // MouseListener
    }

    @Override
    public void mouseEntered(MouseEvent e) {    // MouseListener
    }

    @Override
    public void mouseExited(MouseEvent e) {     // MouseListener
    }


    @Override
    public void mouseDragged(MouseEvent e) {    // MouseMotionListener
        x = e.getX();
        y = e.getY();

        System.out.println("[DRAGGED]" + x + "," + y);

        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {      // MouseMotionListener
    }
}