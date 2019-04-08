/*
参考URL
https://www.geekjob.jp/java-primer/2/
http://www.siio.jp/index.php?SimpleDraw
https://qiita.com/hara-m/items/f101abe7835faa71fb4d
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
        CanvasTest canvasTest = new CanvasTest();
        frame.add(canvasTest);

    }

    Painter(String title) {
        this.setTitle(title);

    }
}

// キャンバスを作成、描写するクラス
// ペンや消しゴムでクラス分けた方がよさげ
// 抽象クラスにしてしまう？
class CanvasTest extends JPanel implements MouseListener, MouseMotionListener {
    private int newX;
    private int newY;
    private int lastX;
    private int lastY;

    CanvasTest () {
        this.addMouseListener(this);         // MouseListener追加
        this.addMouseMotionListener(this);   // MouseMotionListener追加
//        this.setSize(800, 600);

    }

//    @Override
//    public void paintComponent (Graphics g) {
//        g.setColor(Color.RED);
////        g.drawOval(100, 100, 50, 50);
//        g.fillOval(x-5, y-5, 10, 10);
//    }

    // ホントはdrawLineもクラス分けしたかったけど、うまくできない･･･
    // キャンバス作る機能と描写（ペン）機能って明確に別機能だしクラス分けた方がよさげなのだけれど･･･
    public void drawLine (int x1, int y1, int x2, int y2) {
        Graphics graphics = this.getGraphics();
        graphics.drawLine(x1, y1, x2, y2);

        System.out.println(x1 + ", " + y1 + ", " + x2 + ", " + y2);

    }

    @Override
    public void mouseClicked(MouseEvent e) {    // 描写　mouseを「押して＋離した」とき
        newX = e.getX();   // クリック座標x
        newY = e.getY();   // クリック座標y

        drawLine(lastX, lastY, newX, newY);
        System.out.println(lastX + ", " + lastY + ", " + newX + ", " + lastY);

        lastX = newX;
        lastY = newY;

//        System.out.println("[CLICKED]" + newX + "," + newY);

//        repaint();  // 描写する
    }

    @Override
    public void mousePressed(MouseEvent e) {    // MouseListener mouseを「押した」とき動作する、旧座標を現在座標に上書く
        lastX = e.getX();
        lastY = e.getY();

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
        newX = e.getX();
        newY = e.getY();

        drawLine(lastX, lastY, newX, newY);

        lastX = newX;
        lastY = newY;
    }

    @Override
    public void mouseMoved(MouseEvent e) {      // MouseMotionListener
    }
}

