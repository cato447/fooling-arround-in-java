import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Chip {
        private static int tileWidth, tileHeight = 100;
        private String red = "ConnectFour/res/redChip.png";
        private String yellow = "ConnectFour/res/yellowChip.png";
        private Point position;
        private boolean isRed;
        private Image chip;
        public Chip(boolean isRed, int x, int y) {
            this.isRed = isRed;
            position = new Point();
            position.setLocation(x, y);
            try {
                if (isRed){
                    chip = ImageIO.read(new File(red)).getScaledInstance(tileWidth - 15,  tileHeight - 15, Image.SCALE_DEFAULT);
                } else {
                    chip = ImageIO.read(new File(yellow)).getScaledInstance(tileWidth - 15,  tileHeight - 15, Image.SCALE_DEFAULT);
                }
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
