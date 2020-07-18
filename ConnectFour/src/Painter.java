import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;

public class Painter {

    private int board_w, board_h, tileWidth, tileHeight;

    public Painter(int width, int height){
        board_w = width;
        board_h = height;
        tileWidth = width/7;
        tileHeight = height/6;
    }

    private Color holeBlue = new Color(61, 209, 165);

    public void paintBoard(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(2));
        for (int i = 0; i < board_w/tileWidth; i++){
            for (int j = 0; j < board_h/tileHeight; j++){
                g2d.setColor(holeBlue);
                g2d.fillOval(i * tileWidth + 10, j * tileHeight + 5, tileWidth - 15, tileHeight -  20);
                g2d.setColor(Color.BLACK);
                g2d.drawOval(i * tileWidth+ 10 , j * tileHeight+5, tileWidth - 15, tileHeight - 20);
            }
        }
    }

    public void paintYellowChip(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g.drawImage(new redChip().getRedChip(), 0,0, g);
    }

    class redChip{
        private ImageIcon imageIcon;
        private Image redChip;
        private String path = "../res/redChip.png";
        public redChip(){
            imageIcon = new ImageIcon(path);
            redChip = imageIcon.getImage().getScaledInstance(tileWidth, tileHeight, 0);
        }

        public Image getRedChip() {
            return redChip;
        }
    }

    class yellowChip{
        private ImageIcon imageIcon;
        private Image redChip;
        private String path = "../res/yellowChip.png";
        public yellowChip(){
            imageIcon = new ImageIcon(path);
            redChip = imageIcon.getImage().getScaledInstance(tileWidth, tileHeight, 0);
        }

        public Image getRedChip() {
            return redChip;
        }
    }

}
