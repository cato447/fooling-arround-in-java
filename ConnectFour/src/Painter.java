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
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
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

    public void paintChip(Graphics g, boolean isRed, int x, int y) {
        Graphics2D g2d = (Graphics2D) g;
        Chip chip = new Chip(isRed,x, y);
        chip.setPosition(x, y);
        panel.addToBoard(chip);
        g2d.drawImage(chip.getImage(), x * tileWidth + 10 , y * tileHeight + 5, panel);
    }

}
