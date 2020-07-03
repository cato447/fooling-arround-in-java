package sprites.spaceship;

import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class SpaceShip {

    private int dx;
    private int dy;
    private int x = 40;
    private int y = 60;
    private int w;
    private int h;
    private Image image;

    public SpaceShip() {

        loadImage();
    }

    private void loadImage() {

        ImageIcon ii = new ImageIcon("/home/bitecoding/Pictures/spaceship.png");
        image = ii.getImage().getScaledInstance(50,50,1);

        w = image.getWidth(null);
        h = image.getHeight(null);
    }

    public void move() {

        x += dx;
        y += dy;
    }

    public int getX() {

        return x;
    }

    public int getY() {

        return y;
    }

    public int getWidth() {

        return w;
    }

    public int getHeight() {

        return h;
    }

    public Image getImage() {

        return image;
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        switch(key){
            case KeyEvent.VK_A:
                dx = -2;
                break;
            case KeyEvent.VK_D:
                dx = 2;
                break;
            case KeyEvent.VK_W:
                dy = -2;
                break;
            case KeyEvent.VK_S:
                dy = 2;
                break;
            default:
                break;
        }
    }

    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        switch(key){
            case KeyEvent.VK_A:
                dx = 0;
                break;
            case KeyEvent.VK_D:
                dx = 0;
                break;
            case KeyEvent.VK_W:
                dy = 0;
                break;
            case KeyEvent.VK_S:
                dy = 0;
                break;
            default:
                break;
        }
    }
}