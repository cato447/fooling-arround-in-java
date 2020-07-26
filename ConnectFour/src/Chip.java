import javax.imageio.ImageIO;
import javax.swing.text.Position;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Chip {
        private String path = "ConnectFour/res/yellowChip.png";
        private Point position;
        private boolean isRed;
        private Image chip;
        public Chip(String path, boolean isRed, int tileWidth, int tileHeight) {
            this.isRed = isRed;
            position = new Point();
            try {
                chip = ImageIO.read(new File(path)).getScaledInstance(tileWidth - 15,  tileHeight - 15, Image.SCALE_DEFAULT);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public Image getImage() { return chip; }

        public boolean isRed(){
            return isRed;
        }

        public void setPosition(int x, int y){
            position.setLocation(x, y);
        }

        public Point getPosition() {
            return position;
        }
}
