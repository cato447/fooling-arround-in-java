import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class Painter {

    private int board_w, board_h, tileWidth, tileHeight;
    private Panel panel;

    public Painter(Panel panel, int width, int height){
        this.panel = panel;
        board_w = width;
        board_h = height;
        tileWidth = board_w/7;
        tileHeight = board_h/6;
    }

    private Color holeBlue = new Color(61, 209, 165);

    public void paintBoard(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(2));
        for (int i = 0; i < board_w/tileWidth; i++){
            for (int j = 0; j < board_h/tileHeight; j++){
                g2d.setColor(holeBlue);
                g2d.fillOval(i * tileWidth + 10, j * tileHeight + 5, tileWidth - 15, tileHeight -  15);
                g2d.setColor(Color.BLACK);
                g2d.drawOval(i * tileWidth+ 10 , j * tileHeight+5, tileWidth - 15, tileHeight - 15);
            }
        }
    }

    public void paintRedChip(Graphics g, int x, int y) {
        String path = "ConnectFour/res/redChip.png";
        Graphics2D g2d = (Graphics2D) g;
        Chip redChip = new Chip(path, true, tileWidth, tileHeight);
        redChip.setPosition(x, y);
        panel.addToBoard(redChip, x, y);
        g2d.drawImage(redChip.getImage(), x * tileWidth + 10, y * tileHeight + 5, panel);
    }

    public void paintYellowChip(Graphics g, int x, int y) {
        String path = "ConnectFour/res/yellowChip.png";
        Graphics2D g2d = (Graphics2D) g;
        Chip yellowChip = new Chip(path, false, tileWidth, tileHeight);
        yellowChip.setPosition(x, y);
        panel.addToBoard(yellowChip, x, y);
        g2d.drawImage(yellowChip.getImage(), x , y , panel);
    }

}
