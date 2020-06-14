import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class Render {

    public static void createUI(int[] playfield){
        JFrame f = new JFrame("Swing Paint Demo");
        MyPanel myPanel = new MyPanel(playfield);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(myPanel);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

}

class MyPanel extends JPanel {
    Grid grid;
    GameCharacters gameCharacters;

    public MyPanel() {
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        grid = new Grid();
    }

    public MyPanel(int[] playfield){
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        grid = new Grid();
        gameCharacters = new GameCharacters(playfield);
    }

    public Dimension getPreferredSize() {
        return new Dimension(900,900);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        grid.paintGrid(g);
        gameCharacters.paintGameCharacters(g);
    }
}

class Grid{
    private final int TILE_X = 300;
    private final int TILE_Y = 300;

    public void paintGrid(Graphics g){
        g.setColor(Color.BLACK);
        //horizontal
        for (int i = 1; i < 3; i++) {
            Graphics2D g2d = (Graphics2D)g;
            g2d.setStroke(new BasicStroke(5));
            g2d.drawLine(0, TILE_Y*i, TILE_X*3, TILE_Y*i);
        }
        //vertical
        for (int i = 1; i < 3; i++){
            Graphics2D g2d = (Graphics2D)g;
            g2d.setStroke(new BasicStroke(5));
            g2d.drawLine(TILE_X*i, 0, TILE_X*i, TILE_Y*3);
        }
    }
}

class GameCharacters {
    CharacterX characterX = new CharacterX();
    CharacterO characterO = new CharacterO();

    private final int TILE_X = 300;
    private final int TILE_Y = 300;

    int[] playfield;

    public GameCharacters(int[] playfield) {
        this.playfield = playfield;
    }

    public void paintGameCharacters(Graphics g) {
        int actions = 0;
        for (int column = 0; column < 3; column++) {
            for (int row = 0; row < 3; row++) {
                if (playfield[actions] == 1) {
                    characterX.setX(TILE_X * row);
                    characterX.setY(TILE_Y * column);
                    characterX.paintX(g);
                } else if (playfield[actions] == -1) {
                    characterO.setX(TILE_X * row);
                    characterO.setY(TILE_Y * column);
                    characterO.paintO(g);
                }
                actions++;
            }
        }
    }

    class CharacterX {
        private int x;
        private int y;

        public void paintX(Graphics g) {
            Graphics2D g2d = (Graphics2D)g;
            g2d.setStroke(new BasicStroke(10));
            g2d.drawLine(x+25, y+25, x+275, y+275);
            g2d.drawLine(x+25, y +275, x+275, y+25);
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }
    }

    class CharacterO {
        private int x;
        private int y;

        public void paintO(Graphics g) {
            Graphics2D g2d = (Graphics2D)g;
            g2d.setStroke(new BasicStroke(10));
            g2d.drawOval(x + 25, y + 25, 250, 250);
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }
    }
}
