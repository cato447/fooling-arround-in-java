package src;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Canvas;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Arrays;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Image extends Canvas {

    private JFrame frame;
    private BufferedImage img;
    private Color c;
    private File f;
    private ArrayList<File> files;
    private static int n;
    private KeyListener keys;

    public Image() {
        f = new File("/home/bitecoding/Bilder");
        files = new ArrayList<File>(Arrays.asList(f.listFiles()));
        c = null;
        n = 0;

        try {
            img = ImageIO.read(files.get(0));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        keys = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == ' '){
                        n++;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        };

        frame = new JFrame();
        frame.setSize(img.getWidth(), img.getHeight());
        frame.addKeyListener(keys);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);

        try {
            img = ImageIO.read(files.get(n%2));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        for (int x = 0; x < img.getWidth(); x++) {
            for (int y = 0; y < img.getHeight(); y++) {
                c = new Color(img.getRGB(x, y), true);
                g2d.setColor(c);
                g2d.drawLine(x, y, x, y);
            }
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        Image image = new Image();
        image.frame.add(image);

        int temp = 0;
        while (true){
            Thread.sleep(1);
            if (temp != n){
                image.repaint();
                temp = n;
                System.out.println(n);
            }
        }
    }
}
